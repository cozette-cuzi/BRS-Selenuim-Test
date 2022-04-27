
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseService {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Locators locators;

    public BaseService(WebDriver driver) throws IOException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        this.driver.manage().window().maximize();
        this.locators = new Locators();
    }

    protected WebElement waitVisibilityAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    protected String bodyText() {
        WebElement body = this.waitVisibilityAndReturnElement(this.locators.bodyLocator);
        return body.getText();
    }

    protected void click(By locator) {
        WebElement element = this.waitVisibilityAndReturnElement(locator);
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendKeys(By locator, String input) {
        WebElement element = this.waitVisibilityAndReturnElement(locator);
        element.sendKeys(input);
    }

    protected void applyScroll() {
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight); console.log('scrolled');");

    }

    protected void fillFormInput(HashMap<String, String> data) {
        Iterator<Entry<String, String>> i = data.entrySet().iterator();
        while (i.hasNext()) {
            HashMap.Entry<String, String> item = (HashMap.Entry<String, String>) i.next();
            By inputLocator = By.name(item.getKey());
            this.sendKeys(inputLocator, item.getValue());
        }
    }

}
