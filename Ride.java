
/**
 *
 * @author Reem,Ali, Mariam
 */
public class Ride {

    private String source;
    private String destination;
    private Driver captain;
    private Passenger passenger;
    private double offer;
    boolean isAccepted;

    public Ride(String source, String destination, Passenger passenger) {
        this.source = source;
        this.destination = destination;
        this.passenger = passenger;

    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Driver getCaptain() {
        return captain;
    }

    public void setCaptain(Driver captain) {
        this.captain = captain;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public double getOffer() {
        return offer;
    }

    public void setOffer(double offer) {

        this.offer = offer;
        passenger.notifications.add("Your ride was accepted by captain " + captain.getUsername() + " with offer " + offer);
    }

    public boolean isIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public void getRideInfo() {
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Passenger: " + passenger);
        System.out.println("Driver: " + captain);

    }

}
