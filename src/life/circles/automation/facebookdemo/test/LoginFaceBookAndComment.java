package life.circles.automation.facebookdemo.test;

import life.circles.automation.circlesdemo.TestcaseBase;
import life.circles.automation.facebookdemo.app.StartFaceBookAppTest;
import life.circles.automation.facebookdemo.home.WellComeFBPage;
import life.circles.automation.facebookdemo.login.LoginFacebook;

import org.testng.annotations.Test;

public class LoginFaceBookAndComment extends TestcaseBase {
    private String COMMENTS = "Testing Comments";
    @Test
    public void testLoginFaceBookAndComment() throws InterruptedException {
        start(TestcaseBase.URL.FACEBOOK);
        new LoginFacebook().loginToFaceBook().navigateTo(new WellComeFBPage()).postComment(COMMENTS);
        new StartFaceBookAppTest().testComments(COMMENTS);

    }
}
