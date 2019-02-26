package utils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.GmailLoginPage;
import pages.GmailMainPage;
import pages.GmailPasswordPage;

import static singleton.BrowserSingleton.browser;


public class MyStepdefs {


    @Given("^I opened LogInPage$")
    public void iOpenedLogInPage() {
        new GmailLoginPage(browser);
    }

    @When("^I entered email$")
    public void iOpenedLogInPageAndEnteredEmail() {
        new GmailLoginPage(browser).pressSigninButton().fillEmailIInput().pressNextButton();
    }


    @And("^I opened GmailPasswordPage entered password$")
    public void iOpenedGmailPasswordPageEnteredPassword() {
        new GmailPasswordPage(browser).fillGmailPasswordInput().pressPasswordNextButton();
    }


    @Then("^I opened GmailMainPage$")
    public void iOpenedGmailMainPage() {
        new GmailMainPage(browser);
        //здесь дописать какой-нибудь ассерт
    }

}

