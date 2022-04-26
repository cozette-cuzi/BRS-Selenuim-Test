import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class Locators {
    public Properties properties;

    public Locators() throws IOException {
        ConfigFileReader reader = new ConfigFileReader();
        properties = new Properties();
        properties = reader.readConfigFile();
        URL = properties.getProperty("BaseURL");
        loginLinkLocator = By.linkText("Login");
        searchFieldLocator = By.name("search");
        searchButtonLocator = By
                .xpath("//form//button[@class='btn btn-outline-light text-white  btn-sm']");
        navbarDropdownLocator = By.cssSelector("a#navbarDropdown");
        navbarLocator = By.id("navbarSupportedContent");
        logoutLocator = By.xpath("//a[@href='" + properties.getProperty("LogoutURL") + "']");;
        emailInputLocator = By.id("email");
        passwordInputLocator = By.id("password");
        loginButtonLocator = By.xpath("//button[normalize-space()=\"Login\"]");
        bodyLocator = By.tagName("body");
        librarianActionsLocator = By.linkText("Librarian Actions");
        // Add new Book locators
        addBookLocator = By.xpath("//a[@href='" + properties.getProperty("AddBookURL") + "']");
        genresDropdownLocator = By.id("dropdownMenuButton1");
        genreCheckBoxLocator = By.id("flexCheckDefault1");
        bookSubmitButtonLocator = By.id("submit-button");
        // Add new Genre locators
        addGenreLocator = By.xpath("//a[@href='" + properties.getProperty("AddGenreURL") + "']");
        genresubmitButtonLocator = By.xpath("//*[text()='Submit']");
        selectLocator = By.name("style");
        primaryOptionLocator = By.xpath("//option[@value='primary']");

        // Typing
        typingBaseURL = properties.getProperty("TypingBaseURL");
        displayLocator = By.xpath("//div[@id='display']");
        wpmLocator = By.id("big-wpm");

    }

    public final String URL;
    public final String typingBaseURL;
    public By loginLinkLocator;
    public By searchFieldLocator;
    public By searchButtonLocator;
    public By navbarDropdownLocator;
    public By navbarLocator;
    public By logoutLocator;
    public By emailInputLocator;
    public By passwordInputLocator;
    public By loginButtonLocator;
    public By bodyLocator;
    public By librarianActionsLocator;
    // Add new Book locators
    public By addBookLocator;
    public By genresDropdownLocator;
    public By genreCheckBoxLocator;
    public By bookSubmitButtonLocator;
    // Add new Genre locators
    public By addGenreLocator;
    public By genresubmitButtonLocator;
    public By selectLocator;
    public By primaryOptionLocator;

    // Typing locators
    public By displayLocator;
    public By wpmLocator;
}