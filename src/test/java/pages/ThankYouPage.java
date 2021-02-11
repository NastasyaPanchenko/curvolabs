package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouPage extends Page{
@FindBy(xpath = "//div[contains(@class,'fusion-title title fusion-title-')]")
    private WebElement thankYouMessageText;

public String getThankYouMessageText() {
    return thankYouMessageText.getText();
}
}
