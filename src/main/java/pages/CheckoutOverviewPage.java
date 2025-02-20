package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

import static com.codeborne.selenide.Selenide.$$;

public class CheckoutOverviewPage extends PageTools {

    private final By itemQty = By.xpath("//div[@class='cart_quantity']");
    private final By itemName = By.xpath("//div[@class='inventory_item_name']");
    private final By itemPrice = By.xpath("//div[@class='inventory_item_price']");
    private final By itemTotal = By.xpath("//div[@class='summary_subtotal_label']");
    private final By tax = By.xpath("//div[@class='summary_tax_label']");
    private final By orderTotal = By.xpath("//div[@class='summary_total_label']");
    private final By cancelButton = By.xpath("//button[@name='cancel']");
    private final By finishButton = By.xpath("//button[@name='finish']");
    private final By pageTitle = By.xpath("//span[@class='title']");

    @Step("Get page title")
    public String getPageTitle() {
        return getElementText(pageTitle);
    }

    @Step("Get product qty by {index}")
    public String getProductQty(int index) {
        return getElementTextByIndex(itemQty, index);
    }

    @Step("Get product name by {index}")
    public String getProductName(int index) {
        return getElementTextByIndex(itemName, index);
    }

    @Step("Get Item total")
    public String getItemTotal() {
        return getElementText(itemTotal);
    }

    @Step("Get Tax amount")
    public String getTaxAmount() {
        return getElementText(tax);
    }

    @Step("Get Order total")
    public String getOrderTotal() {
        return getElementText(orderTotal);
    }

    @Step("Click the Finish button")
    public CheckoutCompletePage clickFinishButton() {
        click(finishButton);
        return new CheckoutCompletePage();
    }

    @Step("Get items qty")
    public Integer getCartItemQty() {
        return (Integer) $$(itemQty).size();
    }


}
