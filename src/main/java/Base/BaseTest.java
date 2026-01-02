package Base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import ModulePages.HomePage;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected HomePage home;

    @BeforeClass
    public void setup() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        js = (JavascriptExecutor) driver;

        driver.get("https://demoblaze.com/index.html");

        home = new HomePage(driver, wait, js);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

//protected WebDriver driver;
//protected WebDriverWait wait;
//
//
//@Parameters("browser")
//@BeforeClass
//public void setup(String browser) {
//if (browser.equalsIgnoreCase("chrome")) {
//WebDriverManager.chromedriver().setup();
//driver = new ChromeDriver();
//} else if (browser.equalsIgnoreCase("edge")) {
//WebDriverManager.edgedriver().setup();
//driver = new EdgeDriver();
//}
//
//
//driver.manage().window().maximize();
//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//driver.get("https://www.demoblaze.com/index.html");
//}
//
//
//@AfterClass
//public void tearDown() {
//driver.quit();
//}
