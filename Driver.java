/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Ali
 */
public class Driver extends User {

    double averageRate = 0.0;
    int numOfPassengers = 0;
     private String driverLicenseNumber,nationalID;

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
   
    public Driver(String username, String mobileNumber, String email, String password,String driverLicenseNumber ,String nationalID) {
        super(username, mobileNumber, email, password,UserType.DRIVER);
        this.driverLicenseNumber=driverLicenseNumber;
        this.nationalID=nationalID;
    }

    

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void incrementNumOfPassengers() {
        this.numOfPassengers++;
    }

}
