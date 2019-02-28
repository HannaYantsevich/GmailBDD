package singleton;

import decorator.Browser;
import factory.ChromeDriverCreator;
import factory.WebDriverCreator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BrowserSingleton {

    private static Browser browser;
    private static WebDriver driver;
    private static Logger log = Logger.getLogger(BrowserSingleton.class);

    private static void createBrowserInstance() {
        //WebDriverCreator creator = new ChromeDriverCreator();
        WebDriver driver = null;
        try {
            driver = getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        } catch (WebDriverException e) {
            log.error(e);
        } finally {
            browser = null;
        }
    }

    public static WebDriver getInstance() throws IOException {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static WebDriver createDriver() throws IOException {
        BrowserType type = BrowserType.valueOf(PropertyProvider.getProperty("browser"));
        switch (type) {
            case CHROME:
                driver = createChromeDriver();
                log.info("chrome driver created");
                break;
            case FIREFOX:
                driver = createFirefoxDriver();
                log.info("firefox driver created");
                break;
            default:
                driver = createOperaDriver();
                log.info("Opera driver created");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createOperaDriver() {
        WebDriverManager.operadriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}