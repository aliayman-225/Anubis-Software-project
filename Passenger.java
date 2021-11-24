import java.util.ArrayList;

/**
 *
 * @author Reem
 */
public class Passenger extends User {

    ArrayList<String> notifications = new ArrayList<String>();

    public Passenger(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password);
    }

    public void rateDriver(int rate, Driver driver) {
        driver.getRateHistory().add(this.getUsername());
        driver.getRateHistory().add(String.valueOf(rate));
        driver.setAverageRate();

    }

    public double checkDriverRate(Driver driver) {

        return driver.getAverageRate();
    }

    public void requestRide(String source, String destination, Authentication authentication) //true untile Rider Class is implemented
    {
        Ride ride = new Ride(source, destination, this);
        for (int i = 0; i < authentication.getDrivers().size(); i++) {
            if (authentication.getDrivers().get(i).getFavAreas().contains(source)) {
                authentication.getDrivers().get(i).getPendingRides().add(ride);
            }
        }
        System.out.println("Your ride is waiting for a captain");
        authentication.getRides().add(ride);
    }

    public void getNotifications() {
        for (int i = 0; i < notifications.size(); i++) {
            System.out.println(notifications.get(i));
        }

    }

}
