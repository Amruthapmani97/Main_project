package ModulePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public HomePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }

    private void scrollTo(WebElement el) {
        js.executeScript("arguments[0].scrollIntoView(true);", el);
    }

    private void click(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        scrollTo(el);
        el.click();
    }

    private WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean isLogoDisplayed() {
        return waitVisible(By.cssSelector(".navbar-brand")).isDisplayed();
    }

    public void clickHome() {
        click(By.xpath("//a[text()='Home ']"));
    }

    public void clickContact() {
        click(By.xpath("//a[text()='Contact']"));
    }

    public void closeContactModal() {
        click(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[1]"));
    }

    public void clickAbout() {
        click(By.xpath("//a[text()='About us']"));
    }

    public void closeAboutModal() {
        click(By.xpath("//*[@id=\"videoModal\"]/div/div/div[3]/button"));
    }
    
    public void clickCart() {
        click(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a"));
    }
    
   
    public void clickLogin() {
        click(By.xpath("//*[@id=\"login2\"]"));
    }

    public void closeLoginModal() throws InterruptedException {
        click(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]"));
        Thread.sleep(1000);
    }

    public void clickSignup() {
        click(By.xpath("//*[@id=\"signin2\"]"));
    }

    public void closeSignupModal() {
        click(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[1]"));
    }

    public void goHome() {
        click(By.xpath("//a[text()='Home ']"));
    }

    public boolean clickNextButton() {
        click(By.cssSelector(".carousel-control-next"));
        return true;
    }

    public boolean clickPreviousButton() {
        click(By.cssSelector(".carousel-control-prev"));
        return true;
    }

    public void selectCategory(String category) {
        click(By.linkText(category));
    }

    public boolean verifyCategoryLoaded(String category) {
        return driver.getPageSource().contains(category);
    }

    public boolean isProductCardDisplayed() {

        WebElement title = waitVisible(By.xpath("//div[@id='tbodyid']//a[@class='hrefch']"));
        WebElement price = waitVisible(By.xpath("//div[@id='tbodyid']//h5"));
        WebElement image = waitVisible(By.xpath("//div[@id='tbodyid']//img"));

        return title.isDisplayed() && price.isDisplayed() && image.isDisplayed();
    }

    public void clickAddToCart() {
        click(By.xpath("//a[text()='Add to cart']"));
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isFooterVisible() {
        WebElement footer = waitVisible(By.id("footc"));
        return footer.isDisplayed();
    }
}
