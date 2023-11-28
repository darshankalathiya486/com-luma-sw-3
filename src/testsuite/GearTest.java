package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

/**
 * 1. userShouldAddProductSuccessFullyToShoppingCart()
 *      * Mouse Hover on Gear Menu
 *      * Click on Bags
 *      * Click on Product Name ‘Overnight Duffle’
 *      * Verify the text ‘Overnight Duffle’
 *      * Change Qty 3
 *      * Click on ‘Add to Cart’ Button.
 *      * Verify the text ‘You added Overnight Duffle to your shopping cart.’
 *      * Click on ‘shopping cart’ Link into message
 *      * Verify the product name ‘Cronus Yoga Pant’
 *      * Verify the Qty is ‘3’
 *      * Verify the product price ‘$135.00’
 *      * Change Qty to ‘5’
 *      * Click on ‘Update Shopping Cart’ button
 *      * Verify the product price ‘$225.00'
 */

public class GearTest extends Utility {

    // Declare baseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // open browser
    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }


    @Test
    // Method name userShouldAddProductSuccessFullyToShoppingCart

    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException{

        //Mouse Hover on Gear Menu
        mouseHoverToBuild(By.xpath("//span[normalize-space()='Gear']"));
        Thread.sleep(2000);

        //Click on Bags
        clickMethod(By.xpath("//span[normalize-space()='Bags']"));

        //Click on Product Name ‘Overnight Duffle’
        clickMethod(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //* Verify the text ‘Overnight Duffle’
        String aProduct = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        String eProduct = "Overnight Duffle";
        Assert.assertEquals(eProduct, aProduct);

        //Change Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextToElement(By.id("qty"), "3");
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String aMsg = getTextFromElement(By.xpath("//div[contains(text(),'Overnight')]"));
        String eMsg = "You added Overnight Duffle to your shopping cart.";
        Assert.assertEquals(eMsg, aMsg);
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //Verify the product name ‘Overnight Duffle’
        String eName = "Overnight Duffle";
        String aName = getTextFromElement(By.xpath("//a[text() = 'Overnight Duffle']"));
        Assert.assertEquals(eName, aName);

        //Verify the Qty is ‘3’
        WebElement Qty = driver.findElement(By.xpath("//input[@title = 'Qty']"));
        String aQty = Qty.getAttribute("value");
        String eQty = "3";
        Assert.assertEquals(eQty, aQty);

        // Verify the product price ‘$135.00’
        String aPrice = getTextFromElement(By.xpath("//span[contains(text(),'$135.00')]"));
        String ePrice = "$135.00";
        Assert.assertEquals(ePrice, aPrice);

        //Change Qty to ‘5’
        Qty.clear();
        Qty.sendKeys("5");
        clickOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));

        //Verify the product price ‘$225.00'
        String aTotal = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        String eTotal = "$225.00";
        Assert.assertEquals(eTotal, aTotal);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
