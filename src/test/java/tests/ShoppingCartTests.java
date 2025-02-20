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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartTests extends BaseTest {

    @BeforeMethod
    public void start() {
        start(GlobalData.mainURL);
        Actions.loginPageActions().loginValidUser();
        Actions.productPageActions().addItemToCart();
    }

    @Test(groups = {"success"}, priority = 11)
    @Description("User is logged-in successfully. Product is added to cart. All needed elements are displayed on the SHopping cart page")
    @Severity(SeverityLevel.CRITICAL)
    public void itemElementsDisplaying() {
        Pages.header().clickCartButton();
        assertTrue(Pages.shoppingCartPage().checkPageTitleDisplaying());
        assertTrue(Pages.shoppingCartPage().checkItemNameDisplaying());
        assertTrue(Pages.shoppingCartPage().checkItemDeskDisplaying());
        assertTrue(Pages.shoppingCartPage().checkItemPriceDisplaying());
        assertTrue(Pages.shoppingCartPage().checkItemQtyDisplaying());
    }

    @Test(groups = {"success"}, priority = 12)
    @Description("User is logged-in successfully. Product is added to cart. Product is removed from the Shopping Cart successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successItemRemoving() {
        Pages.header().clickCartButton();
        assertEquals(Pages.shoppingCartPage().getItemQtyByIndex(1), "1");
        Pages.shoppingCartPage().clickRemoveButton();
        assertEquals(Pages.header().getItemQty(), "0");
    }


}
