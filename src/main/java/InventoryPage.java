import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public class InventoryPage {

WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(className="inventory_list")
    private WebElement inventorylist;

    @FindBy(className = "inventory_item")
    List<WebElement> inventoryItems;

    @FindBy(css = "img[class=\'inventory_item_img\']")
    List<WebElement> inventoryItemsImages;

    public  boolean goToInventoryList() {
        return inventorylist.isDisplayed();
    }

    public int getItemsQuantity() {
        return inventoryItems.size();
    }
    public boolean inventoryImagesAreDisplayed() {
        for (WebElement inventoryItemsImage : inventoryItemsImages) {
            inventoryItemsImage.isDisplayed();
        }
        return true;
    }


}
