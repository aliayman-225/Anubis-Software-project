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
public class Ride {
    
    String source;
    String destination;
    Driver captain;
    Passenger passenger;
    int offer;
    boolean isAccepted = false;
    
    
    Ride(String source, String destination,  Passenger passenger){
        if(isAccepted){
            this.source=source;
            this.destination=destination;
            this.passenger=passenger;
        }
        
          
    }
    public void setDriver(Driver captain){
            this.captain = captain;
        }
     public void getRideInfo(){
         System.out.println("Source: " + source);
         System.out.println("Destination: " + destination);
         System.out.println("Passenger: " + passenger);
         System.out.println("Driver: " + captain ); 
         
    }
    
    
            
}
