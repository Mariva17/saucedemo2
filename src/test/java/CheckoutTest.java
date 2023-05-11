import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void testSuccessCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBoltTShirtAddToCart();
        inventoryPage.clickOnFleeceJacketToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("John");
        checkoutStepOnePage.enterValueToLastName("Smith");
        checkoutStepOnePage.enterValueToZip("45612");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.clickOnFinishButton();
        CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage(driver);
        System.out.println("Text from complete page: " + checkOutCompletePage.getSuccessMessageText());
        assertTrue(checkOutCompletePage.getSuccessMessageText().contains("Thank you for your order!"));
        assertEquals("Thank you for your order!", checkOutCompletePage.getSuccessMessageText());


    }
    @Test
    public void testPriceInCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBoltTShirtAddToCart();
        inventoryPage.clickOnFleeceJacketToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("John");
        checkoutStepOnePage.enterValueToLastName("Smith");
        checkoutStepOnePage.enterValueToZip("45612");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        assertEquals(cartPage.getPriceOfFirstAddedItem(), checkoutStepTwoPage.getPriceOfAddedItem());
        assertEquals(cartPage.getPriceOfAllAddedItems(), checkoutStepTwoPage.getAllPricesAddedItems());
    }
    @Test
    public void checkFinalCost() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBoltTShirtAddToCart();
        inventoryPage.clickOnFleeceJacketToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);

        double totalFromCart = cartPage.getTotalPriceOfItems();

        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("John");
        checkoutStepOnePage.enterValueToLastName("Smith");
        checkoutStepOnePage.enterValueToZip("45612");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);

        assertEquals(totalFromCart, checkoutStepTwoPage.getItemTotal(), 0);

    }




}
