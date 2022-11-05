package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductPage {

    Methods methods;
    Logger logger;

    public ProductPage() {
        methods = new Methods();
        logger = LogManager.getLogger(ProductPage.class);
    }

    public void scrollAndClick(){

        methods.sendKeys(By.id("search-input"),"oyuncak");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".button-search"));
        methods.waitBySeconds(2);

        methods.scrollWithAction(By.xpath("(//div[@class=\"product-cr\"])[7]"));
        methods.assertCheck(By.xpath("//div[@class='product-list']//div[7]"));
        methods.waitBySeconds(2);
        String xpath1 = methods.getText(By.xpath("(//div[@class=\"product-cr\"])[6]"));
        methods.findElement(By.xpath("(//a[@class='add-to-favorites'])[6]")).click();
        methods.waitBySeconds(2);
        String xpath2 = methods.getText(By.xpath("(//div[@class=\"product-cr\"])[7]"));
        methods.findElement(By.xpath("(//a[@class='add-to-favorites'])[7]")).click();
        methods.waitBySeconds(2);
        String xpath3 = methods.getText(By.xpath("(//div[@class=\"product-cr\"])[8]"));
        methods.findElement(By.xpath("(//a[@class='add-to-favorites'])[8]")).click();
        methods.waitBySeconds(2);
        String xpath4 = methods.getText(By.xpath("(//div[@class=\"product-cr\"])[9]"));
        methods.findElement(By.xpath("(//a[@class='add-to-favorites'])[9]")).click();
        //methods.click(By.id("(//div[@class=\"product-cr\"]//a[@class=\"in-favorites\"])[${i}]"));
        methods.waitBySeconds(2);

        /*
        public void addToFavorites(){
        for (int i=6; i<=9; i++){
            methods.favoriteProducts(By.xpath("//i[@class='fa fa-heart']"), i);
            methods.waitBySeconds(3);
        }
    }
         */


        //methods.selectByText(By.cssSelector("select#review-sort-selection"),"Oylama (Düşük > Yüksek)");
        //methods.waitBySeconds(2);
    }


    public void scrollAndSelect() {

        methods.sendKeys(By.cssSelector("#search-input"), "edebiyat");
        methods.waitBySeconds(3);

        methods.click(By.cssSelector(".button-search"));
        methods.waitBySeconds(3);

        methods.click(By.cssSelector(".pr-img-link"));
        methods.waitBySeconds(3);

        methods.scrollWithAction(By.cssSelector(".review-panel.review-panel__show-all"));
        methods.waitBySeconds(3);

        logger.info("Scroll Edildi");
        methods.waitBySeconds(3);

        methods.selectByText(By.cssSelector("select#review-sort-selection"), "Eklenme Tarihi (Eski - Yeni)");
        methods.waitBySeconds(5);

    }

    public void randomElement() {
        methods.sendKeys(By.cssSelector("#search-input"), "edebiyat");
        methods.waitBySeconds(3);

        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(3);

        methods.randomElement(By.cssSelector(".pr-img-link")).click();
        methods.waitBySeconds(3);
    }

    public void attributeTest() {
        String attribute = methods.getAttribute(By.cssSelector(".logo-text>a>img"), "title");
        System.out.println("alinan text: " + attribute);
        logger.info("alinan text: " + attribute);
        methods.waitBySeconds(3);
    }

    public void textControl() {
        String text = methods.getText(By.cssSelector(".common-sprite"));
        System.out.println("alinan text: " + text);
        logger.info("alinan text: " + text);
        methods.waitBySeconds(3);
    }

    public void valueControl(){
        //methods.sendKeys(By.id("search-input"),"oyuncak");
        String value = methods.getValue(By.id("search-input"));
        System.out.println("alinan text: "+ value);
        logger.info("alinan text: "+ value);
        Assert.assertEquals("beklenen deger ayni degil","oyuncak", value);
        methods.waitBySeconds(5);
    }

    public void addToFavorites(){
        for (int i=6; i<=9; i++){
            methods.favoriteProducts(By.xpath("//i[@class='fa fa-heart']"), i);
            methods.waitBySeconds(3);
        }
    }
    public void checkFavorites(){
        methods.click(By.cssSelector(".my-list .common-sprite"));
        methods.click(By.cssSelector(".my-list li li:nth-of-type(1) > a"));
        methods.assertCheck(By.cssSelector(".my-list .common-sprite"));
        methods.waitBySeconds(3);
    }

    public void goToHome(){
        methods.click(By.xpath("//div[@class='logo-icon']"));
        Assert.assertTrue(methods.isElementVisible(By.xpath("//div[@class='logo-icon']"))); //site iconu
        //methods.click(By.xpath("//div[@class='menu-top-button login']")); //login butonu
        methods.waitBySeconds(1);
    }


}
