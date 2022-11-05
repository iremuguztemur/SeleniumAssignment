package org.example.pages;

import org.example.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;
import java.util.logging.Logger;

public class BasketPage {

    Methods methods;
    Logger logger;

    public BasketPage() {
        methods= new Methods();
    }

    public void goToBasket(){
        methods.click(By.id("cart")); //sepete git
        methods.assertCheck(By.id("cart"));
        methods.waitBySeconds(1);

        methods.click(By.id("js-cart")); //select yapısı tekrar sepete git
        methods.assertCheck(By.id("js-cart"));
        methods.waitBySeconds(3);
    }

    public void updateBasket(){

        String quantity = methods.getValue(By.xpath("//form[@class=\"js-cart-update-product\"]/input[@value]"));
        methods.waitBySeconds(3);

        int quantityNumber = Integer.parseInt(quantity);
        quantityNumber = quantityNumber + 1;
        methods.waitBySeconds(3);

        methods.clear(By.cssSelector(".js-cart-update-product>input"));
        methods.sendKeys(By.cssSelector(".js-cart-update-product>input"),String.valueOf(quantityNumber));
        methods.waitBySeconds(3);
        methods.findElement(By.cssSelector(".js-cart-update-product>input")).sendKeys(Keys.ENTER);
        methods.waitBySeconds(3);
        /*
        methods.findElement(By.cssSelector("[name='quantity']")).click();
        //methods.click(By.cssSelector("[name='quantity']")); //ürün adedi inputuna tıkla
        logger.info("urun adedi inputuna tıklandı");
        methods.assertCheck(By.cssSelector("[name='quantity']"));
        methods.waitBySeconds(3);

        methods.sendKeys(By.cssSelector("[name='quantity']"),Keys.CONTROL+"a"+Keys.DELETE);
        methods.assertCheck(By.cssSelector("[name='quantity']"));
        methods.waitBySeconds(3);

        methods.sendKeys(By.cssSelector("[name='quantity']"),"2"); //inputa yeni değer gir
        methods.waitBySeconds(3);

        methods.findElement(By.cssSelector(".js-cart-update-product>input")).sendKeys(Keys.ENTER);
        //methods.click(By.cssSelector(".fa-refresh")); //ürünü güncelle
        methods.waitBySeconds(3);


         */
    }
}
