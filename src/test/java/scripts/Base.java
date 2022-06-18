package scripts;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Base {
    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchCarsPage carvanaSearchCarsPage;
    CarvanaMercedesBenzPage carvanaMercedesBenzPage;


    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaSearchCarsPage = new CarvanaSearchCarsPage(driver);
        carvanaMercedesBenzPage = new CarvanaMercedesBenzPage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
