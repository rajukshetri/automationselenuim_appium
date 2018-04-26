package life.circles.automation.circlesdemo.page.home;

import life.circles.automation.circlesdemo.page.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage {
    private String MY_ACC = "//*[@id='checkout-title']//div[text()='My Account']";

    private String PERSONAL_DETAILS = ".//*[@id='st-container']//form/div[contains(@class,'form-group')]";


    @Override
    public void prepare() {
        waitforElementToBePresent(MY_ACC);
    }

    private String getpersonalDetailWithLabel(String label) {
        String val_xpath = PERSONAL_DETAILS + "//label[text()='" + label + "']//parent::div//input";
        WebElement value = getElement(By.xpath(val_xpath));
        return value.getAttribute("value");
    }

    public String getEmailValue() {
        return getpersonalDetailWithLabel("Email");
    }

}

// TODO implement this getter
class PersonalDetails {
    String fName, LName, Email;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String lName) {
        LName = lName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

}
