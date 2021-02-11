package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Pa;
import pages.MainPage;
import pages.Page;
import pages.ProductsPage;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class NavigateStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "Main":
                new MainPage().open();
                break;
            default:
                throw new RuntimeException("This page doesn't support: " + page);
        }
    }

    @When("I click on {string} link on Main menu")
    public void iClickOnLinkOnMainMenu(String text) {
        new MainPage().goToMainMenuLink(text);
    }

    @Then("I verify the url {string}")
    public void iVerifyTheUrl(String expectedUrl) {
        String actualUrl = new Page().getPageUrl();
        System.out.println("Verify that actual Url: " + actualUrl + " equals expected Url " + expectedUrl);
        assertThat(actualUrl).isEqualTo(expectedUrl);
    }

    @And("I verify the title {string}")
    public void iVerifyTheTitle(String expectedTitle) {
        String actualTitle = new Page().getTitlePage();
        System.out.println("Verify that actual Title: " + actualTitle + " equals expected Title " + expectedTitle);
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @And("I switch to active window")
    public void iSwitchToActiveWindow() {
        new Page().switchToWindow();
        System.out.println("The windows have been switched");
    }
}
