
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
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
    
    private ArrayList <Driver> drivers;
    private ArrayList <Passenger> passengers;
    private static Authentication instance;
    
    private Authentication(){
        drivers = new ArrayList <Driver>();
        passengers = new ArrayList <Passenger>();
    }
    public static Authentication getAuthentication()
    {
        if(instance==null)
            instance=new Authentication();
        return instance;
    }
    
    public User login (String username,String password,boolean isPassenger)
    {
        if(isPassenger){
            for(int i=0;i<passengers.size();i++) {
                if(  (passengers.get(i).getUsername().equals(username))  &&   (passengers.get(i).getPassword().equals(password))  ){  
                    System.out.println("Correct user name");        
                    System.out.println("correct password");
                    return passengers.get(i);
                }  
            }
            System.out.println("Incorrect username or password");
        }
        else if(!isPassenger){
            for(int i=0;i<drivers.size();i++){  	
                if(  (drivers.get(i).getUsername().equals(username))  &&   (drivers.get(i).getPassword().equals(password))  ) {
                    System.out.println("Correct user name");        
                    System.out.println("correct password");
                    return drivers.get(i);
                }	
            }
            System.out.println("Incorrect username or password");  
        }
        return null;
    }
    
    
     public void SignUp(String username,String email,String password,String mobileNumber,boolean isPassenger){    
        if(isPassenger){
            Passenger onthefly=new Passenger(username,mobileNumber,email,password);
            passengers.add(onthefly);
        }
        else if(!isPassenger){ 
        	Driver onthefly=new Driver(username,mobileNumber,email,password);
        	drivers.add(onthefly);	
        }
        
    }
    
    
}
