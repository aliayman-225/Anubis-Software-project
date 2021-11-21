
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ali
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

    public User login(User user) {
        if (user.getClass().getName().equals("Passenger")) {
            for (int i = 0; i < passengers.size(); i++) {
                if ((passengers.get(i).getUsername().equals(user.getUsername())) && (passengers.get(i).getPassword().equals(user.getPassword()))) {
                    System.out.println("====== Welcome " + passengers.get(i).getUsername() + " ======");
                    if (passengers.get(i).isSuspendedAccount()) {
                        System.out.println("This account suspended by the admin");
                        return null;
                    }
                    return passengers.get(i);
                }
            }
            System.out.println("Incorrect username or password");
        } else if (user.getClass().getName().equals("Driver")) {
            for (int i = 0; i < drivers.size(); i++) {
                if ((drivers.get(i).getUsername().equals(user.getUsername())) && (drivers.get(i).getPassword().equals(user.getPassword()))) {

                    if (drivers.get(i).isSuspendedAccount()) {
                        System.out.println("This account not verified yet by the admin");
                        return null;
                    }
                    System.out.println("====== Welcome  captain " + drivers.get(i).getUsername() + " ======");
                    return drivers.get(i);
                }
            }
            System.out.println("Incorrect username or password");
        }
        return null;
    }

    public boolean SignUp(User user) {
        while (true) {
            for (int i = 0; i < passengers.size(); i++) {
                if (user.getUsername().equals(passengers.get(i).getUsername())) {
                    return false;
                }
            }
            for (int i = 0; i < drivers.size(); i++) {
                if (user.getUsername().equals(drivers.get(i).getUsername())) {
                    return false;
                }
            }
            if (user.getClass().getName().equals("Passenger")) {
                passengers.add((Passenger) user);
                break;

            } else if (user.getClass().getName().equals("Driver")) {
                drivers.add((Driver) user);
                break;
            }

        }
        return true;
    }

}
