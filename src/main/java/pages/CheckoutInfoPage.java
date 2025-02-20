package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutInfoPage extends PageTools {

    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By firstNameInput = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameInput = By.xpath("//input[@placeholder='Last Name']");
    private final By postalCodeInput = By.xpath("//input[@placeholder='Zip/Postal Code']");
    private final By cancelButton = By.xpath("//button[@id='cancel']");
    private final By continueButton = By.xpath("//input[@id='continue']");
    private final By closeErrorButton = By.xpath("//button[@class='error-button']");
    private final By errorMessage = By.xpath("//h3");

    @Step("Fill the First Name field with {firstName}")
    public void setFirstNameInput(String firstName) {
        type(firstNameInput, firstName);
    }

    @Step("Fill the Last Name field with {lastName}")
    public void setLastNameInput(String lastName) {
        type(lastNameInput, lastName);
    }

    @Step("Fill the Postal Code field with {postalCode}")
    public void setPostalCodeInput(String postalCode) {
        type(postalCodeInput, postalCode);
    }

    @Step("Click the Continue button")
    public CheckoutOverviewPage clickContinueButton() {
        click(continueButton);
        return new CheckoutOverviewPage();
    }

    @Step("Click the Close error button")
    public void clickCloseErrorButton() {
        click(closeErrorButton);
    }

    @Step("Get error message text")
    public String getErrorMessage() {
        return getElementText(errorMessage);
    }

}
