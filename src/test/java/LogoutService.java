import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutService extends BaseService {

    private final By navbarDropdownLocator = By.cssSelector("a#navbarDropdown");
    private final By navbarLocator = By.id("navbarSupportedContent");

    public LogoutService(WebDriver driver) {
        super(driver);
    }

    public boolean logout() {
        this.click(navbarDropdownLocator);
        By logoutLocator = By.xpath("//a[@href='https://book-rentals-system.herokuapp.com/logout']");
        this.click(logoutLocator);
        WebElement navbar = this.waitVisibilityAndReturnElement(navbarLocator);
        return navbar.getText().contains("Login");
    }

}
