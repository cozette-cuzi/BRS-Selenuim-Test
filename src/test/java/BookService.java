import org.openqa.selenium.WebDriver;

public class BookService extends BaseService {

    public BookService(WebDriver driver) {
        super(driver);
    }

    public boolean visitAddBookPage() {
        this.click(this.locators.librarianActionsLocator);
        this.click(this.locators.addBookLocator);
        return this.bodyText().contains("Add New Book");
    }



}
