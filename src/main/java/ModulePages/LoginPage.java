package ModulePages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
    WebDriverWait wait;

    By loginMenu = By.id("login2");
    By loginModal = By.id("logInModal");
    By username = By.id("loginusername");
    By password = By.id("loginpassword");
    By loginBtn = By.xpath("//button[text()='Log in']");
    By closeBtn = By.xpath("//button[text()='Close']");
    By logoutBtn = By.id("logout2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Alert handler
    public String handleAlertIfPresent() {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String text = alert.getText();
            alert.accept();
            return text;
        } catch (TimeoutException e) {
            return null;
        }
    }

    // ✅ Close modal safely
    public void closeModalIfOpen() {
        try {
            WebElement modal = driver.findElement(loginModal);
            if (modal.isDisplayed()) {
                driver.findElement(closeBtn).click();
                wait.until(ExpectedConditions.invisibilityOf(modal));
            }
        } catch (Exception ignored) {}
    }

    public void openLoginModal() {
        handleAlertIfPresent();
        closeModalIfOpen();

        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(loginMenu));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", menu);

        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));
    }

    public void enterUsername(String user) {
        WebElement u = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        u.clear();
        if (!user.isEmpty()) u.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WebElement p = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        p.clear();
        if (!pass.isEmpty()) p.sendKeys(pass);
    }

    public void clickLogin() {
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", login);
    }
    public boolean isLoginSuccessful() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void login(String user, String pass) {
        openLoginModal();
        enterUsername(user);
        enterPassword(pass);
        clickLogin(); 
    }

}
