package swaglabs.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    private String userName = "input#user-name";
    private String passWord = "input[id='password']";
    private String loginButton = "#login-button";

    public void login(String username, String password) {
        page.fill(userName, username);
        page.fill(passWord, password);
        page.click(loginButton);
    }

}
