import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {
     // to do
    @Test
    public void checkUrl() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        assertTrue(loginPage.checkCurrentUrl().contains("inventory"));

    }

    @Test
    public void itemElementsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());

        assertEquals(6, inventoryPage.getItemsQuantity());

        inventoryPage.inventoryItemsAreDisplayed(); // 1 вариант
        assertTrue(inventoryPage.allItemsAreDisplayed()); // 2 вариант

        inventoryPage.inventoryImagesAreDisplayed(); // проверка отображения всех фото товаров

        assertTrue(inventoryPage.allItemsNamesAreDisplayed());
        assertTrue(inventoryPage.allItemsNamesNotEmpty());

  //      assertTrue("Not all names start with Sauce Labs", inventoryPage.allNamesStartWithSauceLabs());

    }

    @Test
    public void sortPriceLowToHigh() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        // choose "Price Low to high"
        inventoryPage.choosePriceLowToHighSortOption();
        // check correct sort by "Price Low to high"
        assertTrue(inventoryPage.checkSortFromLowToHigh());
    }

    @Test
    public void sortPriceHighToLow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.choosePriceHighToLowSortOption();
        assertTrue(inventoryPage.checkSortFromHighToLow());
    }

    //Sort by name (A-Z)
    @Test
    public void sortNameAtoZ() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.chooseAToZSortOption();
        assertTrue(inventoryPage.checkNameSortFromAToZ());

    }

    //Sort by name (Z-A)
    @Test
    public void sortNameZtoA() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.chooseZToASortOption();
        assertTrue(inventoryPage.checkNameSortFromZToA());

    }
}
