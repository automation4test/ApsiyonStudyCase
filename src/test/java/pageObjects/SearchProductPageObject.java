package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchProductPageObject extends BasePage {
    public SearchProductPageObject(WebDriver driver) {
        super(driver);
    }

    int product_count;

    By search_prodcut_textbox = By.xpath("//input[@id='twotabsearchtextbox']");
    By search_product_btn = By.xpath("//input[@id='nav-search-submit-button']");
    By product_list_items = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]//div/span/div/div/span/a/div/img");
    By next_page_btn = By.xpath("//a[contains(text(),'2')]");

    public SearchProductPageObject searchProduct(String prodcutName) {
        fillInputTextBox(search_prodcut_textbox, prodcutName);
        click(search_product_btn);
        return this;
    }

    public SearchProductPageObject checkSearchProductResult() {
        Assert.assertTrue(findElements(product_list_items).size() != 0, "Search result not found any element");
        return this;
    }

    public SearchProductPageObject clickSecondPageButtonAndAssertPaginationNumber(String page) {
        click(next_page_btn);
        Assert.assertTrue(getDriverURL().contains("page=" + page));
        return this;
    }

    public ProductDetailPageObject openProductDetail(int productOrder){
        waitVisibility(product_list_items);
        findElements(product_list_items).get((productOrder-1)).click();
        return new ProductDetailPageObject(driver);
    }
}
