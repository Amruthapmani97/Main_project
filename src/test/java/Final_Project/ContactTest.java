package Final_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import ModulePages.ContactPage;

public class ContactTest extends BaseTest {
 
	@Test(priority = 1)
	public void verifyContactFormWithValidData() throws InterruptedException {

	    ContactPage contact = new ContactPage(driver);

	    contact.openContactModal();
	    contact.enterEmail("testuser@gmail.com");
	    contact.enterName("Test User");
	    contact.enterMessage("This is a test message");
	    Thread.sleep(1000);
	    contact.clickSendMessage();

	    String alertText = contact.getAlertText();
	    System.out.println("Alert text: " + alertText);

	    Assert.assertTrue(alertText.contains("Thanks"),
	            "Success message not displayed");

	    contact.acceptAlert();
	}

	@Test(priority = 2)
	public void verifyContactFormWithEmptyFields() throws InterruptedException {

	    ContactPage contact = new ContactPage(driver);

	    contact.openContactModal();
	    Thread.sleep(1000);
	    contact.clickSendMessage();

	    String alertText = contact.getAlertText();
	    System.out.println("Alert text: " + alertText);

	    Assert.assertTrue(alertText.toLowerCase().contains("thanks"),
	            "DemoBlaze allows empty submission (known issue)");

	    contact.acceptAlert();
	}


    @Test(priority = 3)
    public void verifyContactFormWithInvalidEmail() throws InterruptedException {

        ContactPage contact = new ContactPage(driver);

        contact.openContactModal();
        contact.enterEmail("invalidemail");
        contact.enterName("User1");
        contact.enterMessage("Invalid email test");
        Thread.sleep(1000);
        contact.clickSendMessage();

        String alertText = contact.getAlertText();
        System.out.println("Alert text: " + alertText);

        // DemoBlaze BUG: accepts invalid email
        Assert.assertTrue(alertText.contains("Thanks"),
                "DemoBlaze accepts invalid email (known issue)");

        contact.acceptAlert();
    }
    
    @Test(priority = 4)
	public void verifyContactFormOnlyWithEmail() throws InterruptedException {

	    ContactPage contact = new ContactPage(driver);

	    contact.openContactModal();
	    contact.enterEmail("testmail");
	    Thread.sleep(1000);
	    contact.clickSendMessage();

	    String alertText = contact.getAlertText();
	    System.out.println("Alert text: " + alertText);

	    Assert.assertTrue(alertText.toLowerCase().contains("thanks"),
	            "DemoBlaze allows empty submission (known issue)");

	    contact.acceptAlert();
	}
   
    @Test(priority = 5)
	public void verifyContactFormOnlyWithName() throws InterruptedException {

	    ContactPage contact = new ContactPage(driver);

	    contact.openContactModal();
	    contact.enterName("user1");
	    Thread.sleep(1000);
	    contact.clickSendMessage();

	    String alertText = contact.getAlertText();
	    System.out.println("Alert text: " + alertText);

	    Assert.assertTrue(alertText.toLowerCase().contains("thanks"),
	            "DemoBlaze allows empty submission (known issue)");

	    contact.acceptAlert();
	}
}
