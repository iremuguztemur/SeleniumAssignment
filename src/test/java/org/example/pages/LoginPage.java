package org.example.pages;

import org.example.methods.Methods;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage {

    Methods methods;

    public LoginPage(){
        methods=new Methods();
    }

    public void login(){
        methods.findElement(By.xpath("//div[@class=\"menu-top-button login\"]")).click();
        methods.waitBySeconds(5);
        methods.sendKeys(By.id("login-email"),"irem.uguztemur@testinium.com");
        methods.waitBySeconds(5);
        methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
        methods.waitBySeconds(5);
        methods.click(By.cssSelector(".ky-login-btn"));
        methods.waitBySeconds(5);
        Assert.assertTrue(methods.isElementVisible(By.cssSelector(".platinum"))); //login olmasi kontrolu
        methods.waitBySeconds(3);
    }
}
