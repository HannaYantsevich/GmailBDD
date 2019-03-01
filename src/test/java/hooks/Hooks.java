package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import browser.BrowserProvider;

public class Hooks {

    public static final String BASE_URL = "https://www.google.com/intl/ru/gmail/about/#";

    @Before
    public void beforeScenario(){
        BrowserProvider.getBrowser().get(BASE_URL);
    }

    @After
    public void afterScenario() {
       BrowserProvider.closeBrowser();
    }
}
