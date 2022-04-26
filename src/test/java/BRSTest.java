import java.io.IOException;
import java.util.*;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.data.MapBasedDataMaster.Data;
import io.codearte.jfairy.producer.person.Address;

import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;

public class BRSTest {

    private WebDriver driver;
    private BRSMainPage mainPage;
    private LoginService loginService;
    private LogoutService logoutService;
    private GenreService genreService;
    private BookService bookService;
    private Properties props;
    private Fairy fairy;

    @Before
    public void setup() throws IOException {
        ConfigFileReader reader = new ConfigFileReader();
        this.props = reader.readConfigFile();
        System.setProperty("webdriver.chrome.driver", props.getProperty("DriverPath"));
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        this.mainPage = new BRSMainPage(this.driver);
        this.loginService = new LoginService(this.driver);
        this.logoutService = new LogoutService(this.driver);
        this.genreService = new GenreService(this.driver);
        this.bookService = new BookService(this.driver);
        this.fairy = Fairy.create();
    }

    @Test
    public void testBookRentalsSystem() {
        mainPage.visitLgoinPage();
        String username = loginService.loginWithCredetials(props.getProperty("email"), props.getProperty("password"));
        System.out.println(username);
        System.out.println("Page Title: " + mainPage.pageTitle());

        genreService.visitAddGenrePage();
        HashMap<String, String> genre = this.genreData();
        genreService.addNewGenre(this.genreData());

        if (mainPage.bodyText().contains(genre.get("name"))) {
            System.out.println(genre.get("name") + " Genre Found.");
        } else {
            System.out.println(genre.get("name") + "Genre Not Found!");
        }

        genreService.visitAddBookPage();
        HashMap<String, String> book = this.bookData();
        bookService.addNewBook(book);

        if (mainPage.searchForBook(book.get("name"))) {
            System.out.println(book.get("name") + " Book Found.");
        } else {
            System.out.println(book.get("name") + "Book Not Found!");
        }

        boolean loggedOut = logoutService.logout();
        System.out.println(loggedOut ? "Logout Successful." : "Logout Failed!");
    }

    private HashMap<String, String> bookData() {
        Random r = new Random();
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", fairy.textProducer().word(3));
        data.put("released_at", "09022010");
        data.put("authors", fairy.person().getFullName());
        data.put("pages", String.valueOf((int) Math.floor(r.nextInt(500 - 100) + 100)));
        data.put("in_stock", "10");
        data.put("description", fairy.textProducer().paragraph(4));
        data.put("isbn", "97831614" + String.valueOf((int) Math.floor(r.nextInt(99999 - 10000) + 10000)));

        return data;
    }

    private HashMap<String, String> genreData() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", fairy.textProducer().word(2));
        return data;
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
