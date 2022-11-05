package org.example.methods;

import org.example.driver.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver webDriver;
    FluentWait<WebDriver> wait;

    JavascriptExecutor jsDriver;

    public Methods() {

        webDriver = BaseTest.driver;
        wait = new FluentWait<>(webDriver);
        jsDriver = (JavascriptExecutor) webDriver;

        wait.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
    }


    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by){
        return findElements(by);
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void sendKeys(By by, String text) {

        findElement(by).sendKeys(text);
    }

    public boolean isElementVisible(By by) {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void scrollWithAction(By by){

        Actions actions = new Actions(webDriver);
        actions.moveToElement(findElement(by)).build().perform();

    }
    /*
    public void hoverWithAction(By by){

        Actions actions = new Actions(webDriver);
        WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Music')]"));
        //Mouse hover menuOption 'Music'
        actions.moveToElement(menuOption).perform();

    }

     */

    public void scrollWithJavaScript(By by){

        jsDriver.executeScript("arguments[0].scrollIntoView();",findElement(by));
    }

    public Select getSelect(By by){

        return new Select(findElement(by));
    }

    public void selectByText(By by, String text){
        getSelect(by).selectByVisibleText(text);
    }

    public int randomNumber(int number){
        Random random = new Random();
        return random.nextInt(number);

    }

    public String randomBook(String book){
        Random random = new Random();
        return book;
    }

    public WebElement randomElement(By by){
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return elementList.get(randomNumber(elementList.size()));
    }

    public String getAttribute(By by, String attributeName){
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by){
        return findElement(by).getText();
    }

    public String getValue(By by){
        return jsDriver.executeScript("return arguments[0].value"
                ,findElement(by)).toString();
    }



    public void assertCheck(By by){
       // WebElement web = driver.findElement(by);
        WebElement web = findElement(by);
        boolean bool = web.isDisplayed();
        Assert.assertEquals(true, bool);

    }

    public void favoriteProducts(By by, int index){
        findElements(by).get(index).click();
    }

    public void cleanField(By by) {
        findElement(by).sendKeys(Keys.CONTROL+"a");
        findElement(by).sendKeys(Keys.DELETE);
    }

    public void clear(By by){
        findElement(by).clear();
    }
}
