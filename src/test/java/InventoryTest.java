import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void itemQuantityTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());

        assertEquals(6, inventoryPage.getItemsQuantity());

        assertTrue(inventoryPage.inventoryImagesAreDisplayed());

    }


}
