import org.openqa.selenium.*;

public class LoginService extends BaseService {

    private final By navbarDropdownLocator = By.cssSelector("a#navbarDropdown");

    public LoginService(WebDriver driver) {
        super(driver);
    }

    public void visitLgoinPage() {
        By loginLinkLocator = By.linkText("Login");
        this.click(loginLinkLocator);
    }

    public String loginWithCredetials(String email, String password) {
        By emailInputLocator = By.id("email");
        By passwordInputLocator = By.id("password");

        this.sendKeys(emailInputLocator, email);
        this.sendKeys(passwordInputLocator, password);

        By loginButtonLocator = By.xpath("//button[normalize-space()=\"Login\"]");
        this.click(loginButtonLocator);

        WebElement navbarDropdown = this.waitVisibilityAndReturnElement(navbarDropdownLocator);
        return "username is " + navbarDropdown.getText();
    }

}
