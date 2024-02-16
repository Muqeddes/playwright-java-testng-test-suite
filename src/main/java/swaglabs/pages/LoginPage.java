package swaglabs.pages;

import com.microsoft.playwright.Page;

import java.awt.*;

public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    //locators
    private String userName= "input#user-name";
    private String passWord= "input[id='password']";
    private String loginButton= "#login-button";

    public void login(String username, String password){
        page.fill(userName,username);
        page.fill(passWord, password);
        page.click(loginButton);

    }

}
