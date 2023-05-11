import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class SideBarTest extends BaseTest{
    @Test
    public void checkAllLinksAreEnabled() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());

        inventoryPage.clickOnBurgerMenuBtn();
 //       sleep(3000);

        SideBar sideBar = new SideBar(driver);
        assertTrue(sideBar.allItemsIsEnabled());
        assertTrue(sideBar.aboutIsEnabled());
        assertTrue(sideBar.logoutIsEnabled());
        assertTrue(sideBar.resetAppStateIsEnabled());
        assertTrue(sideBar.allItemsIsDisplayed());



    }
}
