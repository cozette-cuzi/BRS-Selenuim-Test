import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutService extends BaseService {

    public LogoutService(WebDriver driver) throws IOException {
        super(driver);
    }

    public boolean logout() {
        this.click(this.locators.navbarDropdownLocator);
        this.click(this.locators.logoutLocator);
        WebElement navbar = this.waitVisibilityAndReturnElement(this.locators.navbarLocator);
        return navbar.getText().contains("Login");
    }

}
