package utils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.GmailLoginPage;
import pages.GmailMainPage;
import pages.GmailPasswordPage;
import singleton.BrowserSingleton;

public class MyStepdefs {

    @Given("^I Logged into the gmail account$")
    public void iOpenedLogInPage() {
        new GmailLoginPage(BrowserSingleton.getBrowser());
        new GmailLoginPage(BrowserSingleton.getBrowser()).pressSigninButton().fillEmailIInput().pressNextButton();
        new GmailPasswordPage(BrowserSingleton.getBrowser()).fillGmailPasswordInput().pressPasswordNextButton();
        new GmailMainPage(BrowserSingleton.getBrowser());
    }


    @When("^I Compose new email$")
    public void iComposeNewEmail() {
        new GmailMainPage(BrowserSingleton.getBrowser()).pressComposeButton()
                .fillRecipentInput()
                .fillSubjectInput()
                .fillBodyInput();
    }

    @And("^I Close email$")
    public void iCloseThisEmail() {
        new GmailMainPage(BrowserSingleton.getBrowser()).saveAndCloseEmail();
    }

    @And("^I send email from Drafts$")
    public void iSendWEmailFromDrafrs() {
        new GmailMainPage(BrowserSingleton.getBrowser()).clickOnDraftsLink().clickOnDraftEmail().sendEmail();
    }

    @Then("^I see that this email is saved in drafts$")
    public void iSeeThatThisEmailIsSavedInDrafts() {
        Assert.assertTrue(new GmailMainPage(BrowserSingleton.getBrowser()).isEmailAppearedInDrafts());
    }

    @And("^I open Sent folder$")
    public void iOpenSentFolder() {
        new GmailMainPage(BrowserSingleton.getBrowser()).clickOnSentLink();
    }

    @Then("^I see that this email appeared in Sent folder$")
    public void iSeeThatThisEmailAppearedInSentFolder() {
        Assert.assertTrue(new GmailMainPage(BrowserSingleton.getBrowser()).isEmailAppearedInSentFolder());
    }

    @And("^I open Drafts$")
    public void iOpenDrafts() {
        new GmailMainPage(BrowserSingleton.getBrowser()).clickOnDraftsLink();
    }
}

