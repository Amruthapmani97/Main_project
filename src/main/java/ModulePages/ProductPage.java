package ModulePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    private By addToCartBtn = By.linkText("Add to cart");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void addProductToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }



}
