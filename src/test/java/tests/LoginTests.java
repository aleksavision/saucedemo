package tests;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;
import testData.TestDataProviders;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTest {

    @Test(groups = {"success", "login"}, priority = 1)
    @Description("User is logged-in successfully. User is redirected to the Collections page")
    @Severity(SeverityLevel.CRITICAL)
    public void successLogin() {
        start(GlobalData.mainURL);

        Pages.loginPage().setUsernameInput(GlobalData.validUser);
        Pages.loginPage().setPasswordInput(GlobalData.password);
        Pages.loginPage().clickLoginButton();
        assertEquals(Pages.collectionPage().getPageTitle(), "Products", "Page title is incorrect");
    }

    @Test(groups = {"unsuccess", "login"}, priority = 2, dataProvider = "invalidLoginData", dataProviderClass = TestDataProviders.class)
    @Description("User isn't logged-in. Error message is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessLogin(String username, String password, String expectedError) {
        start(GlobalData.mainURL);

        Pages.loginPage().setUsernameInput(username);
        Pages.loginPage().setPasswordInput(password);
        Pages.loginPage().clickLoginButton();
        assertEquals(Pages.loginPage().getErrorMessage(), expectedError);
    }

}
