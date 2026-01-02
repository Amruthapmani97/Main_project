package ModulePages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AboutUsPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    By aboutUsLink = By.linkText("About us");
    By aboutUsModal = By.id("videoModal");
    By closeButton = By.cssSelector("#videoModal .close");
    By videoPlayer = By.id("example-video_html5_api"); // Correct video element

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout
        this.js = (JavascriptExecutor) driver;
    }

    // Open About Us modal
    public void openAboutUsModal() {
        WebElement aboutUs = wait.until(ExpectedConditions.elementToBeClickable(aboutUsLink));
        js.executeScript("arguments[0].click();", aboutUs); // JS click to avoid overlay issues
        wait.until(ExpectedConditions.visibilityOfElementLocated(aboutUsModal));
    }

    public boolean playVideo() {
        try {
            WebElement video = wait.until(ExpectedConditions.visibilityOfElementLocated(videoPlayer));

            // Scroll video into view
            js.executeScript("arguments[0].scrollIntoView(true);", video);

            // Mute video so autoplay works
            js.executeScript("arguments[0].muted = true;", video);

            // Click overlay/play button if exists
            By overlay = By.xpath("//*[@id='example-video']//button/span[1]");
            if (driver.findElements(overlay).size() > 0) {
                WebElement playButton = driver.findElement(overlay);
                js.executeScript("arguments[0].click();", playButton);
            }

            // Play video via JS
            js.executeScript("arguments[0].play();", video);

            Thread.sleep(2000); // Wait to ensure playback starts

            // Verify video is playing
            Boolean isPlaying = (Boolean) js.executeScript(
                "var video = document.getElementById('example-video_html5_api');" +
                "return video && !video.paused;"
            );

            System.out.println(isPlaying ? "Video is playing successfully." : "Video did not start playing.");
            return isPlaying;

        } catch (Exception e) {
            System.out.println("Error while playing video: " + e.getMessage());
            return false;
        }
    }

    // Close About Us modal
    public void closeAboutUsModal() {
        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        js.executeScript("arguments[0].click();", close);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(aboutUsModal));
    }

    // Check if video is displayed
    public boolean isVideoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(videoPlayer)).isDisplayed();
    }
}
