package ModulePages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    
    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private By signUpLink = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signUpBtn = By.xpath("//button[text()='Sign up']");

    public void openSignUpModal() {

        List<WebElement> modals = driver.findElements(By.id("signInModal"));
        if (!modals.isEmpty() && modals.get(0).isDisplayed()) {
            driver.findElement(By.cssSelector("#signInModal .close")).click();
        }


        wait.until(ExpectedConditions.elementToBeClickable(signUpLink)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
    }

    public void signUp(String user, String pass) {
        clearFields();
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        wait.until(ExpectedConditions.elementToBeClickable(signUpBtn)).click();
    }

    public String getAlertText() {
        return wait.until(ExpectedConditions.alertIsPresent()).getText();
    }

   
    public void acceptAlert() {
        driver.switchTo().alert().accept();
        clearFields();
    }


    public void clearFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).clear();
        driver.findElement(passwordField).clear();
    }

    public boolean areFieldsCleared() {
        return driver.findElement(usernameField).getAttribute("value").isEmpty()
                && driver.findElement(passwordField).getAttribute("value").isEmpty();
    }
}
