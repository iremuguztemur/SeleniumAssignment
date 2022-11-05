package org.example.pages;

import org.example.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class BooksPage {
    Methods methods;
    public BooksPage(){
        methods = new Methods();
    }

    public void pointsCatalog(){
        methods.click(By.cssSelector(".common-sprite[href='puan-katalogu']"));
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(3);
    }

    public void selectTurkishClassics(){
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector(".sort > select"));
        methods.waitBySeconds(3);
        methods.selectByText(By.cssSelector(".sort > select"),"Yüksek Oylama");
        methods.waitBySeconds(3);
    }

    public void selectAllBooks(){ //Tüm kitapları seçme
        methods.click(By.cssSelector(".js-ajaxCt.js-bookCt>li:nth-of-type(3)"));//Tüm kitaplara git
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("[href='kategori/kitap-hobi/1_212.html']"));//Hobi alanını seç
        methods.waitBySeconds(3);
    }

    public void selectRandomBook(){
        methods.randomElement(By.cssSelector(".name.ellipsis")).click();
        methods.waitBySeconds(5);

        methods.click(By.cssSelector("#button-cart>span"));
        methods.waitBySeconds(5);
    }
}
