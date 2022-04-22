import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BookService extends BaseService {
    public BookService(WebDriver driver) {
        super(driver);
    }

    public boolean addNewBook(HashMap<String, String> data) {
        Iterator i = data.entrySet().iterator();
        while (i.hasNext()) {
            HashMap.Entry<String, String> item = (HashMap.Entry<String, String>) i.next();
            By inputLocator = By.name(item.getKey());
            this.sendKeys(inputLocator, item.getValue());
            System.out.println(item.getKey() + " : " + item.getValue());
        }
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
