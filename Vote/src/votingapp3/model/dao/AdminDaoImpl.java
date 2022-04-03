package votingapp3.model.dao;

import java.sql.*;
import java.time.LocalDate;
import votingapp3.VotingApp3;
import votingapp3.model.*;
import static votingapp3.VotingApp3.sha;

public class AdminDaoImpl implements usersDao {
    
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/voteit_maindb";
    private final String DB_USERNAME = "administrator_voteit";
    private final String DB_PASSWORD = "TheAdminPassword";
    
    private final Admin admin;
    private Connection conn;

    public AdminDaoImpl(Admin admin) {
        this.admin = admin;
        dbConnect();
    }

    public Admin getAdmin() {
        return admin;
    }
    
    @Override
    public final void dbConnect() {
        try {
            Class.forName(DB_DRIVER);
            this.conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
        
    }

    @Override
    public Boolean log(String hash) {       
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + this.admin.getId() + " AND us_hash_pw = \"" + hash + "\";");
            
            if(rs.next()) {
                this.admin.setFname(rs.getString("us_f_name"));
                this.admin.setLname(rs.getString("us_l_name"));
                String date[] = rs.getString("us_date_of_birth").split("-");
                this.admin.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                this.admin.setGender(rs.getString("us_gender"));
                this.admin.setLocation(rs.getString("us_location"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public Object search(int id) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + id + ";");
            
            if(rs.next()) {
                String Fname = rs.getString("us_f_name");
                String Lname = rs.getString("us_l_name");
                String date[] = rs.getString("us_date_of_birth").split("-");
                LocalDate Dob = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
                String Gender = rs.getString("us_gender");
                String Location = rs.getString("us_location");
                rs = stmt.executeQuery("SELECT * FROM citizens WHERE us_id = " + id + ";");
                if(rs.next()) {
                    int NbrVotes = rs.getInt("ci_vote_nbr");
                    int VoteId = rs.getInt("ci_vote_id");
                    return new Citizen(id, Gender, Fname, Lname, Location, Dob, NbrVotes, VoteId);
                } else {
                    rs = stmt.executeQuery("SELECT * FROM candidates WHERE us_id = " + id + ";");
                    if(rs.next()) {
                        String Description = rs.getString("ca_description");
                        int CaId = Integer.parseInt(rs.getString("ca_id"));
                        String PoliticParty = rs.getString("ca_politic_party");
                        return new Candidate(PoliticParty, Description, id, Gender, Fname, Lname, Location, Dob, CaId);
                    } else {
                        rs = stmt.executeQuery("SELECT * FROM administrators WHERE us_id = " + id + ";");
                        if(rs.next()) {
                            return new Admin(id, Gender, Fname, Lname, Location, Dob);
                        } else {
                            return null;
                        }
                    }
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public Citizen searchCit(int id) throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + id + ";");
        
        if(rs.next()) {
            String Fname = rs.getString("us_f_name");
            String Lname = rs.getString("us_l_name");
            String date[] = rs.getString("us_date_of_birth").split("-");
            LocalDate Dob = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
            String Gender = rs.getString("us_gender");
            String Location = rs.getString("us_location");
            rs = stmt.executeQuery("SELECT * FROM citizens WHERE us_id = " + id + ";");
            if(rs.next()) {
                int NbrVotes = rs.getInt("ci_vote_nbr");
                int VoteId = rs.getInt("ci_vote_id");
                return new Citizen(id, Gender, Fname, Lname, Location, Dob, NbrVotes, VoteId);
            } else
                throw new Exception("An error occured during the research, please try again!");
        } else
            throw new Exception("The citizen with id " + id + " does not exists!");
    }

    @Override
    public int vote(int ca_id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private int newVoteid() throws Exception{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(ci_vote_id) AS max_vote_id FROM citizens;");
        int max_vote_id = 0;
        while(rs.next())
            max_vote_id = rs.getInt("max_vote_id");
        return max_vote_id + 1;
    }

    public String createCit(Citizen cit) throws Exception {
        if( search( cit.getId() ) == null ){
            String pw = VotingApp3.generatePassword();
            String hash = sha(pw);
            String querry = "INSERT INTO users VALUES (" + cit.getId() + ",\"" + hash + "\",\"" + cit.getFname() + "\",\"" + cit.getLname() + "\",\"" + cit.getGender() + "\",\"" + cit.getLocation() + "\",\"" + cit.getDob() + "\");";
            String querry2 = "INSERT INTO citizens VALUES (" + cit.getId() + "," + newVoteid() + ",0);";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(querry);
            stmt.executeUpdate(querry2);
            return pw;
        } else
            throw new Exception("The citizen with id " + cit.getId() + " alredy exists");
    }
    
    public int create(Candidate can) throws Exception {
        if( search( can.getId() ) == null ){
            String querry = "INSERT INTO users VALUES (" + can.getId() + ",\"" + sha("defaultpw") + "\",\"" + can.getFname() + "\",\"" + can.getLname() + "\",\"" + can.getGender() + "\",\"" + can.getLocation() + "\",\"" + can.getDob() + "\");";
            String querry2 = "INSERT INTO candidates VALUES (" + can.getId() + "," + can.getCaId() + ",\"" + can.getPoliticParty() + "\",\"" + can.getDescription() + "\");";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(querry);
            stmt.executeUpdate(querry2);
            return 1;
        } else
            throw new Exception("The candidate with id " + can.getId() + " alredy exists");
    }
    
    public int create(Admin adm) throws Exception {
        if( search( adm.getId() ) == null ){
            String querry = "INSERT INTO users VALUES (" + adm.getId() + ",\"" + sha("defaultpw") + "\",\"" + adm.getFname() + "\",\"" + adm.getLname() + "\",\"" + adm.getGender() + "\",\"" + adm.getLocation() + "\",\"" + adm.getDob() + "\");";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(querry);
            return 1;
        } else
            throw new Exception("The admin with id " + adm.getId() + " alredy exists");
    }
    
    public int delete(Citizen cit) throws Exception {
        if( search( cit.getId() ) != null ){
            String querry = "DELETE FROM citizens WHERE us_id = " + cit.getId() + ";";
            String querry2 = "DELETE FROM users WHERE us_id = " + cit.getId() + ";";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(querry);
            stmt.executeUpdate(querry2);
            return 1;
        } else
            throw new Exception("The citizen with id " + cit.getId() + " does not exists");
    }
    
    public int delete(Candidate can) throws Exception {
        if( search( can.getId() ) != null ){
            String querry = "DELETE FROM candidates WHERE us_id = " + can.getId() + ";";
            String querry2 = "DELETE FROM users WHERE us_id = " + can.getId() + ";";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(querry);
            stmt.executeUpdate(querry2);
            return 1;
        } else
            throw new Exception("The candidate with id " + can.getId() + " does not exists");
    }
    
    public int delete(Admin adm) throws Exception {
        if( search( adm.getId() ) != null ){
            String querry = "DELETE FROM administrators WHERE us_id = " + adm.getId() + ";";
            String querry2 = "DELETE FROM users WHERE us_id = " + adm.getId() + ";";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(querry);
            stmt.executeUpdate(querry2);
            return 1;
        } else
            throw new Exception("The admin with id " + adm.getId() + " does not exists");
    }
    
    public Boolean modify(Citizen cit) throws Exception {
        
        String querry  = "UPDATE users SET "
                + "us_f_name = \"" + cit.getFname() + "\" ,"
                + "us_l_name = \"" + cit.getLname() + "\" ,"
                + "us_gender = \"" + cit.getGender()+ "\" ,"
                + "us_location = \"" + cit.getLocation()+ "\" ,"
                + "us_date_of_birth = \"" + cit.getDob()+ "\" "
                + " WHERE us_id = " + cit.getId() + ";";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(querry);
        return true;
        
    }
    
    public int modify(Candidate can) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public int modify(Admin adm) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
