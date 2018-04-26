package life.circles.automation.circlesdemo.page.base.login;

import life.circles.automation.circlesdemo.page.base.BasePage;
import life.circles.automation.circlesdemo.page.home.HomePage;
import life.circles.automation.logger.TestLogger;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    public static final Logger log = TestLogger.getLogger(LoginPage.class);

    private String BASE_XPATH = "//*[@id='st-container']//form[@class='form-signin']";

    private String EMAIL_XPATH = BASE_XPATH + "//input[@name='email']";

    private String PWD_XPATH = BASE_XPATH + "//input[@name='password']";

    private String SIGN_IN_XPATH = BASE_XPATH + "//button[@type='button'][text()='Sign In']";

    @Override
    public void prepare() {
        // TODO Auto-generated method stub

    }

    public HomePage doLogin() {
        WebElement email = getElement(By.xpath(EMAIL_XPATH));
        email.sendKeys("testingbyraju@gmail.com");
        WebElement pwd = getElement(By.xpath(PWD_XPATH));
        pwd.sendKeys("rajubytesting");
        WebElement signIn = getElement(By.xpath(SIGN_IN_XPATH));
        signIn.click();
        waitforElementTobecomeInvisibe(SIGN_IN_XPATH);
        log.info("Login sucessfull .");
        return navigateTo(new HomePage());
    }

}
