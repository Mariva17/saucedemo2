import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Double.parseDouble;

public class CheckoutStepTwoPage extends BasePage {

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemsPrices;


    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;

    public void clickOnFinishButton() {
        finishButton.click();
    }
    public String getPriceOfAddedItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(itemsPrices.get(0)));
        return itemsPrices.get(0).getText();
    }
    public String getAllPricesAddedItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(itemsPrices.get(0)));
        String pr = "0";
        for (WebElement price : itemsPrices) {
            pr = price.getText();
        }
        return pr;
    }

    public double getItemTotal(){
        return parseDouble(itemTotal.getText().replace("Item total: $", ""));

    }

}
