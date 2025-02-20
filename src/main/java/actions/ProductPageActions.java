package actions;

import pages.Pages;
import pages.ProductPage;

public class ProductPageActions extends ProductPage {

    public void addItemToCart() {
        Pages.collectionPage().clickItemNameByIndex(1);
        Pages.productPage().clickAddToCartButton();
    }


}
