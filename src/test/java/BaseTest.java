import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class BaseTest {
    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/C:/Program Files/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }
    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
    String validUserNameValue = "standard_user";
    String validUserPasswordValue = "secret_sauce";
    User validUser = new User(validUserNameValue, validUserPasswordValue);
    User lockedOutUser = new User("locked_out_user", "secret_sauce");
    User invalidDataUser = new User("klon@gma", "secret_sauce");

}
