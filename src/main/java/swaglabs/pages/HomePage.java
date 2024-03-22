package swaglabs.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    private Page page;
    private String pageHeader = ".title";
    private String products = ".inventory_item";
    private String shoppingCartIcon = ".shopping_cart_badge";
    private String getShoppingCartLink = ".shopping_cart_link";

    public HomePage(Page page) {
        this.page = page;
    }

    public String getPageHeader() {
        return page.locator(pageHeader).textContent();
    }

    public void addProduct(String productName) {
        page.locator(products).filter(new Locator.FilterOptions().setHasText(productName)).getByRole(AriaRole.BUTTON).click();
        System.out.println(productName + " is added to the shopping cart!");
    }

    public int addedItemNumber() {
        String itemCount = page.locator(shoppingCartIcon).textContent();
        System.out.println(itemCount + " item(s) in the shopping cart!");
        return Integer.parseInt(itemCount);
    }

    public void clickOnShoppingCart() {
        page.click(getShoppingCartLink);

    }
}
