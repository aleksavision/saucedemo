package actions;

import pages.LoginPage;
import testData.GlobalData;

public class LoginPageActions extends LoginPage {

    public void loginValidUser() {
        setUsernameInput(GlobalData.validUser);
        setPasswordInput(GlobalData.password);
        clickLoginButton();
    }

}

