package ModulePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By addToCartBtn = By.linkText("Add to cart");
    private By productTitle = By.cssSelector(".name");

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
    }

    public boolean isProductPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).isDisplayed();
    }
}
