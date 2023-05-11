import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class CartTest extends BaseTest{

    @Test
    public void successAdding1Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        String backPriceFromInventory = inventoryPage.getPriceOfFirstItem();
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertEquals(1, cartPage.getItemsQuantity());

        // price is correct
        //assert price from inventory == price from cart :
        assertEquals(inventoryPage.getPriceOfFirstItem(), cartPage.getPriceOfFirstAddedItem());

    }
    @Test
    public void successAdding3Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBoltTShirtAddToCart();
        inventoryPage.clickOnFleeceJacketToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertEquals(3, cartPage.getItemsQuantity());
    }
    @Test
    public void checkCartIsEmpty() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.nullItems());
    }
    @Test
    public void emptyCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartIsEmpty());
    }

}

// check cart is empty