/**
 *
 * @author User
 */
public abstract class User {

    private String username, mobileNumber, email, password;
    private boolean suspendedAccount = false;

    public User(String username, String mobileNumber, String email, String password) {
        this.username = username;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        suspendedAccount = this.getClass().getName().equals("Driver");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSuspendedAccount() {
        return suspendedAccount;
    }

    public void setSuspendedAccount(boolean suspendedAccount) {
        this.suspendedAccount = suspendedAccount;
    }

}
