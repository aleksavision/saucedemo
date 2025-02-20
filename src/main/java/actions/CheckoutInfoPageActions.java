package actions;

import pages.CheckoutOverviewPage;
import pages.Pages;

public class CheckoutInfoPageActions {

    public CheckoutOverviewPage submitShippingForm() {
        Pages.checkoutInfoPage().setFirstNameInput("firstName");
        Pages.checkoutInfoPage().setLastNameInput("lastName");
        Pages.checkoutInfoPage().setPostalCodeInput("12312");
        Pages.checkoutInfoPage().clickContinueButton();
        return new CheckoutOverviewPage();
    }

}
