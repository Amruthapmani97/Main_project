package Final_Project;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.BaseTest;
import ModulePages.SignUpPage;

public class SignUpTest extends BaseTest {

    @DataProvider(name = "validSignUpData")
    public Object[][] validSignUpData() {
        return new Object[][] {
            { "TesDemouser88", "Testuserpass88", "Sign up successful." }
        };
    }
	
//	@DataProvider(name = "validSignUpData")
//	public Object[][] validSignUpData() {
//	    return new Object[][] {
//	        { "amruthatest" + System.currentTimeMillis(), "Testpass123", "Sign up successful." }
//	    };
//	}


    @DataProvider(name = "invalidSignUpData")
    public Object[][] invalidSignUpData() {
        return new Object[][] {
            { "Testuser", "Testuser11", "This user already exist." },
            { "", "", "Please fill out Username and Password." },
            { "testuser", "", "Please fill out Username and Password." }
        };
    }

    @Test(dataProvider = "validSignUpData", priority = 1)
    public void signUpWithValidData(String username, String password, String expectedAlert) {

        SignUpPage signUp = new SignUpPage(driver);

        signUp.openSignUpModal();    
        signUp.signUp(username, password);

        Assert.assertEquals(signUp.getAlertText(), expectedAlert);
        signUp.acceptAlert();

        Assert.assertTrue(signUp.areFieldsCleared(),
                "Username and Password fields are not cleared after sign-up");
    }

    @Test(dataProvider = "invalidSignUpData", priority = 2)
    public void signUpWithInvalidData(String username, String password, String expectedAlert) {

        SignUpPage signUp = new SignUpPage(driver);

        signUp.openSignUpModal();   
        signUp.signUp(username, password);

        Assert.assertEquals(signUp.getAlertText(), expectedAlert);
        signUp.acceptAlert();

        Assert.assertTrue(signUp.areFieldsCleared(),
                "Username and Password fields are not cleared after failed sign-up");
    }
}
