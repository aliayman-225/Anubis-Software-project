/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint1;

/**
 *
 * @author ACER
 */
public class Driver extends User {

    double averageRate = 0.0;
    int numOfPassengers = 0;
    private boolean suspendedAccount = true;

    public Driver(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password);
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
