import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import static org.junit.Assert.assertEquals;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "user-name")
    private WebElement userNameInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement error;

    @Step("Enter value to username")
    public void enterValueToUserName(User user) {
        enterTextToElement(user.getUsername(), userNameInputField);
    }

    @Step("Enter value to password")
    public void enterValueToPassword(User user) {
        enterTextToElement(user.getPassword(), passwordInputField);

    }
    @Step("Push the Login button")
    public void clickOnLoginButton() {
        clickOnTheElement(loginButton);
    }

    public boolean getErrorMessage() {

        return error.isDisplayed();
    }

    public void errorMessageTextIsCorrect(String expectedText) {
       assertEquals(expectedText, error.getText());
    }

    public String getErrorMessageText() {

        return getTextOfElement(error);
    }
    public void successLogin(User user) {
        userNameInputField.sendKeys(user.getUsername());
        passwordInputField.sendKeys(user.getPassword());
        loginButton.click();

    }

    public boolean loginButtonIsDisplayed() {
        return loginButton.isDisplayed();
    }


}
