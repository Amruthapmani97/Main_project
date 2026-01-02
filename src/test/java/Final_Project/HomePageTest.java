package Final_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import ModulePages.HomePage;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void verifyHomepageLoadAndLogo() {
        home = new HomePage(driver, wait, js);
        Assert.assertTrue(home.isLogoDisplayed(), 
                "❌ Logo is not displayed after home page load.");
    }

    @Test(priority = 2)
    public void verifyNavigationLinks() throws InterruptedException {
        home = new HomePage(driver, wait, js);

        // Contact
        home.clickContact();
        home.closeContactModal();
        //home.goHome();

        // About
        home.clickAbout();
        home.closeAboutModal();
        //home.goHome();
        
     // Cart
        home.clickCart();
        home.goHome();

        // Login
        home.clickLogin();
        home.closeLoginModal();
        //home.goHome();
        Thread.sleep(1000);

        // Signup
        home.clickSignup();
        home.closeSignupModal();
        home.goHome();

        Assert.assertTrue(home.isLogoDisplayed(), "❌ Home page not loaded after navigation.");
    }

    @Test(priority = 3, dataProvider = "categoryData")
    public void verifyCategorySelection(String categoryName) {
        home = new HomePage(driver, wait, js);
        home.selectCategory(categoryName);
        Assert.assertTrue(home.verifyCategoryLoaded(categoryName),
                "❌ Category products not loaded: " + categoryName);
    }

    @Test(priority = 4)
    public void verifyNextButtonNavigation() {
        home = new HomePage(driver, wait, js);
        Assert.assertTrue(home.clickNextButton(), "❌ Next button failed.");
    }

    @Test(priority = 5)
    public void verifyPreviousButtonNavigation() {
        home = new HomePage(driver, wait, js);
        Assert.assertTrue(home.clickPreviousButton(), "❌ Previous button failed.");
    }

    @Test(priority = 6)
    public void verifyScrollToBottom() {
        home = new HomePage(driver, wait, js);
        home.scrollToBottom();
        Assert.assertTrue(home.isFooterVisible(), "❌ Footer not visible after scroll.");
    }

    // ------------------- DATA PROVIDER -------------------
    @org.testng.annotations.DataProvider(name = "categoryData")
    public Object[][] categoryData() {
        return new Object[][] {
                {"Phones"},
                {"Laptops"},
                {"Monitors"}
        };
    }
}
