package life.circles.automation.circlesdemo.page.home;

import life.circles.automation.circlesdemo.page.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private String BASE = ".//*[@id='st-container']";

    private String MY_ACC_XPATH = BASE + "//div[text()='MY ACCOUNT']";

    @Override
    public void prepare() {
        // TODO add code to check if we land to home page correctly.
        waitforElementToBePresent(MY_ACC_XPATH);
    }

    public MyAccountPage myAcoumtPage() {
        waitforElementTobeClicklable(MY_ACC_XPATH);
        WebElement myAcc = getElement(By.xpath(MY_ACC_XPATH));
        myAcc.click();
        log.info("navigating to the My account Page .");
        return new MyAccountPage();
    }


}
