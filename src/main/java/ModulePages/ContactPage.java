package ModulePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
//	WebDriver driver;
//	WebDriverWait wait;
//	
//    private By contactLink = By.linkText("Contact");
//    private By emailField = By.id("recipient-email");
//    private By nameField = By.id("recipient-name");
//    private By messageField = By.id("message-text");
//    private By sendMessageBtn = By.xpath("//button[text()='Send message']");
//    private By closeButton = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]");
//    
//    public ContactPage(WebDriver driver) {
//    	this.driver= driver;
//    	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//    }
//    
////    public void openContactModal() {
////        //driver.findElement(contactLink).click();
////    	wait.until(ExpectedConditions.elementToBeClickable(contactLink));
////        ((WebElement) contactLink).click();
////        //wait.until(ExpectedConditions.visibilityOf(contactLink));
////    }
//    
//    public void openContactModal() {
//
//        WebElement contact =
//                wait.until(ExpectedConditions.elementToBeClickable(contactLink));
//
//        contact.click();
//    }
//
//    public void enterEmail(String email) {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
//    }
//
//    public void enterName(String name) {
//        driver.findElement(nameField).sendKeys(name);
//    }
//
//    public void enterMessage(String message) {
//        driver.findElement(messageField).sendKeys(message);
//    }
//
//    public void clickSendMessage() {
//        driver.findElement(sendMessageBtn).click();
//    }
//
//    public String getAlertText() {
//        wait.until(ExpectedConditions.alertIsPresent());
//        return driver.switchTo().alert().getText();
//    }
//
//    public void acceptAlert() {
//        driver.switchTo().alert().accept();
//    }
//    
//    public void closeContactModal() {
//        WebElement close = wait.until(ExpectedConditions.elementToBeClickable(closeButton));
//        close.click();
//
//        // wait until modal disappears
//        //wait.until(ExpectedConditions.invisibilityOf(contactModal));
//    }


	

    WebDriver driver;
    WebDriverWait wait;

    private By contactLink = By.linkText("Contact");
    private By emailField = By.id("recipient-email");
    private By nameField = By.id("recipient-name");
    private By messageField = By.id("message-text");
    private By sendMessageBtn = By.xpath("//button[text()='Send message']");
    private By closeButton = By.xpath("//*[@id='exampleModal']/div/div/div[3]/button[1]");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    public void openContactModal() {
        WebElement contact =
                wait.until(ExpectedConditions.elementToBeClickable(contactLink));
        contact.click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField))
            .sendKeys(email);
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterMessage(String message) {
        driver.findElement(messageField).sendKeys(message);
    }

    public void clickSendMessage() {
        driver.findElement(sendMessageBtn).click();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void closeContactModal() {
        WebElement close =
                wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        close.click();
    }
}
