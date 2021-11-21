/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.project;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Authentication {

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    private ArrayList<Driver> drivers;
    private ArrayList<Passenger> passengers;
    private static Authentication instance;
    Scanner input = new Scanner(System.in);

    private Authentication() {
        drivers = new ArrayList<Driver>();
        passengers = new ArrayList<Passenger>();
    }

    public static Authentication getAuthentication() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    public User login(String username, String password, UserType type) {
        if (type == UserType.PASSENGER) {
            for (int i = 0; i < passengers.size(); i++) {
                if ((passengers.get(i).getUsername().equals(username)) && (passengers.get(i).getPassword().equals(password))) {
                    System.out.println("Correct user name");
                    System.out.println("correct password");
                    if (passengers.get(i).isSuspendedAccount()) {
                        System.out.println("This account suspended by the admin");
                        return null;
                    }
                    return passengers.get(i);
                }
            }
            System.out.println("Incorrect username or password");
        } else if (type == UserType.DRIVER) {
            for (int i = 0; i < drivers.size(); i++) {
                if ((drivers.get(i).getUsername().equals(username)) && (drivers.get(i).getPassword().equals(password))) {
                    System.out.println("Correct user name");
                    System.out.println("correct password");
                    if (drivers.get(i).isSuspendedAccount()) {
                        System.out.println("This account not verified yet by the admin");
                        return null;
                    }
                    return drivers.get(i);
                }
            }
            System.out.println("Incorrect username or password");
        }
        return null;
    }

    public boolean SignUp(String username, String email, String password, String mobileNumber, UserType type) {
        while (true) {
            for (int i = 0; i < passengers.size(); i++) {
                if (username.equals(passengers.get(i).getUsername())) {
                    return false;
                }

            }
            for (int i = 0; i < drivers.size(); i++) {
                if (username.equals(drivers.get(i).getUsername())) {
                    System.out.println(drivers.get(i).getUsername()+" : "+username);
                    return false;
                }

            }
            if (type == UserType.PASSENGER) {

                Passenger onthefly = new Passenger(username, mobileNumber, email, password);
                passengers.add(onthefly);
                break;

            } else if (type == UserType.DRIVER) {
                System.out.println("Enter Driver Licsense number");
                String driverLiscenseNumber = input.nextLine();
                System.out.println("Enter National ID");
                String nationalID = input.nextLine();
                Driver onthefly = new Driver(username, mobileNumber, email, password, driverLiscenseNumber, nationalID);
                drivers.add(onthefly);
                break;
            }

        }
        return true;
    }



}