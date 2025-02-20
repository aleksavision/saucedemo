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

public class ProductsTests extends BaseTest {

    @BeforeMethod
    public void start() {
        start(GlobalData.mainURL);
        Actions.loginPageActions().loginValidUser();
        Pages.collectionPage().clickItemNameByIndex(6);
    }

    @Test(groups = {"success"}, priority = 8)
    @Description("User is logged-in successfully. All product elements are displayed on the Product page")
    @Severity(SeverityLevel.NORMAL)
    public void elementsDisplayingTest() {
        Pages.productPage().checkImageDisplaying();
        Pages.productPage().checkNameDisplaying();
        Pages.productPage().checkDescDisplaying();
        Pages.productPage().checkPriceDisplaying();
    }

    @Test(groups = {"success"}, priority = 9)
    @Description("User is logged-in successfully. Product is added to cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void addToCartTest() {
        Map<String, String> productData = Pages.productPage().saveItemNamePrice();
        Pages.productPage().clickAddToCartButton();
        Pages.header().clickCartButton();
        assertEquals(Pages.shoppingCartPage().getItemNameByIndex(1), productData.get("Name"));
        assertEquals(Pages.shoppingCartPage().getItemPriceByIndex(1), productData.get("Price"));
    }

    @Test(groups = {"success"}, priority = 10)
    @Description("User is logged-in successfully. Product is added and then removed from the cart successfully")
    @Severity(SeverityLevel.NORMAL)
    public void removeProductTest() {
        assertEquals(Pages.header().getItemQty(), "0");
        Pages.productPage().clickAddToCartButton();
        assertEquals(Pages.header().getItemQty(), "1");
        Pages.productPage().clickRemoveButton();
        assertEquals(Pages.header().getItemQty(), "0");
    }


}
