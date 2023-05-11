import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {

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

        assertTrue("Not all names start with Sauce Labs", inventoryPage.allNamesStartWithSauceLabs());




    }


}
