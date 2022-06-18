package pages;

import org.apache.bcel.generic.LUSHR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaMercedesBenzPage {
    public CarvanaMercedesBenzPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-qa= 'result-tile'] picture")
    public List<WebElement> resultTilePictures;

    @FindBy(css = "[data-qa= 'result-tile'] svg")
    public List<WebElement> resultTileFavButton;

    @FindBy(css = "[data-qa='base-inventory-type']")
    public List<WebElement> resultTileInventoryType;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> resultTileYearMakeModel;

    @FindBy(css = ".trim-mileage")
    public List<WebElement> resultTileTrimMileage;

    @FindBy(css = ".price")
    public List<WebElement> resultTilePrice;

    @FindBy (css = ".monthly-payment")
    public List<WebElement> resultTileMonthlyPayment;

    @FindBy (css = ".down-payment")
    public List<WebElement> resultTileDownPayment;

    @FindBy (css = "[data-qa='delivery-chip']>span")
    public List<WebElement> resultTileShipping;



}
