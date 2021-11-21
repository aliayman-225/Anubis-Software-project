/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ali
 */
public class Admin {

    Scanner input = new Scanner(System.in);
    Authentication authentication;

    public Admin(Authentication authentication) {
        this.authentication = authentication;
    }

    public boolean activate(String username) {
        for (int i = 0; i < authentication.getDrivers().size(); i++) {
            if ((authentication.getDrivers().get(i).getUsername().equals(username))) {
                if (authentication.getDrivers().get(i).isSuspendedAccount()) {
                    authentication.getDrivers().get(i).setSuspendedAccount(false);
                    System.out.println("Activated");
                    return true;
                } else {
                    System.out.println("Already activated");
                    return true;
                }
            }
        }
        for (int i = 0; i < authentication.getPassengers().size(); i++) {
            if ((authentication.getPassengers().get(i).getUsername().equals(username))) {
                if (authentication.getPassengers().get(i).isSuspendedAccount()) {
                    authentication.getPassengers().get(i).setSuspendedAccount(false);
                    System.out.println("Activated");
                    return true;
                } else {
                    System.out.println("Already activated");
                    return true;
                }
            }

        }
        return false;
    }

    public boolean suspend(String username) {
        for (int i = 0; i < authentication.getDrivers().size(); i++) {
            if ((authentication.getDrivers().get(i).getUsername().equals(username))) {
                if (!authentication.getDrivers().get(i).isSuspendedAccount()) {
                    authentication.getDrivers().get(i).setSuspendedAccount(true);
                    System.out.println("Suspended");
                    return true;
                } else {
                    System.out.println("Already Suspended");
                    return true;
                }
            }

        }
        for (int i = 0; i < authentication.getPassengers().size(); i++) {
            if ((authentication.getPassengers().get(i).getUsername().equals(username))) {
                if (!authentication.getPassengers().get(i).isSuspendedAccount()) {
                    authentication.getPassengers().get(i).setSuspendedAccount(true);
                    System.out.println("Suspended");
                    return true;
                } else {
                    System.out.println("Already Suspended");
                    return true;
                }
            }

        }

        return false;
    }

    public ArrayList<Driver> listAllPendingDrivers() {
        ArrayList<Driver> pendingDrivers = new ArrayList<Driver>();
        for (int i = 0; i < authentication.getDrivers().size(); i++) {
            if (authentication.getDrivers().get(i).isSuspendedAccount()) {
                pendingDrivers.add(authentication.getDrivers().get(i));
            }
        }
        return pendingDrivers;
    }
}
