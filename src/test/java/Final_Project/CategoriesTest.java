package Final_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import ModulePages.CategoriesPage;
import ModulePages.ProductPage;

public class CategoriesTest extends BaseTest {

    @Test
    public void addMultipleProductsFromCategory() {

        CategoriesPage categories = new CategoriesPage(driver, wait, js);
        ProductPage product = new ProductPage(driver, wait);

        categories.selectCategory("Phones");
        categories.openProduct(1);
        Assert.assertTrue(product.isProductPageLoaded());
        product.addToCart();

        driver.navigate().back();

        categories.openProduct(2);
        product.addToCart();
    }
}

