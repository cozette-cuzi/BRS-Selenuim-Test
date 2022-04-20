
import org.openqa.selenium.*;


public class MainPage extends BaseService{

    private final String URL = "https://book-rentals-system.herokuapp.com/";

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get(URL);
    }

    public void visitLgoinPage() { 
        By loginLinkLocator = By.linkText("Login");
        this.click(loginLinkLocator);
    }

    public boolean searchForBook(String book) {
        By searchFieldLocator = By.name("search");
        this.sendKeys(searchFieldLocator, book);

        By searchButtonLocator = By
                .xpath("//form//button[@class='btn btn-outline-light text-white  btn-sm']");
        this.click(searchButtonLocator);
        return this.bodyText().contains(book);
    }

    
}
