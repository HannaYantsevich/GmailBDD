package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import decorator.Browser;
import org.openqa.selenium.WebDriver;
import singleton.BrowserSingleton;

import static singleton.BrowserSingleton.browser;

public class Hooks {


    @Before
    public void beforeScenario(){
        WebDriver browser = BrowserSingleton.getBrowser();
        browser.get("https://www.google.com/intl/ru/gmail/about/#");
    }

    @After
    public void afterScenario() {
        browser.quit();
    }
}
