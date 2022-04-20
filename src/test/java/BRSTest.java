import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

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
        LoginService loginService = new LoginService(this.driver);
        LogoutService logoutService = new LogoutService(this.driver);

        if (mainPage.searchForBook("Aperiam iusto")) {
            System.out.println("Book Found");
        } else {
            System.out.println("Book Not Found!");
        }

        mainPage.visitLgoinPage();
        String username = loginService.loginWithCredetials("cozette@gmail.com", "password");
        System.out.println(username);

        boolean loggedOut = logoutService.logout();
        System.out.println(loggedOut? "Logout Successful" : "Logout Failed!");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
