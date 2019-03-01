package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailLoginPage extends AbstractedPage {

    private static final String LOGIN = "HannaTest34@gmail.com";
    public static final String TAB_NAME = "Untitled";

    @FindBy(xpath = "//div[@class='gmail-nav__nav-links-wrap']/a[@class ='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement signInButton;

    @FindBy(css = "input#identifierId.whsOnd.zHQkBf")
    private WebElement emailInput;

    @FindBy(id = "identifierNext")
    private WebElement nextButton;

    private By signInButtonLocator = By.xpath("//*[contains(text(), 'Создать аккаунт')]/preceding::*[contains(text(), 'Войти')]");

    public GmailLoginPage pressSignInButton() {
        List<WebElement> elements = browser.findElements(signInButtonLocator);
        for (WebElement elem : elements) {
            if (elem.isDisplayed()) {
                elem.click();
                break;
            }
        }
        return this;
    }

    public GmailLoginPage fillEmailIInput() {
        browser.switchToRequiredTabInBrowser(TAB_NAME);
        browser.waitForElementVisible(emailInput);
        emailInput.sendKeys(LOGIN);
        return this;
    }

    public GmailPasswordPage pressNextButton() {
        browser.waitForElementVisible(By.id("identifierNext"));
        nextButton.click();
        return new GmailPasswordPage();
    }
}
