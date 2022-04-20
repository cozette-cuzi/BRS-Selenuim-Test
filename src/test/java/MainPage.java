import static org.junit.Assert.assertEquals;

// import org.junit.*;
import org.openqa.selenium.*;
// import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// import io.github.bonigarcia.wdm.WebDriverManager;

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String URL = "https://book-rentals-system.herokuapp.com/";
    private final By loginLinkLocator = By.linkText("Login");
    private final By emailInputLocator = By.id("email");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.xpath("//button[normalize-space()=\"Login\"]");
    private final By navbarDropdownLocator = By.cssSelector("a#navbarDropdown");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(URL);
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement waitVisibilityAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public void visitLgoinPage() {
        WebElement loginLink = this.waitVisibilityAndReturnElement(loginLinkLocator);
        loginLink.click();
    }

    public String loginWithCredetials(String email, String password) {
        WebElement emailField = this.waitVisibilityAndReturnElement(emailInputLocator);
        emailField.sendKeys(email);

        WebElement passwordField = this.waitVisibilityAndReturnElement(passwordInputLocator);
        passwordField.sendKeys(password);

        WebElement loginButton = this.waitVisibilityAndReturnElement(loginButtonLocator);
        loginButton.click();

        WebElement navbarDropdown = this.waitVisibilityAndReturnElement(navbarDropdownLocator);

        return "username is " + navbarDropdown.getText();
    }

}
