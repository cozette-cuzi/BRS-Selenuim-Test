
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.openqa.selenium.*;

public class TypingMainPage extends BaseService {

    public TypingMainPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver.get(this.locators.typingBaseURL);
        this.addCookieConsent();
        // this.driver.get(this.locators.typingBaseURL);
    }

    public void type() {
        WebElement element = this.waitVisibilityAndReturnElement(this.locators.displayLocator);
        String input = element.getText();
        String[] arr = input.split("_");
        for (String ch : arr) {
            this.sendKeys(this.locators.bodyLocator, ch + " ");
        }

        WebElement wpm = this.waitVisibilityAndReturnElement(this.locators.wpmLocator);
        System.out.println("Your Result is: " + wpm.getText() + " WPM :D");
    }

    public void addCookieConsent() {
        try {
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse("01/01/2024");
            Cookie ck = new Cookie("cookieconsent_status", "dismiss", "typing-speedtest.com", "/", date, false);
            System.out.println("Cookie " + ck.getExpiry());
            this.driver.manage().addCookie(ck);
            this.driver.navigate().refresh();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
