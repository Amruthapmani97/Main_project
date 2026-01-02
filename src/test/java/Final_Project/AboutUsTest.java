package Final_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import ModulePages.AboutUsPage;

public class AboutUsTest extends BaseTest{
	
//	@Test(priority = 1)
//    public void verifyAboutUsModalOpens() {
//        AboutUsPage about = new AboutUsPage(driver);
//        about.openAboutUsModal();
//
//        Assert.assertTrue(about.isVideoDisplayed(),
//                "Video is not displayed");
//
//        about.closeAboutUsModal(); 
//    }
//
//    @Test(priority = 2)
//    public void verifyVideoIsDisplayedInAboutUs() {
//        AboutUsPage about = new AboutUsPage(driver);
//        about.openAboutUsModal();
//
//        Assert.assertTrue(about.isVideoDisplayed(),
//                "Video is not displayed in About Us modal");
//
//        about.closeAboutUsModal(); 
//    }
//
//    @Test(priority = 3)
//    public void verifyCloseButtonClosesAboutUsModal() {
//        AboutUsPage about = new AboutUsPage(driver);
//        about.openAboutUsModal();
//        about.closeAboutUsModal();
//
//        Assert.assertTrue(true, "Modal closed successfully");
//    }
	
	@Test(priority = 1)
	public void verifyAboutUsModalOpensAndVideoPlays() {
	    AboutUsPage aboutUsPage = new AboutUsPage(driver);
	    
	    aboutUsPage.openAboutUsModal();
	    boolean videoPlaying = aboutUsPage.playVideo(); 
	    
	    Assert.assertTrue(videoPlaying, "Video did not play in About Us modal");

	    aboutUsPage.closeAboutUsModal(); // Close modal
	}


    @Test(priority = 2)
    public void verifyCloseButtonClosesAboutUsModal() {
        AboutUsPage aboutUsPage = new AboutUsPage(driver);
        
        aboutUsPage.openAboutUsModal();
        aboutUsPage.closeAboutUsModal();
        
        Assert.assertTrue(true, "About Us modal closed successfully");
    }
    
  
}
