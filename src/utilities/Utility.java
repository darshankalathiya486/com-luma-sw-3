package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * All Utility Method
 */

public class Utility extends BaseTest {

    // 1 Method click method
    public void clickMethod(By by){
        driver.findElement(by).click();
    }

    // 2 Method select value without select options
    public void selectByValueFromDropdown(By by,String value){
        WebElement dropDown = driver.findElement(by);
        // Create the object of select class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    // 3 Method Get text
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    // 4 method Action method
    public void mouseHoverToBuild(By by){
        Actions actions= new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    // 5 method send text
    public void sendTextToElement(By by , String text){
        driver.findElement(by).sendKeys(text);
    }

    // 6 clear input element in field
    public void clearInput(By by){
        driver.findElement(by).clear();
    }

    //7
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
}
