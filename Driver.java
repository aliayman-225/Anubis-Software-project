
import java.util.ArrayList;

/**
 *
 * @author Ali
 */
public class Driver extends User {

    private ArrayList<String> favAreas = new ArrayList<String>();
    private ArrayList<Ride> pendingRides = new ArrayList<Ride>();
    private ArrayList<String> rateHistory = new ArrayList<String>();
    double averageRate = 0.0;
    private String driverLicenseNumber, nationalID;
    
    public Driver(String username, String mobileNumber, String email, String password, String driverLicenseNumber, String nationalID) {
        super(username, mobileNumber, email, password);
        this.driverLicenseNumber = driverLicenseNumber;
        this.nationalID = nationalID;
    }
    public ArrayList<String> getRateHistory() {
        return rateHistory;
    }

    public void setRateHistory(ArrayList<String> RateHistory) {
        this.rateHistory = RateHistory;
    }

    public ArrayList<String> getFavAreas() {
        return favAreas;
    }

    public void setFavAreas(ArrayList<String> favAreas) {
        this.favAreas = favAreas;
    }

    public ArrayList<Ride> getPendingRides() {
        return pendingRides;
    }

    public void setPendingRides(ArrayList<Ride> pendingRides) {
        this.pendingRides = pendingRides;
    }

    public void showRequests() {
        System.out.println("There is " + pendingRides.size() + " passengers in your fav area");
        for (int j = 0; j < pendingRides.size() && !pendingRides.get(j).isAccepted; j++) {
            System.out.println("************Ride " + (j + 1) + " ************");
            System.out.println("passenger : " + pendingRides.get(j).getPassenger().getUsername());
            System.out.println("passenger Mobile Number: " + pendingRides.get(j).getPassenger().getMobileNumber());
            System.out.println("Source : " + pendingRides.get(j).getSource());
            System.out.println("destination : " + pendingRides.get(j).getDestination());
            System.out.println("**********************************");
        }
    }

    public void acceptRideAndOffer(Ride ride, double offer) {
        ride.setIsAccepted(true);
        ride.setCaptain(this);
        ride.setOffer(offer);

    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate() {
        double count = 0;
        for (int i = 1; i < rateHistory.size(); i += 2) {  // searching for the rate to inc. the count
            count += Double.parseDouble(rateHistory.get(i));
        }
        averageRate = count / (rateHistory.size() / 2);
    }

    public void printDriverInformation() {
        System.out.println("Username : " + this.getUsername());
        System.out.println("Email : " + this.getEmail());
        System.out.println("Mobile Number : " + this.getMobileNumber());
        System.out.println("Licsense Number : " + this.getDriverLicenseNumber());
        System.out.println("National ID : " + this.getNationalID());
        System.out.println("=========================================");

    }

}
