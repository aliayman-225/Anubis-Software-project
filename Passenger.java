/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.project;

/**
 *
 * @author dell
 */
public class Passenger extends User {

    Driver currentDriver ;

    public Passenger(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password,UserType.PASSENGER);
    }

    public void requestRide(Authentication authentication, String source, String destination ) //true untile Rider Class is implemented
    {
        System.out.println(authentication.getDrivers().size());
       for(int i=0; i < authentication.getDrivers().size();i++)
        if(authentication.getDrivers().get(i).getFavAreas().contains(source)){
            Ride ride = new Ride(source, destination,this);
            ride.setDriver(authentication.getDrivers().get(i));
            authentication.getDrivers().get(i).pendingRides.add(ride);
        
        }

    }
    
    public void getInfo(){
        
    }

    public void rateDriver(int rate) {
        currentDriver.incrementNumOfPassengers();
        currentDriver.averageRate += rate / currentDriver.getNumOfPassengers();

    }
   
    

//    public double checkDriverRate(Driver D) {
//
//        return D.getAverageRate();
//    }
}