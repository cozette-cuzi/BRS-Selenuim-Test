
import java.io.IOException;

import org.openqa.selenium.*;

public class MainPage extends BaseService {

    public MainPage(WebDriver driver) throws IOException {
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

    public String pageTitle() {
        return this.driver.getTitle();
    }

}
