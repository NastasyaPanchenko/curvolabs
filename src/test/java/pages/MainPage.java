package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends Page {

    @FindBy(xpath = "//ul[@id='menu-mainnav']//span[text()='Products']")
    private WebElement productsLink;

    public MainPage() {
        url = "https://curvolabs.com/";
    }

    public void goToProductsLink() {
        click(productsLink);
        System.out.println("Click on 'Products' link");
    }

    private WebElement getWebElementMainMenuLink(String text) {
        String xpathQuery = "//ul[@id='menu-mainnav']//span[text()='" + text + "']";
        return getElementProxy(By.xpath(xpathQuery));
    }

    public void goToMainMenuLink(String link) {
        click(getWebElementMainMenuLink(link));
    }
}