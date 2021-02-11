package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import pages.Page;
import pages.ScheduleDemoPage;
import pages.ThankYouPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScheduleDemoStepDefs {
    @When("I type {string} in the First name field")
    public void iTypeInTheFirstNameField(String name) throws InterruptedException {
       // new ScheduleDemoPage().switchToScheduleDemoForm();
        //Thread.sleep(5000);
        new ScheduleDemoPage().fillOutFirstNameField(name);
    }

    @When("I type {string} in the Last name field")
    public void iTypeInTheLastNameField(String lastName) {
        new ScheduleDemoPage().fillOutLastNameField(lastName);
    }

    @And("I type {string} in the Email field")
    public void iTypeInTheEmailField(String email) {
        new ScheduleDemoPage().fillOutEmailField(email);
    }

    @When("I type {string} in the Phone number field")
    public void iTypeInThePhoneNumberField(String phone) {
        new ScheduleDemoPage().fillOutPhoneNumberField(phone);
    }

    @When("I type {string} in the Organization field")
    public void iTypeInTheOrganizationField(String company) {
        new ScheduleDemoPage().fillOutOrganizationField(company);
    }

    @And("I click Submit Schedule Demo")
    public void iClickSubmitScheduleDemo() {
        new ScheduleDemoPage().clickSubmitButton();
    }

    @And("I verify the message {string}")
    public void iVerifyTheMessage(String actualMessage) {
        assertThat(new ThankYouPage().getThankYouMessageText()).contains(actualMessage);
    }

    @And("I verify the url contains {string}")
    public void iVerifyTheUrlContains(String expectedUrl) {
        String actualUrl = new Page().getPageUrl();
        System.out.println("Verify that actual Url: " + actualUrl + " contains expected Url " + expectedUrl);
        Assertions.assertThat(actualUrl).contains(expectedUrl);
    }
}
