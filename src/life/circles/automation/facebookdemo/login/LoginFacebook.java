package life.circles.automation.facebookdemo.login;

import life.circles.automation.circlesdemo.page.base.BasePage;
import life.circles.automation.facebookdemo.home.WellComeFBPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginFacebook extends BasePage {
    private String EMAIL = "//*[@id='email']";

    private String PASS = ".//*[@id='pass']";

    private String LOGIN = "//label[@id='loginbutton']//input[@value='Log In']";

    @Override
    public void prepare() {
        waitforElementToBePresent(EMAIL);
    }

    public WellComeFBPage loginToFaceBook() {
        WebElement email = getElement(By.xpath(EMAIL));
        email.sendKeys("testingbyraju@gmail.com");
        WebElement pwd = getElement(By.xpath(PASS));
        pwd.sendKeys("rajubytesting");
        WebElement signIn = getElement(By.xpath(LOGIN));
        signIn.click();
        waitforElementTobecomeInvisibe(LOGIN);
        log.info("Login sucessfull .");
        return navigateTo(new WellComeFBPage());
    }
}
