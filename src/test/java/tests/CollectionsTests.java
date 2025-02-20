package tests;

import actions.Actions;
import baseTest.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Pages;
import testData.GlobalData;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CollectionsTests extends BaseTest {

    @BeforeMethod
    public void start() {
        start(GlobalData.mainURL);
        Actions.loginPageActions().loginValidUser();
    }

    @Test(groups = {"success"}, priority = 3)
    @Description("User is logged-in successfully. All product elements are displayed on the Collections page")
    @Severity(SeverityLevel.NORMAL)
    public void elementsDisplayingTest() {
        Pages.collectionPage().checkItemThumbnailsDisplaying();
        Pages.collectionPage().checkItemDescDisplaying();
        Pages.collectionPage().checkItemNamesDisplaying();
        Pages.collectionPage().checkItemPricesDisplaying();
    }

    @Test(groups = {"success"}, priority = 4)
    @Description("User is logged-in successfully. Each sort option is selected. Items are displayed correct")
    @Severity(SeverityLevel.NORMAL)
    public void sortingTest() {
        Pages.collectionPage().sortItemsByOption("Name (A to Z)");
        assertEquals(Pages.collectionPage().getItemNameByIndex(1), "Sauce Labs Backpack");
        Pages.collectionPage().sortItemsByOption("Name (Z to A)");
        assertEquals(Pages.collectionPage().getItemNameByIndex(1), "Test.allTheThings() T-Shirt (Red)");
        Pages.collectionPage().sortItemsByOption("Price (low to high)");
        assertEquals(Pages.collectionPage().getItemNameByIndex(1), "Sauce Labs Onesie");
        Pages.collectionPage().sortItemsByOption("Price (high to low)");
        assertEquals(Pages.collectionPage().getItemNameByIndex(1), "Sauce Labs Fleece Jacket");
    }

    @Test(groups = {"success"}, priority = 5)
    @Description("User is logged-in successfully. Product card is selected. User is redirected to the relevant page. User is returned to Collections page. Checks are repeated")
    @Severity(SeverityLevel.NORMAL)
    public void proceedProductPages() {
        Map<String, String> shirtData = Pages.collectionPage().saveItemNamePriceByIndex(3);
        Pages.collectionPage().clickItemNameByIndex(3);
        assertEquals(Pages.productPage().getProductName(), shirtData.get("Name"));
        assertEquals(Pages.productPage().getProductPrice(), shirtData.get("Price"));

        Pages.productPage().clickBackButton();
        Map<String, String> sweatshirtData = Pages.collectionPage().saveItemNamePriceByIndex(6);
        Pages.collectionPage().clickItemNameByIndex(6);
        assertEquals(Pages.productPage().getProductName(), sweatshirtData.get("Name"));
        assertEquals(Pages.productPage().getProductPrice(), sweatshirtData.get("Price"));
    }

    @Test(groups = {"success"}, priority = 6)
    @Description("User is logged-in successfully. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void addingToCartTest() {
        int index = 2;

        Map<String, String> bikeData = Pages.collectionPage().saveItemNamePriceByIndex(index);
        Pages.collectionPage().clickAddToCartButton(index);
        Pages.header().clickCartButton();

        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(1), bikeData.get("Name"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(1), bikeData.get("Price"));
    }

    @Test(groups = {"success"}, priority = 7)
    @Description("User is logged-in successfully. Product is added to cart and then removed successfully")
    @Severity(SeverityLevel.NORMAL)
    public void removingAddedItemTest() {
        assertEquals(Pages.header().getItemQty(), "0");
        Pages.collectionPage().clickAddToCartButton(5);
        assertEquals(Pages.header().getItemQty(), "1");
        Pages.collectionPage().clickRemoveButton(1);
        assertEquals(Pages.header().getItemQty(), "0");
    }
}
