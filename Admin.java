/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Admin extends User {

    public static ArrayList<Driver> pendingDrivers = new ArrayList <Driver>();

    public Admin(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password);
    }

    public void verifyRegistration( Driver u) // for now return true for all Users 
    {
    u.setSuspendedAccount(false);
    }
    
    public ArrayList<Driver> listAllPendingDrivers(){
        return pendingDrivers;
    }
    public void suspendAccount( Driver u){
    u.setSuspendedAccount(true);
    }

}
