package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class CheckoutCompletePage extends PageTools {

    private final By successMessage = By.xpath("//h2");
    private final By backHomeButton = By.xpath("//button[@name='back-to-products']");

    @Step("Get success message text")
    public String getSuccessMessage() {
        return getElementText(successMessage);
    }

    @Step("Click the Back Home button")
    public CollectionPage clickBackHomeButton() {
        click(backHomeButton);
        return new CollectionPage();
    }


}
