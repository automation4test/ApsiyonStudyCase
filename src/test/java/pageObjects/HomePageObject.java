package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import utils.logs.Log;

public class HomePageObject extends BasePage {
    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    String pageTitle = "Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi";

    By page_login_btn = By.xpath("//a[@id='nav-link-accountList']");


    public HomePageObject openHomePage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPageObject openLoginPage() {
        click(page_login_btn);
        return new LoginPageObject(driver);
    }

    public HomePageObject checkHomePageIsOpen(String url) {
        Assert.assertTrue(driver.getTitle().equals(pageTitle), "Home Page title is not correct");
        getInfoMessage(url + " Anasayfa açıldı" );
        return this;
    }
}
