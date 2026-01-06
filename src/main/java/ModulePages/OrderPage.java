package ModulePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import java.time.Duration;

public class OrderPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private By successMsg = By.xpath("//h2[text()='Thank you for your purchase!']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillOrderDetails(String name, String country, String city, String card, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).clear();
        driver.findElement(nameField).sendKeys(name);

        driver.findElement(countryField).clear();
        driver.findElement(countryField).sendKeys(country);

        driver.findElement(cityField).clear();
        driver.findElement(cityField).sendKeys(city);

        driver.findElement(cardField).clear();
        driver.findElement(cardField).sendKeys(card);

        driver.findElement(monthField).clear();
        driver.findElement(monthField).sendKeys(month);

        driver.findElement(yearField).clear();
        driver.findElement(yearField).sendKeys(year);
    }

    public void clickPurchase() {
        driver.findElement(purchaseBtn).click();
    }

    public String getAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public boolean isOrderSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
    }

    public void fillMandatoryFields() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys("Amrutha");
        driver.findElement(cardField).sendKeys("4111111111111111");
    }
}

