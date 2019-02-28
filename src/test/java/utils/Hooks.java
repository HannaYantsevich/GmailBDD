package utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import singleton.BrowserSingleton;

public class Hooks {

    public static final String BASE_URL = "https://www.google.com/intl/ru/gmail/about/#";

    @Before
    public void beforeScenario(){
        BrowserSingleton.getBrowser().get(BASE_URL);
    }

    @After
    public void afterScenario() {
       BrowserSingleton.closeBrowser();
    }
}
