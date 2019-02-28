package pages;

import decorator.Browser;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractedPage {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONыDS = 10;


    protected Browser browser;

    public AbstractedPage(Browser browser) {
        this.browser = browser;
        PageFactory.initElements(this.browser, this);
    }
}
