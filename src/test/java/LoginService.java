import org.openqa.selenium.*;

public class LoginService extends BaseService {

    private final By navbarDropdownLocator = By.cssSelector("a#navbarDropdown");

    public LoginService(WebDriver driver) {
        super(driver);
    }

    public void visitLgoinPage() {
        this.click(this.locators.loginLinkLocator);
    }

    public String loginWithCredetials(String email, String password) {
        this.sendKeys(this.locators.emailInputLocator, email);
        this.sendKeys(this.locators.passwordInputLocator, password);
        this.click(this.locators.loginButtonLocator);

        WebElement navbarDropdown = this.waitVisibilityAndReturnElement(this.locators.navbarDropdownLocator);
        return "username is " + navbarDropdown.getText();
    }

}
