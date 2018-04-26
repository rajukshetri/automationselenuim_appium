package life.circles.automation.circlesdemo;

import java.util.concurrent.TimeUnit;

import life.circles.automation.circlesdemo.page.base.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestcaseBase {
    public static String url;

    // later we can read all with external config . like URL and browsertype

    public static enum URL {
        CILCLE("https://shop.circles.life/login"),
        FACEBOOK("https://www.facebook.com/");
       
        String urlTxt;
        URL(String url) {
            this.urlTxt = url;
        }
    }

    public static String getURL() {
        return url;
    }

    public static void setURL(String uRL) {
        url = uRL;
    }


    WebDriver driver;

    public WebDriver start(URL url) {
        setURL(url.urlTxt);
        return start();
    }

    private WebDriver start() {
        System.setProperty("webdriver.firefox.driver", "driver/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(getURL());
        BasePage.setDriver(driver);
        return driver;
    }

    public void stop() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

}
