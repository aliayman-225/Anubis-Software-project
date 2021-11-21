
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Sprint1 {

    public static void main(String[] args) {
        
        Authentication authentication = Authentication.getAuthentication();
        Admin admin = new Admin (authentication);
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("1-Login\n2-Signup\n3-Admin\n4-Exit");
            int answer = input.nextInt();
            if (answer == 1) {
                System.out.println("1-As passenger\n2-As Driver");
                answer = input.nextInt();
                if (answer == 1) {
                    System.out.println("Enter User name");
                    input.nextLine();
                    String username = input.nextLine();
                    
                    System.out.println("Enter Password");
                    String Password = input.nextLine();;
                    User scopedPassenger = authentication.login(username, Password, UserType.PASSENGER);
                    if(scopedPassenger!=null)
                    {
                        System.out.println("Under Construction");
                    }
                    
                }
                else if (answer == 2) {
                    System.out.println("Enter User name");
                    input.nextLine();
                    String username = input.nextLine();
                    
                    System.out.println("Enter Password");
                    String Password = input.nextLine();
                    User scopedPassenger = authentication.login(username, Password, UserType.DRIVER);
                    if(scopedPassenger!=null)
                    {
                        System.out.println("Under Construction");
                    }
                }

            } else if (answer == 2) {
                System.out.println("1-As passenger\n2-As Driver");
                answer = input.nextInt();
                System.out.println("Enter User name");
                input.nextLine();
                String username = input.nextLine();
                
                System.out.println("Enter Password");
                String Password = input.nextLine();;
                System.out.println("Enter Email");
                String email = input.nextLine();;
                System.out.println("Enter mobileNumber");
                String mobileNumber = input.nextLine();
                if (answer == 1) {
                    if(!authentication.SignUp(username, email, Password, mobileNumber, UserType.PASSENGER))
                        System.out.println("Username was taken please choose another user name");
                    else
                        System.out.println("Done");
                } else if (answer == 2) {
                    if(!authentication.SignUp(username, email, Password, mobileNumber, UserType.DRIVER))
                        System.out.println("Username was taken please choose another user name");
                    else
                        System.out.println("Done");
                }
            } else if (answer == 3) {
                
                System.out.println("1-show all pending requests\n2-Suspend\n3-Activate");
                answer = input.nextInt();
                if (answer == 1) {
                   ArrayList <Driver> pendingRequests=admin.listAllPendingDrivers();
                   for(int i =0;i<pendingRequests.size();i++)
                   {
                       System.out.println("=================Driver "+(i+1)+"=================");
                       System.out.println("Username : "+pendingRequests.get(i).getUsername());
                       System.out.println("Email : "+pendingRequests.get(i).getEmail());
                       System.out.println("Mobile Number : "+pendingRequests.get(i).getMobileNumber());
                       System.out.println("Licsense Number : "+pendingRequests.get(i).getDriverLicenseNumber());
                       System.out.println("National ID : "+pendingRequests.get(i).getNationalID());
                       System.out.println("=========================================");
                       
                   } 
                } else if (answer == 2) {
                    System.out.println("Enter user name");
                    input.nextLine();
                    String username=input.nextLine();
                    if(!admin.suspend(username))
                        System.out.println("User not found");
                }
                 else if (answer == 3) {
                     System.out.println("Enter user name");
                     input.nextLine();
                    String username=input.nextLine();
                    if(!admin.activate(username))
                        System.out.println("User not found");
                }

            } else if (answer == 4) {
                break;

            }

        }

        // TODO code application logic here
    }

    private static void While(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
