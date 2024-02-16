package swaglabs.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ShoppingCartPage {
    private Page page;

    public ShoppingCartPage(Page page) {
        this.page = page;
    }

    public void clickOnCheckout(){
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("checkout"))
                .click();
    }
}
