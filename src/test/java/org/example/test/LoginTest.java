package org.example.test;

import org.example.driver.BaseTest;
import org.example.pages.LoginPage;
import org.junit.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage loginPage= new LoginPage();
        loginPage.login();
    }

}
