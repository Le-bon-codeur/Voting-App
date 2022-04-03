/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package votingapp3.controller;

import java.time.LocalDate;
import votingapp3.model.Admin;
import votingapp3.model.Citizen;
import votingapp3.model.dao.AdminDaoImpl;

/**
 *
 * @author pilou
 */
public class AdminController {
    
    private final AdminDaoImpl adminDaoImpl;
    private final Admin administrator;

    public AdminController(Admin admin) {
        this.administrator = admin;
        this.adminDaoImpl = new AdminDaoImpl(admin);
    }
    
    
    public Boolean delete(Citizen c) throws Exception {
        if(c == null)
            return false;
        return adminDaoImpl.delete(c) == 1;
    }
    
    public String create(String[] args) throws Exception {
        if("Lastname".equals(args[1]) || "".equals(args[1]) || args[1] == null)
            throw new Exception("You need to complete the Lastname!");
        if("Firstname".equals(args[2]) || "".equals(args[2]) || args[2] == null)
            throw new Exception("You need to complete the Firstname!");
        if("Location".equals(args[3]) || "".equals(args[3]) || args[3] == null)
            throw new Exception("You need to complete the Location!");
        if("n".equals(args[5]) || "".equals(args[5]) || args[5] == null)
            throw new Exception("You need to select a gender!");
        if("Birthdate".equals(args[4]) || "".equals(args[4]) || args[4] == null)
            throw new Exception("You need to complete the Birthdate!");
        
        String date[] = args[4].split("-");
        LocalDate dob = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        Citizen c = new Citizen(Integer.parseInt(args[0]), args[5], args[2], args[1], args[3], dob, 0, 0); // dernier = vote id --> generer un nouveau
        return adminDaoImpl.createCit(c);
    }
    
    public Boolean update(Citizen c, String[] args) throws Exception {
        // id, lname, fname, loc, dob, gender
        
        if(!args[1].equals(c.getLname()))
            c.setLname(args[1]);
        if(!args[2].equals(c.getFname()))
            c.setFname(args[2]);
        if(!args[3].equals(c.getLocation()))
            c.setLocation(args[3]);
        if(args[5].equals("Male"))
            c.setGender("b");
        else if(args[5].equals("Female"))
            c.setGender("g");
        else
            throw new Exception("The gender is incorrect.");
        
        String date[] = args[4].split("-");
        LocalDate dob = LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        if(!dob.equals(c.getDob()))
            c.setDob(dob);
        
        return adminDaoImpl.modify(c);
    }
    
    public Citizen search(int id) throws Exception {
        return adminDaoImpl.searchCit(id);
    }
    
}
