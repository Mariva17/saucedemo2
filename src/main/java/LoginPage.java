import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement userNameInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void enterValueToUserName(String userNameValue) {

        userNameInputField.sendKeys(userNameValue);
    }

    public void enterValueToPassword(String passwordValue) {
        passwordInputField.sendKeys(passwordValue);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }


}
