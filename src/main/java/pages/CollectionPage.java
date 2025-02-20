package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import tools.PageTools;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$$;

public class CollectionPage extends PageTools {

    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By itemThumbnail = By.xpath("//img[@class='inventory_item_img']");
    private final By itemName = By.xpath("//div[@class='inventory_item_name ']");
    private final By itemDesc = By.xpath("//div[@class='inventory_item_desc']");
    private final By itemPrice = By.xpath("//div[@class='inventory_item_price']");
    private final By addToCartButton = By.xpath("//button[@class='btn btn_primary btn_small btn_inventory ']");
    private final By removeItemButton = By.xpath("//button[contains(@id,'remove-')]");
    private final By sortDropdown = By.xpath("//select[@class='product_sort_container']");


    @Step("Get page title text")
    public String getPageTitle() {
        return getElementText(pageTitle);
    }

    @Step("Check if product thumbnails are displayed")
    public void checkItemThumbnailsDisplaying() {
        $$(itemThumbnail).forEach(x -> x.shouldBe(Condition.visible));
    }

    @Step("Check if product names are displayed")
    public void checkItemNamesDisplaying() {
        $$(itemName).forEach(x -> x.shouldBe(Condition.visible));
    }

    @Step("Check if product descriptions are displayed")
    public void checkItemDescDisplaying() {
        $$(itemDesc).forEach(x -> x.shouldBe(Condition.visible));
    }

    @Step("Check if product prices are displayed")
    public void checkItemPricesDisplaying() {
        $$(itemPrice).forEach(x -> x.shouldBe(Condition.visible));
    }

    @Step("Select sorting option by {text} value")
    public void sortItemsByOption(String text) {
        selectOption(text, sortDropdown);
    }

    @Step("Get product name by {index}")
    public String getItemNameByIndex(int index) {
        return getElementTextByIndex(itemName, index);
    }

    @Step("Get product price by {index}")
    public String getItemPriceByIndex(int index) {
        return getElementTextByIndex(itemPrice, index);
    }

    @Step("Click product name by {index}")
    public ProductPage clickItemNameByIndex(int index) {
        clickElementByIndex(itemName, index);
        return new ProductPage();
    }

    @Step("Save product name and price by {index}")
    public Map<String, String> saveItemNamePriceByIndex(int index) {
        Map<String, String> itemData = new HashMap<>();
        itemData.put("Name", getItemNameByIndex(index));
        itemData.put("Price", getItemPriceByIndex(index));
        return itemData;
    }

    @Step("Click Add to Cart button by {index}")
    public void clickAddToCartButton(int index) {
        clickElementByIndex(addToCartButton, index);
    }

    @Step("Click Remove button by {index}")
    public void clickRemoveButton(int index) {
        clickElementByIndex(removeItemButton, index);
    }

}
