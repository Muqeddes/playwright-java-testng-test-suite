package swaglabs;

import com.microsoft.playwright.Page;
import swaglabs.pages.CheckoutPage;
import swaglabs.pages.HomePage;
import swaglabs.pages.LoginPage;
import swaglabs.pages.ShoppingCartPage;
import swaglabs.utilities.PlaywrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlaywrightFactory pwFactory;
    Page page;
    protected Properties properties;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutPage checkoutPage;

    @BeforeTest
    public void setup() {
        pwFactory = new PlaywrightFactory();
        properties = pwFactory.initProperties();
        page = pwFactory.initBrowser(properties);
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
        shoppingCartPage = new ShoppingCartPage(page);
        checkoutPage = new CheckoutPage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
        pwFactory.closePlaywright();
    }

}
