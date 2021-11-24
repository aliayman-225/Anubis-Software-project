
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ali
 */
public class Authentication {

    private ArrayList<Driver> drivers;
    private ArrayList<Passenger> passengers;
    private ArrayList<Ride> rides;
    private static Authentication instance;
    Scanner input = new Scanner(System.in);

    private Authentication() {
        drivers = new ArrayList<Driver>();
        passengers = new ArrayList<Passenger>();
        rides = new ArrayList<Ride>();
    }

    public static Authentication getAuthentication() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

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

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public void setRides(ArrayList<Ride> rides) {
        this.rides = rides;
    }

    public boolean checkUser(User user2, User user) // function to check if the username and password matches in the data base
    {
        if ((user2.getUsername().equals(user.getUsername())) && (user2.getPassword().equals(user.getPassword()))) {
            return true;
        } else {
            return false;
        }
    }

    public User login(User user) {
        if (user.getClass().getName().equals("Passenger")) {
            for (int i = 0; i < passengers.size(); i++) {
                            System.out.println(this.checkUser(passengers.get(i), user));
                if (this.checkUser(passengers.get(i), user)) {
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
                if (this.checkUser(drivers.get(i), user)) {
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

    public boolean SignUp(User user) {

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
            return true;

        } else if (user.getClass().getName().equals("Driver")) {
            drivers.add((Driver) user);
            return true;
        } else {
            return false;
        }

    }
}
