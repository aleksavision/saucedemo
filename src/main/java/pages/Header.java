package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

public class Header extends PageTools {

    private final By burgerMenu = By.xpath("//button[@id='react-burger-menu-btn']");
    private final By cartButton = By.xpath("//a[@class='shopping_cart_link']");

    @Step("Click Cart button")
    public ShoppingCartPage clickCartButton() {
        click(cartButton);
        return new ShoppingCartPage();
    }

    @Step("Get product qty in Cart")
    public String getItemQty() {
        if (!"".equals(getElementText(cartButton))) {
            return getElementText(cartButton);
        }
        return "0";
    }


}
