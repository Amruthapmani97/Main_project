package ModulePages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public CategoriesPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }

    private By categoryLink(String name) {
        return By.linkText(name);
    }

    private By productByIndex(int index) {
        return By.xpath("(//div[@id='tbodyid']//a[@class='hrefch'])[" + index + "]");
    }

    public void selectCategory(String category) {
        wait.until(ExpectedConditions.elementToBeClickable(categoryLink(category))).click();
    }

    public void openProduct(int index) {
        wait.until(ExpectedConditions.elementToBeClickable(productByIndex(index))).click();
    }
}
