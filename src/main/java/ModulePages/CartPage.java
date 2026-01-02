package ModulePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By cartMenu = By.id("cartur");
    private By cartRows = By.xpath("//tr[@class='success']");
    private By deleteBtn = By.xpath("//a[text()='Delete']");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    // Place Order modal
    private By name = By.id("name");
    private By country = By.id("country");
    private By city = By.id("city");
    private By card = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");

    // Confirmation popup
    private By confirmationPopup = By.cssSelector(".sweet-alert");
    private By confirmationText = By.cssSelector(".sweet-alert h2");
    private By okBtn = By.xpath("//button[text()='OK']");

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartMenu)).click();
    }

    public int getCartItemCount() {
        return driver.findElements(cartRows).size();
    }

    public void deleteAllItems() {
        while (driver.findElements(deleteBtn).size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(cartRows, getCartItemCount()));
        }
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void fillOrderDetails(String n, String ctry, String cty,
                                 String crd, String m, String y) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(name)).sendKeys(n);
        driver.findElement(country).sendKeys(ctry);
        driver.findElement(city).sendKeys(cty);
        driver.findElement(card).sendKeys(crd);
        driver.findElement(month).sendKeys(m);
        driver.findElement(year).sendKeys(y);
    }

    public String confirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseBtn)).click();
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationText)).getText();
    }

    public void closeConfirmation() {
        wait.until(ExpectedConditions.elementToBeClickable(okBtn)).click();
    }
}

