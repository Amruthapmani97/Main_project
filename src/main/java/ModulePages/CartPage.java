package ModulePages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    private By cartMenu = By.id("cartur");
    private By cartRows = By.cssSelector("tr.success");
    private By deleteBtn = By.linkText("Delete");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartMenu)).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartRows));
    }

    public int getCartItemCount() {
        List<WebElement> rows =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartRows));
        return rows.size();
    }

    public void deleteFirstItem() {
        List<WebElement> rows =
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartRows));
        int countBefore = rows.size();

        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(cartRows, countBefore - 1));
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }
}
