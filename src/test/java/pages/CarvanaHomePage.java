package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(css = "[data-qa = 'logo-wrapper']")
    public WebElement carvanaLogo;

    @FindBy (css = "[data-qa*='navigation']>div>a")
    public List<WebElement> mainNavigationItems;

    @FindBy(css = "[data-cv-test = 'headerSignInLink']")
    public WebElement signInButton;

    @FindBy(id = "usernameField")
    public WebElement emailSignInInput;

    @FindBy(id = "passwordField")
    public WebElement passwordSignInInput;

    @FindBy(css = "[data-cv = 'sign-in-submit']")
    public WebElement modalSignInButton;

    @FindBy(css = "[data-qa='error-message-container']")
    public WebElement signInErrorMessage;

    @FindBy(css = "[data-cv-test='headerSearchLink']")
    public WebElement searchCarsButton;


}
