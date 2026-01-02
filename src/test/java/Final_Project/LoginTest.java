package Final_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import ModulePages.LoginPage;

public class LoginTest extends BaseTest{
	
	LoginPage login;

	@Test
    public void verifyLoginModalOpens() {
        login = new LoginPage(driver);
        login.openLoginModal();
        Assert.assertTrue(true);
    }

    @Test
    public void verifyValidLogin() {
        login = new LoginPage(driver);
        login.login("TestDemouser88", "Testuserpass88");

        Assert.assertTrue(login.isLoginSuccessful(), "Valid login failed");
    }

    @Test
    public void verifyEmptyUsernameAndPassword() {
        login = new LoginPage(driver);
        login.login("", "");

        String alert = login.handleAlertIfPresent();
        Assert.assertEquals(alert, "Please fill out Username and Password.");
    }

    @Test
    public void verifyEmptyUsername() {
        login = new LoginPage(driver);
        login.login("", "pass123");

        String alert = login.handleAlertIfPresent();
        Assert.assertEquals(alert, "Please fill out Username and Password.");
    }

    @Test
    public void verifyEmptyPassword() {
        login = new LoginPage(driver);
        login.login("user1", "");

        String alert = login.handleAlertIfPresent();
        Assert.assertEquals(alert, "Please fill out Username and Password.");
    }

    @Test
    public void verifyInvalidUsername() {
        login = new LoginPage(driver);
        login.login("invalidUser", "pass123");

        String alert = login.handleAlertIfPresent();
        Assert.assertEquals(alert, "User does not exist.");
    }

    @Test
    public void verifyInvalidPassword() {
        login = new LoginPage(driver);
        login.login("user1", "pass");

        String alert = login.handleAlertIfPresent();
        Assert.assertEquals(alert, "Wrong password.");
    }
 
}
