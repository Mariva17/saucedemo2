import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.parseDouble;
import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_list")
    private WebElement inventorylist;

    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(css = "img[class='inventory_item_img']")
    private List<WebElement> inventoryItemsImages;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryNames;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackToCart;
    @FindBy(id ="add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement boltTShirtToCart;

    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement fleeceJacketToCart;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(className = "product_sort_container")
    private WebElement sortDropDown;

    @FindBy(css = "[value='lohi']")
    private WebElement lowToHigh;

    @FindBy(css = "[value='hilo']")
    private WebElement highToLow;

    @FindBy(css = "[value='az']")
    private WebElement AtoZ;
    @FindBy(css = "[value='za']")
    private WebElement ZtoA;

    @Step("Inventory page is open")
    public boolean goToInventoryList() {
        return inventorylist.isDisplayed();
    }

    public int getItemsQuantity() {
        return inventoryItems.size();
    }

    public void inventoryItemsAreDisplayed() {
        for (WebElement inventoryItem : inventoryItems) {
            assertTrue(inventoryItem.isDisplayed());
        }
    }

    public void inventoryImagesAreDisplayed() {
        for (WebElement inventoryItemsImage : inventoryItemsImages) {
            assertTrue(inventoryItemsImage.isDisplayed());
        }
    }

    public boolean allItemsAreDisplayed() {
        boolean displayed = true;
        for (WebElement item : inventoryItems) {
            if (!item.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }
    public boolean allItemsNamesNotEmpty() {
        boolean notEmpty = true;

        for (WebElement itemsName : inventoryNames) {
            String text = itemsName.getText();
            if (text.isEmpty()) {
                notEmpty = false;
            }
        }
        return notEmpty;
    }
    public boolean allItemsNamesAreDisplayed() {
        boolean displayed = true;
        for (WebElement name : inventoryNames) {
            if (!name.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }
    public void checkURLContainsInventory() {
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains("inventory"));

    }
    public boolean allNamesStartWithSauceLabs() {
        boolean hasText = true;
 //       int index = 1;
        for (WebElement text : inventoryNames) {
            if (!text.getText().startsWith("Sauce Labs")) {
                hasText = false;
                System.out.println("Item with product number " + (inventoryNames.indexOf(text)+1) + " does not start with Sauce Labs");
            }
 //           index++;
        }
        return hasText;
    }

    public void clickOnBurgerMenuBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuButton));
        burgerMenuButton.click();
    }

    public void clickOnBackpackAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backpackToCart));
        backpackToCart.click();
    }
    public void clickOnCartItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();

    }

    public void clickOnBoltTShirtAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(boltTShirtToCart));
        boltTShirtToCart.click();
    }
    public void clickOnFleeceJacketToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(fleeceJacketToCart));
        fleeceJacketToCart.click();
    }

    public String getPriceOfFirstItem() {
        return inventoryPrices.get(0).getText();

    }
    public void choosePriceLowToHighSortOption() {
        clickOnTheElement(sortDropDown);
        clickOnTheElement(lowToHigh);
    }

    public void choosePriceHighToLowSortOption() {
        clickOnTheElement(sortDropDown);
        clickOnTheElement(highToLow);
    }


    public boolean checkSortFromLowToHigh() {
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1))); // price.getText().replaceAll("[^0-9.]", "") - всё что кроме от нуля до девяти и точки, заменить на ничего, т.е. оставить только цифры и точки
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        return actualPrices.equals(expectedPrices);
    }
    public boolean checkSortFromHighToLow() {
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1))); // price.getText().replaceAll("[^0-9.]", "") - всё что кроме от нуля до девяти и точки, заменить на ничего, т.е. оставить только цифры и точки
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices, Collections.reverseOrder());

        return actualPrices.equals(expectedPrices);
    }

    public void chooseAToZSortOption() {
        clickOnTheElement(sortDropDown);
        clickOnTheElement(AtoZ);
    }
    public void chooseZToASortOption() {
        clickOnTheElement(sortDropDown);
        clickOnTheElement(ZtoA);
    }

    public boolean checkNameSortFromAToZ() {
        List<String> actualNames = new ArrayList<>();
        for (WebElement name : inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        return actualNames.equals(expectedNames);
    }
    public boolean checkNameSortFromZToA() {
        List<String> actualNames = new ArrayList<>();
        for (WebElement name : inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames, Collections.reverseOrder());

        return actualNames.equals(expectedNames);
    }












}