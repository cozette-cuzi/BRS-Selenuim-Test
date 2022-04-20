import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BRSTest {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testBookRentalsSystem() {
        MainPage mainPage = new MainPage(this.driver);
        mainPage.visitLgoinPage();
        String username = mainPage.loginWithCredetials("cozette@gmail.com", "password");
        System.out.println(username);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
