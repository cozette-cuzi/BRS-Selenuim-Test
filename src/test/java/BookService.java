import java.util.*;

import org.openqa.selenium.WebDriver;

public class BookService extends BaseService {
    public BookService(WebDriver driver) {
        super(driver);
    }

    public boolean addNewBook(HashMap<String, String> data) {
        this.fillFormInput(data);
        this.click(this.locators.genresDropdownLocator);
        this.click(this.locators.genreCheckBoxLocator);
        this.applyScroll();
        this.click(this.locators.bookSubmitButtonLocator);
        System.out.println(this.driver.getCurrentUrl());
        return this.driver.getCurrentUrl() == this.locators.URL;
    }

    public boolean visitAddBookPage() {
        this.click(this.locators.librarianActionsLocator);
        this.click(this.locators.addBookLocator);
        return this.bodyText().contains("Add New Book");
    }

}
