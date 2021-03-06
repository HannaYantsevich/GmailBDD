package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPasswordPage extends AbstractedPage {

    private static final String PASSWORD = "PasswordPassword";

    @FindBy(xpath = "//div[@class='Xb9hP']/input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id='passwordNext']")
    private WebElement nextButton;

    public GmailPasswordPage fillGmailPasswordInput() {
        browser.waitForElementVisible(By.xpath("//div[@class='Xb9hP']/input[@type='password']"));
        passwordInput.sendKeys(PASSWORD);
        return new GmailPasswordPage();
    }

    public GmailMainPage pressPasswordNextButton() {
        browser.waitForElementAndClick(nextButton);
        return new GmailMainPage();
    }
}
