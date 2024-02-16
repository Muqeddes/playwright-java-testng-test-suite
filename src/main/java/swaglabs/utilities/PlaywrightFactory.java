package swaglabs.utilities;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {
    Page page;
    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Properties properties;

    public Page initBrowser(Properties properties){
        playwright= Playwright.create();

        browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel(properties.getProperty("browser")).setHeadless(Boolean.parseBoolean(properties.getProperty("headless"))));

        browserContext= browser.newContext();
        page= browserContext.newPage();
        page.navigate(properties.getProperty("url"));

        return page;
    }
    public Properties initProperties(){
        try {
            FileInputStream input=new FileInputStream("config.properties");
            properties=new Properties();
            properties.load(input);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return properties;
    }

    public void closePlaywright(){
        playwright.close();
    }

}
