package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.*;
import org.junit.Test;

public class GeneralTest extends BaseTest {

    @Test
    public void GeneralTest() {

        FavouritePage favouritePage = new FavouritePage();
        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        BooksPage booksPage = new BooksPage();
        BasketPage basketPage = new BasketPage();

        loginPage.login();
        productPage.scrollAndClick();
        productPage.valueControl();
        favouritePage.goToFavorite(); //*
        favouritePage.checkFavorites();
        productPage.goToHome();
        booksPage.pointsCatalog();
        booksPage.selectTurkishClassics();
        booksPage.selectAllBooks();
        booksPage.selectRandomBook();
        favouritePage.goToFavorite();
        favouritePage.removeThirdProduct();
        basketPage.goToBasket();
        basketPage.updateBasket();

    }
}
