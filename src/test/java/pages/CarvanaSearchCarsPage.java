package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaSearchCarsPage {
    public CarvanaSearchCarsPage(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(css = "[data-test='HeaderFacets']>div>button")
    public List<WebElement> filterOptions;

    @FindBy (css = ".react-autosuggest__input")
    public WebElement searchBarInput;

    @FindBy (css = "[data-qa='go-button']")
    public WebElement goButton;
}
