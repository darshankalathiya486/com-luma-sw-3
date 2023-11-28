package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * 1. userShouldAddProductSuccessFullyTo ShoppinCart()
 *      * Mouse Hover on Men Menu
 *      * Mouse Hover on Bottoms
 *      * Click on Pants
 *      * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
 *      * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
 *      * Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
 *      * Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
 *      * Click on ‘shopping cart’ Link into message
 *      * Verify the text ‘Shopping Cart.’
 *      * Verify the product name ‘Cronus Yoga Pant’
 *      * Verify the product size ‘32’
 *      * Verify the product colour ‘Black’
 */

public class MenTest extends Utility {

    // Declare baseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // open browser
    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    //Method name userShouldAddProductSuccessFullyToShoppingCart
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        //Mouse Hover on Men Menu
        mouseHoverToBuild(By.xpath("//span[normalize-space()='Men']"));
        Thread.sleep(2000);

        //Mouse hover on Bottoms
        mouseHoverToBuild(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));

        //Click on Pants
        clickMethod(By.xpath("//a[@id='ui-id-23']"));

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToBuild(By.xpath("//div[@class='column main']//li[1]"));
        clickMethod(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-size-143-item-175']"));

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToBuild(By.xpath("//div[@class='column main']//li[1]"));
        clickMethod(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToBuild(By.xpath("//div[@class='column main']//li[1]"));
        clickMethod(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));

        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedText, actualText);

        //Click on ‘shopping cart’ Link into message
        clickMethod(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the text ‘Shopping Cart.’
        String aTitle = getTextFromElement(By.xpath("//h1[@class = 'page-title']"));
        String eTitle = "Shopping Cart";
        Assert.assertEquals(eTitle, aTitle);

        //Verify the product name ‘Cronus Yoga Pant’
        String aProduct = getTextFromElement(By.xpath("//a[text() = 'Cronus Yoga Pant ']"));
        String eProduct = "Cronus Yoga Pant";
        Assert.assertEquals(eProduct, aProduct);

        //Verify the product size ‘32’
        //Verify the product colour ‘Black’
        String aDetails = getTextFromElement(By.xpath("//dl[@class = 'item-options']"));
        String eDetails = "Size\n" + "32\n" + "Color\n" + "Black";
        Assert.assertEquals(eDetails, aDetails);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
