package swaglabs.pages;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import swaglabs.utilities.AppConstants;

public class CheckoutPage {
    private Page page;
    Faker faker=new Faker();
    private String firstName="First Name";
    private String lastName="Last Name";
    private String zipCode="Zip/Postal Code";


    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void fillShippingInfo(){
        page.getByPlaceholder(firstName).fill(faker.name().firstName());
        page.getByPlaceholder(lastName).fill(faker.name().lastName());
        page.getByPlaceholder(zipCode).fill(faker.address().zipCode());
        page.getByRole(AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName("continue"))
                .click();
        page.getByRole(AriaRole.BUTTON,
                        new Page.GetByRoleOptions().setName("finish"))
                .click();

    }

    public boolean isSuccessMessageDisplayed(){

       return page.getByText(AppConstants.CHECKOUT_SUCCESS_MESSAGE).isVisible();
    }
}
