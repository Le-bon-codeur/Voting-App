/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp3.controller;

import votingapp3.model.*;
import votingapp3.model.dao.*;
import votingapp3.view.AdministratorView;
import votingapp3.view.VotingView;

/**
 *
 * @author pilou
 */
public class LoginController {
    private final int user_type;
    private final String user_hash;
    
    private final CitizenDaoImpl citizenDaoImpl;
    private final CandidateDaoImpl candidateDaoImpl;
    private final AdminDaoImpl adminDaoImpl;

    public LoginController(int type, int id, String hash) {
        user_type = type;
        user_hash = hash;
        switch (user_type) {
            case 1 -> {
                citizenDaoImpl = new CitizenDaoImpl(new Citizen(id));
                candidateDaoImpl = null;
                adminDaoImpl = null;
            }
            case 2 -> {
                citizenDaoImpl = null;
                candidateDaoImpl = new CandidateDaoImpl(new Candidate(id));
                adminDaoImpl = null;
            }
            case 3 -> {
                citizenDaoImpl = null;
                candidateDaoImpl = null;
                adminDaoImpl = new AdminDaoImpl(new Admin(id));
            }
            default -> throw new AssertionError();
        }
    }
    
    public Boolean isLog() {
        switch (user_type) {
            case 1 -> {return citizenDaoImpl.log(user_hash);}
            case 2 -> {return candidateDaoImpl.log(user_hash);}
            case 3 -> {return adminDaoImpl.log(user_hash);}
            default -> throw new AssertionError();
        }
    }
    
    public void routeUser() {
        switch (user_type) {
            case 1 -> {new VotingView(citizenDaoImpl.getCitizen()).setVisible(true);}
            case 2 -> {}
            case 3 -> {new AdministratorView(adminDaoImpl.getAdmin()).setVisible(true);}
            default -> throw new AssertionError();
        }
    }
}
