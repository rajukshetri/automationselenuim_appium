package life.circles.automation.facebookdemo.app;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.jfree.util.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class StartFaceBookAppTest {
    String xpathBase = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup";

    public void start() {
        AppiumDriverLocalService service = AppiumDriverLocalService
                .buildService(new AppiumServiceBuilder()
                        .usingDriverExecutable(new File("D:\\Deployment\\nodejs\\node.exe"))
                        .withAppiumJS(
                                new File(
                                        "D:/Deployment/Appium/node_modules/appium/bin/appium.js"))
                        .withIPAddress("127.0.0.1").usingPort(4721));

        service.start();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/Apps/facebook/");
        File app = new File(appDir, "facebook_lite.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.facebook.lite");
        capabilities.setCapability("appActivity", "com.facebook.lite.MainActivity");
        String service_url = service.getUrl().toString();
        try {
            driver = new AndroidDriver(new URL(service_url), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        setDriver(driver);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        System.out.println(" andriod Connection done ..");

    }

    private AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver driver) {
        this.driver = driver;
    }

    public void close() {
        driver.quit();
    }

    public void testComments(String expectedComment) throws InterruptedException {
        start();
        getDriver().findElement(By.xpath("//android.view.ViewGroup[@index='3']")).click();
        Thread.sleep(5000);

        Log.info("## Source :" + getDriver().getPageSource());
        WebElement pwd = getDriver()
                .findElement(
                        By.xpath(xpathBase + "/android.view.ViewGroup[5]"));

        pwd.click();
        pwd.sendKeys("rajubytesting");
        getDriver().findElement(By.xpath(xpathBase + "/android.view.ViewGroup[3]")).sendKeys(
                "testingbyraju@gmail.com");

        Thread.sleep(5000);
        getDriver()
                .findElement(
                        By.xpath(xpathBase + "/android.view.ViewGroup[6]"))
                .click();
        Thread.sleep(5000);
        getDriver()
                .findElement(
                        By.xpath(xpathBase + "/android.view.ViewGroup[5]"))
                .click();

        Thread.sleep(5000);
        getDriver()
                .findElement(
                        By.xpath(xpathBase + "/android.view.ViewGroup[4]")).click();
               
        Thread.sleep(5000);
        getDriver()
                .findElement(
                        By.xpath(xpathBase + "/android.view.ViewGroup[7]")).click();

        Thread.sleep(5000);
        String comment = getDriver()
                .findElement(
                        By.xpath(xpathBase + "/android.view.ViewGroup[4]//android.view.ViewGroup[11]")).getText();
        System.out.println("Comment is:" + comment);
        Assert.assertEquals(expectedComment, comment);
        close();

}


}