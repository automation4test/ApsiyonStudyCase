package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailPageObject extends BasePage{
    public ProductDetailPageObject(WebDriver driver) {
        super(driver);
    }
    String productTitle;
    int indexOfFavouriteElement;
    ArrayList<String> favouriteProductListText = new ArrayList<String>();

    By addList_btn = By.xpath("//input[@id='add-to-wishlist-button-submit']");
    By productTitle_label = By.xpath("//span[@id='productTitle']");
    By openFavourite_btn = By.linkText("Görüntüle: Liste");
    By favouriteProductList = By.xpath("//html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/ul[1]//span[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]/a[1]");
    By xyz = By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/ul[1]//span[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]");
    By removeButtonList = By.xpath("//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[7]/div[1]/div[1]/ul[1]//span[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/span[1]/span[1]/span[1]");


    public ProductDetailPageObject addProductToFavouriteList(){
        waitVisibility(addList_btn);
        productTitle = getElementText(productTitle_label);
        click(addList_btn);
        //click(closeFavouriteNotification_btn);
        return this;
    }

    public ProductDetailPageObject goToFavouriteList(){
        waitVisibility(openFavourite_btn);
        click(openFavourite_btn);
        return this;
    }

    public ProductDetailPageObject checkProductIsAddInTheFavouriteList() {
        for(int i= 0; i<findElements(favouriteProductList).size(); i++) {
            favouriteProductListText.add(findElements(favouriteProductList).get(i).getText());
        }
        Assert.assertTrue(favouriteProductListText.contains(productTitle), "Product is not in favourite list");
        indexOfFavouriteElement = favouriteProductListText.indexOf(productTitle);
        return this;
    }

    public ProductDetailPageObject removeProductInTheFavouriteList() {
        findElements(removeButtonList).get(indexOfFavouriteElement).click();
        return this;
    }

    public ProductDetailPageObject checkProductIsRemoveInTheFavouriteList() {
        driver.navigate().refresh();
        favouriteProductListText.clear();
        for(int i= 0; i<findElements(favouriteProductList).size(); i++) {
            favouriteProductListText.add(findElements(favouriteProductList).get(i).getText());
        }
        Assert.assertTrue(!favouriteProductListText.contains(productTitle), "Product still in favourite list");
        return this;
    }
}
