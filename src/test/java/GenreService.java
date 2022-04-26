import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebDriver;

public class GenreService extends BaseService {

    public GenreService(WebDriver driver) throws IOException {
        super(driver);
    }

    public boolean visitAddBookPage() {
        this.click(this.locators.librarianActionsLocator);
        this.click(this.locators.addBookLocator);
        return this.bodyText().contains("Add New Book");
    }

    public boolean visitAddGenrePage() {
        this.click(this.locators.librarianActionsLocator);
        this.click(this.locators.addGenreLocator);
        return this.bodyText().contains("Add New Genre");
    }

    public void addNewGenre(HashMap<String, String> data) {
        this.fillFormInput(data);
        this.click(this.locators.selectLocator);
        this.click(this.locators.optionLocator);
        this.click(this.locators.genresubmitButtonLocator);
    }

}
