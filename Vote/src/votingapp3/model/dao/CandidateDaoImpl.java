package votingapp3.model.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import votingapp3.model.Candidate;

public class CandidateDaoImpl implements usersDao {
    
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/voteit_maindb";
    private final String DB_USERNAME = "classic_user_voteit";
    private final String DB_PASSWORD = "TheUserPassword";
    
    private final Candidate candidate;
    private Connection conn;

    public CandidateDaoImpl(Candidate candidate) {
        this.candidate = candidate;
        dbConnect();
    }

    public Candidate getCandidate() {
        return candidate;
    }

    
    
    @Override
    public final void dbConnect() {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CandidateDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            conn = null;
        }
    }

    @Override
    public Boolean log(String hash) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + this.candidate.getId() + " AND us_hash_pw = \"" + hash + "\";");
            if(!rs.next()) {
                System.out.println("Wrong password or user id.");
                return false;
            } else {
                this.candidate.setFname(rs.getString("us_f_name"));
                this.candidate.setLname(rs.getString("us_l_name"));
                String date[] = rs.getString("us_date_of_birth").split("-");
                this.candidate.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                this.candidate.setGender(rs.getString("us_gender"));
                this.candidate.setLocation(rs.getString("us_location"));
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM candidates WHERE us_id = " + this.candidate.getId() + ";");
                if(rs2.next()){
                    this.candidate.setDescription(rs2.getString("ca_description"));
                    this.candidate.setCaId(Integer.parseInt(rs2.getString("ca_id")));
                    this.candidate.setPoliticParty(rs2.getString("ca_politic_party"));
                } else {
                    System.out.println("Problem with vote id, contact your local administration!");
                    return false;
                }
                System.out.println("Successfully connected.");
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
    
    @Override
    public Candidate search(int id) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = (SELECT us_id FROM candidates WHERE ca_id =" + id + " );");
            if(rs.next()){
                this.candidate.setId(Integer.parseInt(rs.getString("us_id")));
                this.candidate.setFname(rs.getString("us_f_name"));
                this.candidate.setLname(rs.getString("us_l_name"));
                String date[] = rs.getString("us_date_of_birth").split("-");
                this.candidate.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                this.candidate.setGender(rs.getString("us_gender"));
                this.candidate.setLocation(rs.getString("us_location"));
                this.candidate.setCaId(id);
                rs = stmt.executeQuery("SELECT * FROM candidates WHERE ca_id = " + this.candidate.getCaId()+ "");
                if(rs.next()) {
                    this.candidate.setDescription(rs.getString("ca_description"));
                    this.candidate.setPoliticParty(rs.getString("ca_politic_party"));
                    return this.candidate;
                } else
                    return null;
            } else
                return null;
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    @Override
    public int vote(int ca_id) {
        throw new UnsupportedOperationException("Not supported for candidate.");
    }
    
    public int getNbrCand() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) as nbr FROM candidates");
            if(rs.next())
                return rs.getInt("nbr");
            else
                return -1;
        } catch (SQLException ex) {
            System.err.println(ex);
            return -1;
        }
    }
    
}
