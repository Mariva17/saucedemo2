import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AssumptionViolatedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    public void tearDown() throws InterruptedException {
        driver.quit();
    }
    @Rule
    public TestWatcher screenShotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            //make screenshot
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }

        @Override
        protected void succeeded(Description description) {
            driver.close();
            driver.quit();
        }

        @Attachment
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        }
    };
    String validUserNameValue = "standard_user";
    String validUserPasswordValue = "secret_sauce";
    User validUser = new User(validUserNameValue, validUserPasswordValue);
    User lockedOutUser = new User("locked_out_user", "secret_sauce");
    User invalidDataUser = new User("klon@gma", "secret_sauce");

}
