import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class LoginTest extends BaseTest {


    @Test @DisplayName("Success Login")
    @Description("Login with valid data")
    public void loginWithValidDataPD() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName(validUser);
        loginPage.enterValueToPassword(validUser);
        loginPage.clickOnLoginButton();
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue("Inventory page is NOT open", inventoryPage.goToInventoryList());

        /* Паттерный метод
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.enterValueToUserName(validUser)
                     .enterValueToPassword(validUser)
                     .clickOnLoginButton().inventoryListIsDisplayed());
         */
    }


    public void loginWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName(lockedOutUser);
        loginPage.enterValueToPassword(lockedOutUser);
        loginPage.clickOnLoginButton();
//       assertTrue(loginPage.getErrorMessage()); // проверка на получение сообщения об ошибке
//        loginPage.errorMessageTextIsCorrect("Epic sadface: Sorry, this user has been locked out."); // проверка, что получили опред.текст ошибки
        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessageText());
        assertTrue(loginPage.getErrorMessageText().contains("Sorry, this user has been locked out"));

    }

    public void loginWithInvalidData() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName(invalidDataUser);
        loginPage.enterValueToPassword(invalidDataUser);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains("Username and password do not match any user in this service"));
    }

    public void successLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.goToInventoryList());
        inventoryPage.clickOnBurgerMenuBtn();
        SideBar sideBar = new SideBar(driver);
        sideBar.clickOnLogoutButton();
        assertTrue(loginPage.loginButtonIsDisplayed());

    }






}
