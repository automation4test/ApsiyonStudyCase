package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.logs.Log;

public class HomePageObject extends BasePage{
    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    String pageTitle = "Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi";

    /**By giris_uye_ol_btn = By.xpath( "//a[contains(text(),'GİRİŞ | ÜYE OL')]");
    By giris_yap_btn = By.linkText("Giriş yap");

    By search_textbox = By.id("search");**/


    By page_login_btn = By.xpath("//a[@id='nav-link-accountList']");
    By email_textbox = By.xpath("//input[@id='ap_email']");
    By continue_btn = By.xpath("//input[@id='continue']");
    By password_textbox = By.xpath("//input[@id='ap_password']");
    By signIn_btn = By.xpath("//input[@id='signInSubmit']");
    By search_prodcut_textbox = By.xpath("//input[@id='twotabsearchtextbox']");
    By search_product_btn = By.xpath("//input[@id='nav-search-submit-button']");


    public HomePageObject openHomePage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPageObject openLoginPage(){
        click(page_login_btn);
        return new LoginPageObject(driver);
    }

    public HomePageObject checkHomePageIsOpen(){
        Assert.assertTrue(driver.getTitle().equals(pageTitle), "Home Page title is not correct");
        Log.info("Home Page open");
        return this;
    }
}
