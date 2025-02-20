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
import testData.TestDataProviders;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CheckoutTests extends BaseTest {

    @BeforeMethod
    public void start() {
        start(GlobalData.mainURL);
        Actions.loginPageActions().loginValidUser();
        Actions.productPageActions().addItemToCart();
    }

    @Test(groups = {"unsuccess", "checkout"}, priority = 13, dataProvider = "invalidShippingData", dataProviderClass = TestDataProviders.class)
    @Description("User is logged-in. Product is added to cart. Checkout Shipping form isn't applied. Error is displayed")
    @Severity(SeverityLevel.CRITICAL)
    public void unsuccessShippingFormApplying(String firstName, String lastName, String postalCode, String expectedError) {
        Pages.header().clickCartButton().clickCheckoutButton();
        Pages.checkoutInfoPage().setFirstNameInput(firstName);
        Pages.checkoutInfoPage().setLastNameInput(lastName);
        Pages.checkoutInfoPage().setPostalCodeInput(postalCode);
        Pages.checkoutInfoPage().clickContinueButton();
        assertEquals(Pages.checkoutInfoPage().getErrorMessage(), expectedError);
    }

    @Test(groups = {"success", "checkout"}, priority = 14)
    @Description("User is logged-in. Product is added to cart. Checkout Shipping form is applied successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successShippingFormApplying() {
        Pages.header().clickCartButton().clickCheckoutButton();
        Pages.checkoutInfoPage().setFirstNameInput("Chris");
        Pages.checkoutInfoPage().setLastNameInput("Brown");
        Pages.checkoutInfoPage().setPostalCodeInput("12312");
        Pages.checkoutInfoPage().clickContinueButton();
        assertEquals(Pages.checkoutOverviewPage().getPageTitle(), "Checkout: Overview");
    }

    @Test(groups = {"success", "checkout"}, priority = 15)
    @Description("User is logged-in. Product is added to cart. Order is placed successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successOrderPlacing() {
        Map<String, String> productData = Pages.productPage().saveItemNamePrice();
        Pages.header().clickCartButton().clickCheckoutButton();
        Actions.checkoutInfoPageActions().submitShippingForm();

        assertEquals(Pages.checkoutOverviewPage().getProductQty(1), "1");
        assertEquals(Pages.checkoutOverviewPage().getProductName(1), productData.get("Name"));
        assertEquals(Pages.checkoutOverviewPage().getItemTotal(), "Item total: " + productData.get("Price"));
        assertEquals(Pages.checkoutOverviewPage().getTaxAmount(), "Tax: $2.40");
        assertEquals(Pages.checkoutOverviewPage().getOrderTotal(), "Total: $32.39");

        Pages.checkoutOverviewPage().clickFinishButton();
        assertEquals(Pages.checkoutCompletePage().getSuccessMessage(), GlobalData.successOrderMessage);
    }

    @Test(groups = {"success", "checkout"}, priority = 16)
    @Description("User is logged-in. Product is added to cart from PDP and PLP. Order with 2 items is placed successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void successOrderPlacingFromPDPPLP() {
        Pages.productPage().clickBackButton();
        Pages.collectionPage().clickAddToCartButton(5);
        assertEquals(Pages.header().getItemQty(), "2");

        Pages.header().clickCartButton();
        assertEquals(Pages.shoppingCartPage().getCartItemQty(), 2);

        Pages.shoppingCartPage().clickCheckoutButton();
        Actions.checkoutInfoPageActions().submitShippingForm();
        assertEquals(Pages.shoppingCartPage().getCartItemQty(), 2);
        assertEquals(Pages.checkoutOverviewPage().getOrderTotal(), "Total: $49.66");

        Pages.checkoutOverviewPage().clickFinishButton();
        assertEquals(Pages.checkoutCompletePage().getSuccessMessage(), GlobalData.successOrderMessage);

        Pages.checkoutCompletePage().clickBackHomeButton();
        assertEquals(Pages.collectionPage().getPageTitle(), "Products");
    }


}
