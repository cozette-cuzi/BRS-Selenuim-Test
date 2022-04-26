import java.io.IOException;
import java.util.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TypingTest {

    private WebDriver driver;
    private Properties props;
    private TypingMainPage typingMainPage;

    @Before
    public void setup() throws IOException {
        ConfigFileReader reader = new ConfigFileReader();
        this.props = reader.readConfigFile();
        System.setProperty("webdriver.chrome.driver", props.getProperty("DriverPath"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.typingMainPage = new TypingMainPage(this.driver);
    }

    @Test
    public void testTyping() {
        this.typingMainPage.type();
    }

    // @After
    // public void close() {
    // if (driver != null) {
    // driver.quit();
    // }
    // }

}
