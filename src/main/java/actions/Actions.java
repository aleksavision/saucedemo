package actions;

public class Actions {

    private static LoginPageActions loginPageActions;
    private static ProductPageActions productPageActions;
    private static CheckoutInfoPageActions checkoutInfoPageActions;

    public static LoginPageActions loginPageActions() {
        if (loginPageActions == null) {
            loginPageActions = new LoginPageActions();
        }
        return loginPageActions;
    }

    public static ProductPageActions productPageActions() {
        if (productPageActions == null) {
            productPageActions = new ProductPageActions();
        }
        return productPageActions;
    }

    public static CheckoutInfoPageActions checkoutInfoPageActions() {
        if (checkoutInfoPageActions == null) {
            checkoutInfoPageActions = new CheckoutInfoPageActions();
        }
        return checkoutInfoPageActions;
    }

}
