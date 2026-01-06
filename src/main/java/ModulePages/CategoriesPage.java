package ModulePages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    private By phoneCategory = By.linkText("Phones");
    private By laptopCategory = By.linkText("Laptops");
    private By productLinks = By.cssSelector("#tbodyid .card-title a");
    private By homeMenu = By.id("nava");

    public CategoriesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    public void clickPhonesCategory() {
        switchCategory(phoneCategory);
    }

    public void clickLaptopsCategory() {
        switchCategory(laptopCategory);
    }

    private void switchCategory(By category) {

        List<WebElement> oldProducts = driver.findElements(productLinks);
        WebElement firstOldProduct = oldProducts.isEmpty() ? null : oldProducts.get(0);

        WebElement cat = wait.until(ExpectedConditions.elementToBeClickable(category));
        js.executeScript("arguments[0].click();", cat);

        if (firstOldProduct != null) {
            wait.until(ExpectedConditions.stalenessOf(firstOldProduct));
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));
    }

    public void selectProductByIndex(int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));
        driver.findElements(productLinks).get(index).click();
    }

    public void goToHomePage() {
        js.executeScript("arguments[0].click();",
                wait.until(ExpectedConditions.elementToBeClickable(homeMenu)));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productLinks));
    }
}

