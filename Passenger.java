/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ACER
 */
public class Passenger extends User {


    public Passenger(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password,UserType.PASSENGER);
    }

    public boolean requestRide(String source, String destination) //true untile Rider Class is implemented
    {
        return true;

    }

    public void rateDriver(int rate) {

    }

    public double checkDriverRate(Driver D) {

        return D.getAverageRate();
    }
}
