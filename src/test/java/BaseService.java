import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseService {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final By bodyLocator = By.tagName("body");

    public BaseService(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }
    

    protected WebElement waitVisibilityAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    
    protected String bodyText() {
        WebElement body = this.waitVisibilityAndReturnElement(bodyLocator);
        return body.getText();
    }

    protected void click(By locator) {
        WebElement element = this.waitVisibilityAndReturnElement(locator);
        element.click();
    }

    protected void sendKeys(By locator, String input) {
        WebElement element = this.waitVisibilityAndReturnElement(locator);
        element.sendKeys(input);
    }
}
