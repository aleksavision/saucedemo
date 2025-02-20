package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage extends PageTools {

    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By itemQty = By.xpath("//div[@class='cart_quantity']");
    private final By itemName = By.xpath("//div[@class='inventory_item_name']");
    private final By itemDesc = By.xpath("//div[@class='inventory_item_desc']");
    private final By itemPrice = By.xpath("//div[@class='inventory_item_price']");
    private final By removeButton = By.xpath("//button[@name='remove-sauce-labs-backpack']");
    private final By continueShoppingButton = By.xpath("//button[@id='continue-shopping']");
    private final By checkoutButton = By.xpath("//button[@id='checkout']");

    @Step("Get product name by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(itemName, index);
    }

    @Step("Get product price by {index}")
    public String getItemPriceByIndex(int index) {
        return getElementTextByIndex(itemPrice, index);
    }

    @Step("Get item qty by {index}")
    public String getItemQtyByIndex(int index) {
        return getElementTextByIndex(itemQty, index);
    }

    @Step("Click Remove product button")
    public void clickRemoveButton() {
        click(removeButton);
    }

    @Step("Click Continue Shopping button")
    public CollectionPage clickContinueShoppingButton() {
        click(continueShoppingButton);
        return new CollectionPage();
    }

    @Step("Click Checkout button")
    public CheckoutInfoPage clickCheckoutButton() {
        click(checkoutButton);
        return new CheckoutInfoPage();
    }

    @Step("Check if page title is displayed")
    public boolean checkPageTitleDisplaying() {
        return isElementVisible(pageTitle);
    }

    @Step("Check if product name is displayed")
    public boolean checkItemNameDisplaying() {
        return isElementVisible(itemName);
    }

    @Step("Check if product description is displayed")
    public boolean checkItemDeskDisplaying() {
        return isElementVisible(itemDesc);
    }

    @Step("Check if product price is displayed")
    public boolean checkItemPriceDisplaying() {
        return isElementVisible(itemPrice);
    }

    @Step("Check if item qty is displayed")
    public boolean checkItemQtyDisplaying() {
        return isElementVisible(itemQty);
    }

    @Step("Get added items qty")
    public Integer getCartItemQty() {
        return (Integer) $$(itemQty).size();
    }

}
