package singleton;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import decorator.Browser;
import factory.ChromeDriverCreator;
import factory.WebDriverCreator;

import org.openqa.selenium.WebDriver;


public class BrowserSingleton {

    public static Browser browser;

    private static void createBrowserInstance() {
        WebDriverCreator creator = new ChromeDriverCreator();
        WebDriver driver = creator.createWebDriver();
        browser = new Browser(driver);
    }

    public static WebDriver getBrowser() {
        if(browser == null){
            createBrowserInstance();
        }
        return browser;
    }
}
