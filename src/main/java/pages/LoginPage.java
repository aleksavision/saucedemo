package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class LoginPage extends PageTools {

    private final By usernameInput = By.xpath("//input[@placeholder='Username']");
    private final By passwordInput = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.xpath("//h3");
    private final By closeErrorButton = By.xpath("//button[@class='error-button']");
    private final By crossIconUsername = By.xpath("//div[@class='form_group'][1]/*[@data-icon='times-circle']");
    private final By crossIconPassword = By.xpath("//div[@class='form_group'][2]/*[@data-icon='times-circle']");


    @Step("Fill the Username field with {username}")
    public void setUsernameInput(String username) {
        type(usernameInput, username);
    }

    @Step("Fill the Passsword field with {password}")
    public void setPasswordInput(String password) {
        type(passwordInput, password);
    }

    @Step("Click the Login button")
    public CollectionPage clickLoginButton() {
        click(loginButton);
        return new CollectionPage();
    }

    @Step("Get the error message text")
    public String getErrorMessage() {
        return getElementText(errorMessage);
    }

    @Step("Click the Close error message button")
    public void clickCloseError() {
        click(closeErrorButton);
    }

    @Step("Check if Cross icon is displayed next to the Username field")
    public boolean isCrossIconUsernameDisplayed() {
        return isElementVisible(crossIconUsername);
    }

    @Step("Check if Cross icon is displayed next to the Password field")
    public boolean isCrossIconPasswordDisplayed() {
        return isElementVisible(crossIconPassword);
    }

}
