package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class ScheduleDemoPage extends Page {

    @FindBy(xpath = "//input[contains(@id,'firstname')]")
    private WebElement firstNameField;

    @FindBy(xpath = "//iframe[@class='hs-form-iframe']")
    private WebElement scheduleDemoFormIframe;

    @FindBy(xpath = "//input[contains(@id,'lastname')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[contains(@id,'email')]")
    private WebElement emailField;

    @FindBy(xpath = "//input[contains(@id,'phone')]")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[contains(@id,'company')]")
    private WebElement organizationField;

    @FindBy(xpath = "//input[@value='Submit']")
    private WebElement submitButton;

    public ScheduleDemoPage fillOutFirstNameField(String name) throws InterruptedException {
        Thread.sleep(5000);
        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='hs-form-iframe']")));
        fillOut(firstNameField, name);
        System.out.println("Fill out the First Name field: " + name);
        return new ScheduleDemoPage();
    }

    public ScheduleDemoPage fillOutLastNameField(String lastName) {
        fillOut(lastNameField, lastName);
        System.out.println("Fill out the Last Name field: " + lastName);
        return new ScheduleDemoPage();
    }

    public ScheduleDemoPage fillOutEmailField(String email) {
        fillOut(emailField, email);
        System.out.println("Fill out Email field: " + email);
        return new ScheduleDemoPage();
    }

    public ScheduleDemoPage fillOutPhoneNumberField(String phone) {
        fillOut(phoneNumberField, phone);
        System.out.println("Fill out Phone Number field: " + phone);
        return new ScheduleDemoPage();
    }

    public ScheduleDemoPage fillOutOrganizationField(String company) {
        fillOut(organizationField, company);
        System.out.println("Fill out Organization field: " + company);
        return new ScheduleDemoPage();
    }

    public ThankYouPage clickSubmitButton() {
        click(submitButton);
        System.out.println("Click on the Button 'Submit'");
        return new ThankYouPage();
    }


}
