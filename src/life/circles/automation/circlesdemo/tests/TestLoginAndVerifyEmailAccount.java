package life.circles.automation.circlesdemo.tests;

import life.circles.automation.circlesdemo.TestcaseBase;
import life.circles.automation.circlesdemo.page.base.login.LoginPage;
import life.circles.automation.circlesdemo.page.home.HomePage;
import life.circles.automation.circlesdemo.page.home.MyAccountPage;

import org.junit.Assert;
import org.testng.annotations.Test;




public class TestLoginAndVerifyEmailAccount extends TestcaseBase {
    String actualEmail = "testingbyraju@gmail.com";
    @Test
    public void testLoginAndVerifyEmailAccount() {

        start(TestcaseBase.URL.CILCLE);
        LoginPage logIn = new LoginPage();
        HomePage home = logIn.doLogin().navigateTo(new HomePage());
        MyAccountPage myAcc = home.myAcoumtPage().navigateTo(new MyAccountPage());
        String email=myAcc.getEmailValue();
        Assert.assertTrue("Email is not equal as expected : " + actualEmail + " but shown : " + email,
                actualEmail.equals(email));
    }
}
