package swaglabs;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swaglabs.utilities.AppConstants;

public class EndToEndShoppingTest extends BaseTest {
    @Test
    public void loginTest() {
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        Assert.assertEquals(homePage.getPageHeader(), AppConstants.HOME_PAGE_HEADER);
    }

    @Test(dependsOnMethods = "loginTest", dataProvider = "getProductData")
    public void addToCartTest(String productName) {
        homePage.addProduct(productName);
        Assert.assertTrue(homePage.addedItemNumber() > 0);
    }

    @Test(dependsOnMethods = "addToCartTest")
    public void checkoutTest() {
        homePage.clickOnShoppingCart();
        shoppingCartPage.clickOnCheckout();
        checkoutPage.fillShippingInfo();
        Assert.assertTrue(checkoutPage.isSuccessMessageDisplayed());
    }


    @DataProvider
    public Object[][] getProductData() {
        return new Object[][]{
                {"Backpack"},
                {"Jacket"}
        };
    }

}
