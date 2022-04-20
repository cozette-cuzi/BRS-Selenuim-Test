import org.openqa.selenium.By;

public class Locators {
    public By loginLinkLocator = By.linkText("Login");
    public By searchFieldLocator = By.name("search");
    public By searchButtonLocator = By
            .xpath("//form//button[@class='btn btn-outline-light text-white  btn-sm']");
    public By navbarDropdownLocator = By.cssSelector("a#navbarDropdown");
    public By navbarLocator = By.id("navbarSupportedContent");
    public By logoutLocator = By.xpath("//a[@href='https://book-rentals-system.herokuapp.com/logout']");
    public By emailInputLocator = By.id("email");
    public By passwordInputLocator = By.id("password");
    public By loginButtonLocator = By.xpath("//button[normalize-space()=\"Login\"]");
    public By bodyLocator = By.tagName("body");
}
