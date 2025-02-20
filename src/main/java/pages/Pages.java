package pages;

public class Pages {

    private static LoginPage loginPage;
    private static CollectionPage collectionPage;
    private static ProductPage productPage;
    private static ShoppingCartPage shoppingCartPage;
    private static CheckoutInfoPage checkoutInfoPage;
    private static CheckoutOverviewPage checkoutOverviewPage;
    private static CheckoutCompletePage checkoutCompletePage;
    private static Header header;


    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public static CollectionPage collectionPage() {
        if (collectionPage == null) {
            collectionPage = new CollectionPage();
        }
        return collectionPage;
    }

    public static ProductPage productPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public static ShoppingCartPage shoppingCartPage() {
        if (shoppingCartPage == null) {
            shoppingCartPage = new ShoppingCartPage();
        }
        return shoppingCartPage;
    }

    public static CheckoutInfoPage checkoutInfoPage() {
        if (checkoutInfoPage == null) {
            checkoutInfoPage = new CheckoutInfoPage();
        }
        return checkoutInfoPage;
    }

    public static Header header() {
        if (header == null) {
            header = new Header();
        }
        return header;
    }

    public static CheckoutOverviewPage checkoutOverviewPage() {
        if (checkoutOverviewPage == null) {
            checkoutOverviewPage = new CheckoutOverviewPage();
        }
        return checkoutOverviewPage;
    }

    public static CheckoutCompletePage checkoutCompletePage() {
        if (checkoutCompletePage == null) {
            checkoutCompletePage = new CheckoutCompletePage();
        }
        return checkoutCompletePage;
    }

}
