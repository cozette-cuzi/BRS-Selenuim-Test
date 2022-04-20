
import org.openqa.selenium.*;

public class MainPage extends BaseService {

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get(this.locators.URL);
    }

    public void visitLgoinPage() {
        this.click(this.locators.loginLinkLocator);
    }

    public boolean searchForBook(String book) {
        this.sendKeys(this.locators.searchFieldLocator, book);

        this.click(this.locators.searchButtonLocator);
        return this.bodyText().contains(book);
    }

}
