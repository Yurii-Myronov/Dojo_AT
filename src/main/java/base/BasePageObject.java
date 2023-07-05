package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;


public class BasePageObject {

    protected static AppiumDriver<MobileElement> driver;
    //public static Logger log;

    public BasePageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        //this.log = log;

    }

    //Open URL
    protected void openUrl(String url) {
        driver.get(url);
    }

    //Wait for specific ExpectedCondition for the given amount of time in seconds
    public static void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 60;
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(condition);
    }

    //Wait for given number of seconds for element with given locator to be visible on the page
    protected static void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }

    //Find element using given locator
    protected static WebElement find(By locator) {
        waitForVisibilityOf(locator, 10);
        return driver.findElement(locator);
    }

     //Click on element with given locator when its visible
    protected static void click(By locator) {
        waitForVisibilityOf(locator, 10);
        find(locator).click();
    }

     //Type given text into element with given locator
    protected static void type(String text, By locator) {
        waitForVisibilityOf(locator, 5);
        find(locator).sendKeys(text);
    }

}
