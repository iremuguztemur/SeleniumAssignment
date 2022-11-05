package org.example.pages;

import org.apache.logging.log4j.Logger;
import org.example.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FavouritePage {


    Methods methods;
    Logger logger;
    //Logger logger = LogManager.getLogger(FavouritePage.class);

    public FavouritePage(){

        methods = new Methods();
    }

    public void favoriteSelect(){

        methods.sendKeys(By.id("search-input"),"oyuncak");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(2);

        methods.click(By.xpath("(//a[@class='add-to-favorites'])[6]"));
        methods.click(By.xpath("(//a[@class='add-to-favorites'])[7]"));
        methods.click(By.xpath("(//a[@class='add-to-favorites'])[8]"));
        methods.click(By.xpath("(//a[@class='add-to-favorites'])[9]"));
        methods.waitBySeconds(2);
    }

    /*
    public void goFavoriteList(){

        methods.selectByText(By.cssSelector(".common-sprite"),"Favorilerim");
        methods.waitBySeconds(2);
    }

     */

    public void checkFavorites(){
        //methods.click(By.cssSelector(".my-list .common-sprite"));
        //methods.click(By.cssSelector(".my-list li li:nth-of-type(1) > a"));
        methods.assertCheck(By.cssSelector(".my-list .common-sprite"));
        methods.waitBySeconds(3);
    }


    public void goToFavorite(){
        methods.click(By.cssSelector(".my-list .common-sprite"));
        methods.click(By.cssSelector(".my-list li li:nth-of-type(1) > a"));
        methods.waitBySeconds(3);

    }

    public void removeThirdProduct(){
        methods.click(By.xpath("(//div[@class=\"hover-menu\"]//i[@class=\"fa fa-heart-o\"])[3]"));
        methods.waitBySeconds(3);
    }



}
