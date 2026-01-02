package Final_Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import ModulePages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void cartAndOrderFlow() {

        CartPage cart = new CartPage(driver, wait);
        cart.openCart();

        Assert.assertTrue(cart.getCartItemCount() > 0);

        cart.clickPlaceOrder();
        cart.fillOrderDetails("Test User", "India", "Delhi",
                              "4111111111111111", "12", "2026");

        String confirmation = cart.confirmPurchase();
        Assert.assertTrue(confirmation.contains("Thank you"));

        cart.closeConfirmation();

        cart.openCart();
        cart.deleteAllItems();
        Assert.assertEquals(cart.getCartItemCount(), 0);
    }
}

