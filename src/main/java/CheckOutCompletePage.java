import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutCompletePage extends BasePage {


    public CheckOutCompletePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(className = "complete-header")
    private WebElement successMessage;

    public String getSuccessMessageText() {
        return successMessage.getText();
    }


}
