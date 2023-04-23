import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/C:/Program Files/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }
    @After
    public void tearDown() throws InterruptedException {
        sleep(2000);
        driver.quit();
    }
    @Test
    public void loginWithValidData() {
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement inventorylist = driver.findElement(By.className("inventory_list"));
        assertTrue(inventorylist.isDisplayed());

    }
    @Test
    public void loginWithValidDataPD() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName("standard_user");
        loginPage.enterValueToPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.goToInventoryList();
    }


}
