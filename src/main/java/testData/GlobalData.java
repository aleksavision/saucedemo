package testData;

import java.util.Date;

public class GlobalData {

    public static final String mainURL = "https://www.saucedemo.com/";

    //Customer info
    public static final String validUser = "standard_user";
    public static final String lockedUser = "locked_out_user";
    public static final String problemUser = "problem_user";
    public static final String perfomUser = "performance_glitch_user";
    public static final String errorUser = "error_user";
    public static final String visualUser = "visual_user";
    public static final String password = "secret_sauce";


    //Messages
    public static final String lockedUserError = "Epic sadface: Sorry, this user has been locked out.";
    public static final String invalidDataError = "Epic sadface: Username and password do not match any user in this service";
    public static final String usernameRequiredError = "Epic sadface: Username is required";
    public static final String passwordRequiredError = "Epic sadface: Password is required";
    public static final String firstNameRequiredError = "Error: First Name is required";
    public static final String lastNameRequiredError = "Error: Last Name is required";
    public static final String postalCodeRequiredError = "Error: Postal Code is required";
    public static final String successOrderMessage = "Thank you for your order!";

    public static final String updatingEmail() {
        long timestamp = new Date().getTime();
        return "autotest" + timestamp + "@gmail.nl";
    }


}
