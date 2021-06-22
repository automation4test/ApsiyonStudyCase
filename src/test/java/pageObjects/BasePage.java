package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);

    }

    public void click (By elementBy) {
        //waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public boolean isElementPresent(By elementBy) {
        try {
            driver.findElement(elementBy);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void fillInputTextBox(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String getElementText(By by) {
        return driver.findElement(by).getText();
    }

    public String getDriverURL(){
        return driver.getCurrentUrl();
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public void clearTextField(By by) {
        driver.findElement(by).clear();
    }


}
