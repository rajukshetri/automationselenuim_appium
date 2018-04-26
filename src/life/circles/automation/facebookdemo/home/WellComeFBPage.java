package life.circles.automation.facebookdemo.home;

import life.circles.automation.circlesdemo.page.base.BasePage;

import org.openqa.selenium.By;

public class WellComeFBPage extends BasePage {
    private String WELCOME_XPATH = "//a//div[text()='Welcome']";

    private String HOME_LINK = ".//a[text()='Home']";

    private String TEXT_MSG = "//textarea";

    private String Submit = "//span/button[@type='submit']";
    @Override
    public void prepare() {
        waitforElementToBePresent(WELCOME_XPATH);
    }

    public void postComment(String comments) {
        getElement(By.xpath(HOME_LINK)).click();
        waitforElementTobeClicklable(TEXT_MSG);
        getElement(By.xpath(TEXT_MSG)).sendKeys(comments);
        getElement(By.xpath(Submit)).click();

    }
}
