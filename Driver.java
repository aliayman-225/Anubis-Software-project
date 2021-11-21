/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw.project;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Driver extends User {
     double averageRate = 0.0;
     int numOfPassengers = 0;
    private String sourceArea;
    private boolean suspendedAccount = true;
    private String driverLicenseNumber, nationalID;
    ArrayList<String> allRatings = new ArrayList<String>();
    ArrayList<String> favAreas = new ArrayList<String>();
    ArrayList<Ride> pendingRides = new ArrayList<Ride>();
   

     public Driver(String username, String mobileNumber, String email, String password, String driverLicenseNumber, String nationalID) {
        super(username, mobileNumber, email, password,UserType.DRIVER);
        this.driverLicenseNumber=driverLicenseNumber;
        this.nationalID=nationalID;
        
       int num =1; 
       for(int i = 0; i<9 ; i+=2){
       allRatings.add(i, String.valueOf(num));
       allRatings.add(i+1, "0");
       num ++;
       
       
       
       
       
       }
       
    }


     public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
       this.driverLicenseNumber = driverLicenseNumber;
    }
    
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalId(String nationalID) {
        this.nationalID = nationalID;
    }
    
    public boolean getSuspendedAccount() {
        return suspendedAccount;
    }

    public void setSuspendedAccount(boolean suspendedAccount) {
        this.suspendedAccount = suspendedAccount;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(int rate) {
        double mult=0;
        double count=0;
        
       for(int i = 0; i<9 ; i+=2){  // searching for the rate to inc. the count
         if(allRatings.get(i).equals(String.valueOf(rate)))
         {
             int freq=Integer.parseInt(allRatings.get(i+1));
             freq++;
             allRatings.set(i+1, Integer.toString(freq));
             
         }
       }
       
       for(int i = 0; i<9;i+=2){
           mult+=(Integer.parseInt(allRatings.get(i))*Integer.parseInt(allRatings.get(i+1)));  
       }
       
       for(int i = 1; i<=9; i+=2){
           count+=Integer.parseInt(allRatings.get(i));
       }
       
       averageRate=mult/count;
    }
    
    public ArrayList getAllRatings() {
        return allRatings;
    }


    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void incrementNumOfPassengers() {
        this.numOfPassengers++;
    }
    
    public ArrayList getFavAreas() {
        return favAreas;
    }

    public void setFavAreas(String fav) {
        if(!favAreas.contains(fav))
            favAreas.add(fav);
            
    }
    
    public String getSourceArea() {
        return sourceArea;
    }

    public void setSourceArea(String sourceArea) {
        if(favAreas.contains(sourceArea))
            this.sourceArea=sourceArea;
        else
            System.out.println("This area isn't in your favourite areas!");
            
    }
    
    public void acceptRide(Ride ride){
        
        if(!ride.isAccepted){
             ride.isAccepted=true;
             
        }
        else{
            System.out.println("Can't accept rides at the moment");
        }
        
        
    }

    
}
