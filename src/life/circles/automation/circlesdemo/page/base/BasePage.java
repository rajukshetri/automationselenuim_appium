package life.circles.automation.circlesdemo.page.base;

import life.circles.automation.logger.TestLogger;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    public static final Logger log = TestLogger.getLogger(BasePage.class);
    static WebDriver driver;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public RemoteWebElement getElement(By by) {
        RemoteWebElement element = null;
        RemoteWebDriver driver = (RemoteWebDriver) getDriver();
        try {
            element = (RemoteWebElement) driver.findElement(by);
        } catch (NoSuchElementException e) {
            log.info("Did not find element using:" + by.toString()
                    );
        }
        return element;
    }

    public void waitforElementTobeClicklable(String xpath) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
    }

    public void waitforElementToBePresent(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath))));
    }

    public void waitforElementTobecomeInvisibe(String xpath) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void pause(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public abstract void prepare();

    public <X extends BasePage> X navigateTo(X BasePage) {
        BasePage.prepare();
        return BasePage;
    }
}
