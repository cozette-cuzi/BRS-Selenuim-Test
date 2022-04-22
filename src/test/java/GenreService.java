import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenreService extends BaseService {

    public GenreService(WebDriver driver) {
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
        Iterator i = data.entrySet().iterator();
        while (i.hasNext()) {
            HashMap.Entry<String, String> item = (HashMap.Entry<String, String>) i.next();
            By inputLocator = By.name(item.getKey());
            this.sendKeys(inputLocator, item.getValue());
            System.out.println(item.getKey() + " : " + item.getValue());
        }
        this.click(this.locators.selectLocator);
        this.click(this.locators.primaryOptionLocator);
        this.click(this.locators.submitButtonLocator);
    }

}
