package pageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.ProductDetailPageObject;
import pageObjects.SearchProductPageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public LoginPageObject loginPageObject;
    public HomePageObject homePageObject;
    public SearchProductPageObject searchProductPageObject;
    public ProductDetailPageObject productDetailPageObject;
    Properties properties;
    FileInputStream fileInputStream;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void methodSetup() throws IOException {
        getReadPropFile();
        homePageObject = new HomePageObject(driver);
        loginPageObject = new LoginPageObject(driver);
        searchProductPageObject = new SearchProductPageObject(driver);
        productDetailPageObject = new ProductDetailPageObject(driver);
    }

    private void getReadPropFile() throws IOException {
        properties = new Properties();
        fileInputStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(fileInputStream);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
