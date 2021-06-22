package pageTests;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static utils.extentReport.ExtentTestManager.startTest;

public class ProductTest extends BaseTest{

    @Test(priority = 0, description = "open amazon.com.tr add product to favorite check and remove it.")
    public void searchProduct_addFavourite_removeFavourite_Test(Method method){
        startTest(method.getName(),"searchProduct_addFavourite_removeFavourite_Test");

        homePageObject
                .openHomePage(properties.getProperty("baseURL"))
                .checkHomePageIsOpen()
                .openLoginPage()
                .checkLoginPageIsOpen()
                .loginWithUserCredential(properties.getProperty("username"), properties.getProperty("password"))
                .checkTheUserIsLogin();

        searchProductPageObject
                .searchProduct("samsung")
                .checkSearchProductResult()
                .clickSecondPageButtonAndAssertPaginationNumber("2")
                .openProductDetail(3);

        productDetailPageObject
                .addProductToFavouriteList()
                .goToFavouriteList()
                .checkProductIsAddInTheFavouriteList()
                .removeProductInTheFavouriteList()
                .checkProductIsRemoveInTheFavouriteList();
    }

    /**
     * 1.  http://www.dolap.com sitesine gidecek ve anasayfasının açıldığı onaylayacak.
     *
     * 2.  Login ekranını açıp, bir kullanıcı ile login olacak.
     *
     * 3.  Ekranın üstündeki Search alanına 'samsung' yazıp Ara butonuna tıklayacak.
     *
     * 4.  Gelen sayfada samsung için sonuç bulunduğunu onaylayacak.
     *
     * 5.  Arama sonuçlarından 2. sayfaya tıklayacak ve açılan sayfada 2. sayfanın şu an gösterimde olduğunu onaylayacak.
     *
     * 6.  Üstten 3. ürünün içindeki 'favorilere ekle' butonuna tıklayacak.
     *
     * 7.  Ekranın en üstündeki 'favorilerim' linkine tıklayacak.
     *
     * 8.  Açılan sayfada bir önceki sayfada izlemeye alınmış ürünün bulunduğunu onaylayacak.
     *
     * 9.  Favorilere alınan bu ürünün yanındaki 'Kaldır' butonuna basarak, favorilerimden çıkaracak.
     *
     * 10. Sayfada bu ürünün artık favorilere alınmadığını onaylayacak.**/
}
