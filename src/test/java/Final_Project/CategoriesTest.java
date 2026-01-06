package Final_Project;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import ModulePages.CartPage;
import ModulePages.CategoriesPage;
import ModulePages.OrderPage;
import ModulePages.ProductPage;

public class CategoriesTest extends BaseTest {

//	@Test
//	public void addMultipleItemsDeleteOneAndPlaceOrder() throws InterruptedException {
//
//	    CategoriesPage categories = new CategoriesPage(driver);
//	    ProductPage product = new ProductPage(driver);
//	    CartPage cart = new CartPage(driver);
//	    OrderPage order = new OrderPage(driver);
//
//	    categories.clickPhonesCategory();
//	    Thread.sleep(1000);
//	    categories.selectProductByIndex(0);
//	    Thread.sleep(1000);
//	    product.addProductToCart();
//	    Thread.sleep(1000);
//
	@DataProvider(name = "orderScenarios")
    public Object[][] orderScenarios() {
        return new Object[][] {
 
            {"", "", "", "", "", "", "Please fill out Name and Creditcard."}, 
            {"", "USA", "NYC", "4111111111111111", "12", "2026", "Please fill out Name and Creditcard."}, 
            {"John", "USA", "NYC", "", "12", "2026", "Please fill out Name and Creditcard."}, 
            {"John", "", "", "4111111111111111", "", "", ""}, 
            {"John", "USA", "NYC", "4111111111111111", "12", "2026", ""} 
        };
    }

    @Test
    public void addMultipleItemsDeleteOneAndPlaceOrder() throws InterruptedException {
        CategoriesPage categories = new CategoriesPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        OrderPage order = new OrderPage(driver);

        categories.goToHomePage();
        categories.clickPhonesCategory();
        categories.selectProductByIndex(0);
        product.addProductToCart(); 

        categories.goToHomePage();
        categories.clickLaptopsCategory();
        categories.selectProductByIndex(0);
        product.addProductToCart(); 

        cart.goToCart();
        Assert.assertEquals(cart.getCartItemCount(), 2, "Two items not added to cart");

        cart.deleteFirstItem(); 
        Assert.assertTrue(cart.getCartItemCount() <= 1, "Item not deleted from cart");

        cart.clickPlaceOrder();
        order.fillOrderDetails("Amrutha", "USA", "NYC", "4111111111111111", "12", "2026");
        Thread.sleep(1000);
        order.clickPurchase();
        Thread.sleep(1000);
        Assert.assertTrue(order.isOrderSuccessful(), "Order not placed successfully");
    }

    @Test(dataProvider = "orderScenarios")
    public void testPlaceOrder(String name, String country, String city,
                               String card, String month, String year,
                               String expectedAlert) throws InterruptedException {

        CategoriesPage categories = new CategoriesPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        OrderPage order = new OrderPage(driver);

        categories.goToHomePage();
        Thread.sleep(1000);
        categories.clickPhonesCategory();
        categories.selectProductByIndex(0);
        product.addProductToCart();
        Thread.sleep(1000);

        cart.goToCart();
        Thread.sleep(1000);
        cart.clickPlaceOrder();
        Thread.sleep(1000);

        order.fillOrderDetails(name, country, city, card, month, year);
        Thread.sleep(1000);
        order.clickPurchase();
        Thread.sleep(1000);

        if (!expectedAlert.isEmpty()) {
           
            String alertText = order.getAlertText();
            Assert.assertEquals(alertText, expectedAlert);
            order.acceptAlert();
        } else {

            Assert.assertTrue(order.isOrderSuccessful(), "Order not successful");
        }
    }
}


