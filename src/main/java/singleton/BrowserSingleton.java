package singleton;

import decorator.Browser;
import factory.ChromeDriverCreator;
import factory.WebDriverCreator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class BrowserSingleton {

    private static Browser browser;
    private static Logger log = Logger.getLogger(BrowserSingleton.class);

    private static void createBrowserInstance() {
        WebDriverCreator creator = new ChromeDriverCreator();
        WebDriver driver = creator.createWebDriver();
        browser = new Browser(driver);
    }

    public static Browser getBrowser() {
        if (browser == null) {
            createBrowserInstance();
        }
        return browser;
    }

    public static void closeBrowser() {
        try {
            if (browser != null) {
                browser.quit();
            }
        }
        catch (WebDriverException e) {
            log.error(e);
        }
        finally {
            browser = null;
        }
    }
}
