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
    private final By bodyLocator = By.tagName("body");
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

    public boolean searchForBook(String book) {
        By searchFieldLocator = By.name("search");
        this.sendKeys(searchFieldLocator, book);

        By searchButtonLocator = By
                .xpath("//form//button[@class='btn btn-outline-light text-white  btn-sm']");
        this.click(searchButtonLocator);
        return this.bodyText().contains(book);
    }

    // public boolean logout() {
    //     this.click(navbarDropdownLocator);
    //     By logoutLocator = By.xpath("//div//a[@href='https://book-rentals-system.herokuapp.com/logout'");
    // }

    public String bodyText() {
        WebElement body = this.waitVisibilityAndReturnElement(bodyLocator);
        return body.getText();
    }

    private void click(By locator) {
        WebElement element = this.waitVisibilityAndReturnElement(locator);
        element.click();
    }

    private void sendKeys(By locator, String input) {
        WebElement element = this.waitVisibilityAndReturnElement(locator);
        element.sendKeys(input);
    }
}
