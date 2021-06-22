package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageObject extends BasePage {
    public LoginPageObject(WebDriver driver) {
        super(driver);
    }

    By email_textbox = By.xpath("//input[@id='ap_email']");
    By continue_btn = By.xpath("//input[@id='continue']");
    By password_textbox = By.xpath("//input[@id='ap_password']");
    By signIn_btn = By.xpath("//input[@id='signInSubmit']");
    By login_page_Label = By.xpath("//h1[contains(text(),'Giriş yap')]");
    By userName_label = By.xpath("//span[@id='nav-link-accountList-nav-line-1']");

    public LoginPageObject checkLoginPageIsOpen() {
        Assert.assertTrue(isElementPresent(login_page_Label), "Login page did not display.");
        return this;
    }

    public LoginPageObject loginWithUserCredential(String uName, String pass) {
        clearTextField(email_textbox);
        fillInputTextBox(email_textbox,uName);
        click(continue_btn);
        clearTextField(password_textbox);
        fillInputTextBox(password_textbox, pass);
        click(signIn_btn);
        return this;
    }

    public LoginPageObject checkTheUserIsLogin() {
        Assert.assertTrue(!getElementText(userName_label).equals("Merhaba, Giriş yapın"), "The user is not login");
        return this;
    }

}
