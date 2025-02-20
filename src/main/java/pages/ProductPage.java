package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

import java.util.HashMap;
import java.util.Map;


public class ProductPage extends PageTools {

    private final By image = By.xpath("//img[@class='inventory_details_img']");
    private final By name = By.xpath("//div[@class='inventory_details_name large_size']");
    private final By description = By.xpath("//div[@class='inventory_details_desc large_size']");
    private final By price = By.xpath("//div[@class='inventory_details_price']");
    private final By addToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']");
    private final By backButton = By.xpath("//button[@id='back-to-products']");
    private final By removeButton = By.xpath("//button[@id='remove']");


    @Step("Check if product image is displayed")
    public void checkImageDisplaying() {
        isElementVisible(image);
    }

    @Step("Check if product name is displayed")
    public void checkNameDisplaying() {
        isElementVisible(name);
    }

    @Step("Check if product description is displayed")
    public void checkDescDisplaying() {
        isElementVisible(description);
    }

    @Step("Check if product price is displayed")
    public void checkPriceDisplaying() {
        isElementVisible(price);
    }

    @Step("Click Add to cart button")
    public void clickAddToCartButton() {
        click(addToCartButton);
    }

    @Step("Click Back to products button")
    public CollectionPage clickBackButton() {
        click(backButton);
        return new CollectionPage();
    }

    @Step("Click Remove added product button")
    public void clickRemoveButton() {
        click(removeButton);
    }

    @Step("Get product name")
    public String getProductName() {
        return getElementText(name);
    }

    @Step("Get product price")
    public String getProductPrice() {
        return getElementText(price);
    }

    @Step("Save product name and price")
    public Map<String, String> saveItemNamePrice() {
        Map<String, String> itemData = new HashMap<>();
        itemData.put("Name", getProductName());
        itemData.put("Price", getProductPrice());
        return itemData;
    }

}
