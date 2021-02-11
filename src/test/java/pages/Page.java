package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import static support.TestContext.*;

public class Page {
    protected String url;
    protected String title;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    public void refresh() {
        getDriver().navigate().refresh();

    }

    public void click(WebElement element) {
        waitingToBeClickable(element);
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.err.println("click failed for " + element + " clicking with js..");
            jsClick(element);
        }
    }

    public String getPageUrl() {
        String currentUrl = getDriver().getCurrentUrl();
        return currentUrl;
    }

    public String getTitlePage() {
        String currentTitlePage = getDriver().getTitle();
        return currentTitlePage;
    }

    public void switchToWindow() {
        Set<String> handles = getDriver().getWindowHandles();
        String currentWindowHandle = getDriver().getWindowHandle();
        for (String handle : handles) {
            if (!currentWindowHandle.equals(handle)) {
                getDriver().switchTo().window(handle);
            }
        }
    }

    public  WebElement getElementProxy(final By by) {
        return (WebElement)
                java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(),
                        new Class<?>[]{WebElement.class}, new InvocationHandler() {
                            private WebElement webElement;
                            public Object invoke(Object proxy, Method method, Object[] args)
                                    throws Throwable {
                                if (webElement == null) {
                                    webElement = getDriver().findElement(by);
                                }
                                try {
                                    return method.invoke(webElement, args);
                                } catch (InvocationTargetException ex) {
                                    throw ex.getCause();
                                }
                            }
                        });
    }

    public void fillOut(WebElement element, String value) {
        waitingToBeVisible(element);
        String currentValue = element.getAttribute("value");
        if (!currentValue.isEmpty()) {
            element.clear();
        }
        element.sendKeys(value);
    }

    public void waitingToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitingToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void jsClick(WebElement element) {
        getExecutor().executeScript("arguments[0].click();", element);
    }
}

