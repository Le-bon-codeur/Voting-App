/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp3.model.dao;

import java.sql.*;
import java.time.LocalDate;
import votingapp3.model.Citizen;

/**
 *
 * @author pilou
 */
public class CitizenDaoImpl implements usersDao {
    
    private final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/voteit_maindb";
    private final String DB_USERNAME = "classic_user_voteit";
    private final String DB_PASSWORD = "TheUserPassword";
    
    private final Citizen citizen;
    private Connection conn;

    public CitizenDaoImpl(Citizen citizen) {
        this.citizen = citizen;
        dbConnect();
    }

    public Citizen getCitizen() {
        return citizen;
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
            if(conn == null)
                return false;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = " + this.citizen.getId() + " AND us_hash_pw = \"" + hash + "\";");
            
            if(!rs.next()) {
                System.out.println("Wrong password or user id.");
                return false;
            } else {
                this.citizen.setFname(rs.getString("us_f_name"));
                this.citizen.setLname(rs.getString("us_l_name"));
                String date[] = rs.getString("us_date_of_birth").split("-");
                this.citizen.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                this.citizen.setGender(rs.getString("us_gender"));
                this.citizen.setLocation(rs.getString("us_location"));
                
                
                ResultSet rs2 = stmt.executeQuery("SELECT * FROM citizens WHERE us_id = " + this.citizen.getId() + ";");
                if(rs2.next()){
                    this.citizen.setNbrVotes(rs2.getInt("ci_vote_nbr"));
                    this.citizen.setVoteId(rs2.getInt("ci_vote_id"));
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
    public Citizen search(int id) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE us_id = (SELECT us_id FROM candidates WHERE ca_id =" + id + " );");
            if(rs.next()){
                this.citizen.setId(Integer.parseInt(rs.getString("us_id")));
                this.citizen.setFname(rs.getString("us_f_name"));
                this.citizen.setLname(rs.getString("us_l_name"));
                String date[] = rs.getString("us_date_of_birth").split("-");
                this.citizen.setDob(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
                this.citizen.setGender(rs.getString("us_gender"));
                this.citizen.setLocation(rs.getString("us_location"));
                rs = stmt.executeQuery("SELECT * FROM citizens WHERE us_id = " + id + ";");
                if(rs.next()) {
                    this.citizen.setNbrVotes(rs.getInt("ci_vote_nbr"));
                    this.citizen.setVoteId(rs.getInt("ci_vote_id"));
                    return this.citizen;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return null;
        }
    }

    @Override
    public int vote(int ca_id) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM votes WHERE ci_vote_id = " + this.citizen.getVoteId());
            if(rs.next()) {
                // create error: already voted
                return -1;
            } else {
                stmt.executeUpdate("INSERT INTO votes VALUES (" + this.citizen.getVoteId() + "," + ca_id + ",\"" + LocalDate.now() + "\",\"" + this.citizen.getLocation() + "\");");
                return 1;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
            return -1;
        }
    }

}
