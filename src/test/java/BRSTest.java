import java.util.*;

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
        GenreService genreService = new GenreService(this.driver);
        BookService bookService = new BookService(this.driver);

        mainPage.visitLgoinPage();
        String username = loginService.loginWithCredetials("cozette@gmail.com", "password");
        System.out.println(username);

        boolean visited = genreService.visitAddGenrePage();

        HashMap<String, String> genre = this.genreData();
        genreService.addNewGenre(genre);
        System.out.println("Add new Genre Opened is " + visited);

        boolean visitedBook = genreService.visitAddBookPage();
        System.out.println("Add new Book Opened is " + visitedBook);

        HashMap<String, String> book = this.bookData();
        bookService.addNewBook(book);

        if (mainPage.bodyText().contains(genre.get("name"))) {
            System.out.println(genre.get("name") + " Genre Found.");
        } else {
            System.out.println(genre.get("name") + "Genre Not Found!");
        }

        if (mainPage.searchForBook(book.get("name"))) {
            System.out.println(book.get("name") + " Book Found.");
        } else {
            System.out.println(book.get("name") + "Book Not Found!");
        }

        boolean loggedOut = logoutService.logout();
        System.out.println(loggedOut ? "Logout Successful." : "Logout Failed!");
    }

    private HashMap<String, String> bookData() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", "The Art of Software Testing");
        data.put("released_at", "09022010");
        data.put("authors", "Corey Sandler, Tom Badgett");
        data.put("pages", "256");
        data.put("in_stock", "10");
        data.put("description",
                "The hardware and software of computing have changed markedly in the three decades since the first edition of The Art of Software Testing, but this book's powerful underlying analysis has stood the test of time. ");
        data.put("isbn", "978316148" + String.valueOf((int) Math.floor(Math.random() * (9999 - 1000 + 1) + 1000)));
        return data;
    }

    private HashMap<String, String> genreData() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", "Art");
        return data;
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
