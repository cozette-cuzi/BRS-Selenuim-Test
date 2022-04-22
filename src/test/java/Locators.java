import org.openqa.selenium.By;

public class Locators {
    public final String URL = "https://book-rentals-system.herokuapp.com/";
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
    public By librarianActionsLocator = By.linkText("Librarian Actions");
    // Add new Book locators
    public By addBookLocator = By.xpath("//a[@href='https://book-rentals-system.herokuapp.com/books/create']");
    public By genresDropdownLocator = By.id("dropdownMenuButton1");
    public By genreCheckBoxLocator = By.id("flexCheckDefault1");
    public By bookSubmitButtonLocator = By.id("submit-button");
    // Add new Genre locators
    public By addGenreLocator = By.xpath("//a[@href='https://book-rentals-system.herokuapp.com/genres/create']");
    public By genresubmitButtonLocator = By.xpath("//*[text()='Submit']");
    public By selectLocator = By.name("style");
    public By primaryOptionLocator = By.xpath("//option[@value='primary']");
}