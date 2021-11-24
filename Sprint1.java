import java.util.ArrayList;
import java.util.Scanner;

public class Sprint1 {

    public static void main(String[] args) {

        Authentication authentication = Authentication.getAuthentication();
        Admin admin = new Admin(authentication);
        Scanner input = new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("1-Login\n2-Signup\n3-Admin\n4-Exit");
            int answer = input.nextInt();
            switch (answer) {
                case 1: // login
                {
                    System.out.println("1-As passenger\n2-As Driver");
                    answer = input.nextInt();
                    System.out.println("Enter User name");
                    input.nextLine();
                    String username = input.nextLine();
                    System.out.println("Enter Password");
                    String Password = input.nextLine();
                    if (answer == 1) //login as a passenger
                    {
                        
                        if (authentication.login(new Passenger(username, "", "", Password)) != null) {
                            Passenger scopedPassenger=(Passenger) authentication.login(new Passenger(username, "", "", Password));
                            System.out.println("====== Welcome " + scopedPassenger.getUsername() + " ======");
                            scopedPassenger.getNotifications();
                            while (true) {
                                System.out.println("1-Request ride areas\n2-Rate Driver\n3- Check Driver's average rate.\n4-Exit");
                                answer = input.nextInt();
                                if (answer == 1) // setting drivers favourite area
                                {
                                    System.out.println("Source area");
                                    input.nextLine();
                                    String source = input.nextLine();
                                    System.out.println("destination area");
                                    String destination = input.nextLine();
                                    scopedPassenger.requestRide(source, destination, authentication);
                                } else if (answer == 2){ //listing all rides with source area
                                    System.out.println("Enter Driver username");
                                    input.nextLine();
                                    String dUsername = input.nextLine();
                                    System.out.println("Rate from 1-5");
                                    int rate = input.nextInt();
                                    for(int j=0;j<authentication.getDrivers().size();j++)
                                    {
                                        if(authentication.getDrivers().get(j).getUsername().equals(dUsername))
                                            scopedPassenger.rateDriver(rate, authentication.getDrivers().get(j));
                                    }
                                } else if (answer == 3)//list all user ratings
                                {
                                    input.nextLine();
                                    System.out.println("Enter Driver username"); 
                                    String dUsername = input.nextLine();
                                    for(int j=0;j<authentication.getDrivers().size();j++)
                                    {
                                        if(authentication.getDrivers().get(j).getUsername().equals(dUsername))
                                            System.out.println("Captain : "+dUsername+" Average rate : "+authentication.getDrivers().get(j).getAverageRate());
                                        
                                    }
                                    
                                } else if (answer == 4) {
                                    break;
                                }
                            }
                        }

                    } else if (answer == 2) //login as a Driver
                    {
                        if (authentication.login(new Driver(username, "", "", Password, "", "")) != null) {
                            Driver scopedDriver = (Driver) authentication.login(new Driver(username, "", "", Password, "", ""));
                            System.out.println("====== Welcome Captain " + scopedDriver.getUsername() + " ======");
                            while (true) {
                                System.out.println("1-add favourite areas\n2-list all rides with source area\n3- accept ride.\n4-List Rating history\n5- Exit");
                                answer = input.nextInt();
                                if (answer == 1) // setting drivers favourite area
                                {
                                    System.out.println("Enter your favourite areas --> type exit when you finish");
                                    //input.nextLine();
                                    while(true)
                                    {
                                        String favArea = input.nextLine();
                                        if(!favArea.equalsIgnoreCase("exit"))
                                            scopedDriver.getFavAreas().add(favArea);
                                        else
                                            break;
                                    }
                                } else if (answer == 2){ //listing all rides with source area
                                    scopedDriver.showRequests();
                                
                                } else if (answer == 3){//accept ride
                                    System.out.println("Enter Passenger username");
                                    input.nextLine();
                                    String pUsername = input.nextLine();
                                    System.out.println("Offer");
                                    double offer = input.nextDouble();
                                    for(int j=0;j<authentication.getRides().size();j++){
                                        if(authentication.getRides().get(j).getPassenger().getUsername().equals(pUsername) ){
                                          scopedDriver.acceptRideAndOffer(authentication.getRides().get(j), offer);  
                                        }       
                                    }
                                
                                } else if (answer == 4) {
                                    for(int j=0;j<scopedDriver.getRateHistory().size();j+=2)
                                    {
                                        System.out.println("Passenger : "+scopedDriver.getRateHistory().get(j)+" Rate : "+scopedDriver.getRateHistory().get(j+1));
                                    }
                                    
                                }else if (answer == 5) {
                                    break;
                                    
                                }
                            }
                        }
                    }
                    break;
                }
                case 2: //signup
                {
                    System.out.println("1-As passenger\n2-As Driver");
                    answer = input.nextInt();
                    System.out.println("Enter User name");
                    input.nextLine();
                    String username = input.nextLine();
                    System.out.println("Enter Password");
                    String password = input.nextLine();
                    System.out.println("Enter Email");
                    String email = input.nextLine();
                    System.out.println("Enter mobileNumber");  
                    String mobileNumber = input.nextLine();
                    
                    if (answer == 1) //signup as a passenger
                    {
                        User user = new Passenger(username, email, password, mobileNumber);
                        if (!authentication.SignUp(user)) {
                            System.out.println("Username was taken please choose another user name");
                        } else {
                            System.out.println("Done");
                        }
                    } else if (answer == 2) //signup as a driver
                    {
                        System.out.println("Enter Driver Licsense number");
                        String driverLiscenseNumber = input.nextLine();
                        System.out.println("Enter National ID");
                        String nationalID = input.nextLine();
                        User user = new Driver(username, mobileNumber, email, password, driverLiscenseNumber, nationalID);
                        if (!authentication.SignUp(user)) {
                            System.out.println("Username was taken please choose another user name");
                        } else {
                            System.out.println("Done");
                        }
                    }
                    break;
                }
                case 3: // admin
                    System.out.println("1-show all pending requests\n2-Suspend\n3-Activate");
                    answer = input.nextInt();
                    if (answer == 1) //show all pending requests
                    {
                        ArrayList<Driver> pendingRequests = admin.listAllPendingDrivers();
                        for (int i = 0; i < pendingRequests.size(); i++) {
                            System.out.println("=================Driver " + (i + 1) + "=================");
                            System.out.println("Username : " + pendingRequests.get(i).getUsername());
                            System.out.println("Email : " + pendingRequests.get(i).getEmail());
                            System.out.println("Mobile Number : " + pendingRequests.get(i).getMobileNumber());
                            System.out.println("Licsense Number : " + pendingRequests.get(i).getDriverLicenseNumber());
                            System.out.println("National ID : " + pendingRequests.get(i).getNationalID());
                            System.out.println("=========================================");

                        }
                    } else if (answer == 2)//Suspend
                    {
                        System.out.println("Enter user name");
                        input.nextLine();
                        String username = input.nextLine();
                        if (!admin.suspend(username)) {
                            System.out.println("User not found");
                        }
                    } else if (answer == 3) //activate
                    {
                        System.out.println("Enter user name");
                        input.nextLine();
                        String username = input.nextLine();
                        if (!admin.activate(username)) {
                            System.out.println("User not found");
                        }
                    }
                    break;
                case 4:
                    break OUTER;
                default:
                    break;
            }
        }
    }

    private static void While(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
