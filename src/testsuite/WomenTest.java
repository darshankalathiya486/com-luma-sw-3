package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. verifyTheSortByProductNameFilter
 *      * Mouse Hover on Women Menu
 *      * Mouse Hover on Tops
 *      * Click on Jackets
 *      * Select Sort By filter “Product Name”
 *      * Verify the products name display in alphabetical order
 */

public class WomenTest extends Utility {

    // Declare baseUrl
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // open browser
    @Before
    public void setUP() {
        openBrowser(baseUrl);
    }

    @Test
    // Method name verifyTheSortByProductNameFilter
    public void verifyTheSortByProductNameFilter() throws InterruptedException{
        //Mouse Hover on Women Menu
        mouseHoverToBuild(By.xpath("//span[normalize-space()='Women']"));
        Thread.sleep(2000);

        // Mouse Hover on Tops
        mouseHoverToBuild(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        // Click on Jackets
        clickMethod(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Product Name”
        selectByValueFromDropdown(By.id("sorter"),"name");

        //Verify the products name display in alphabetical order
        List<WebElement> productElements = driver.findElements(By.cssSelector(".item.product.product-item"));
        List<String> productNames = new ArrayList<>();

        // Capture product names
        for (WebElement element : productElements) {
            WebElement productNameElement = element.findElement(By.cssSelector(".product-item-link"));
            productNames.add(productNameElement.getText());
        }

        // Check if product names are in alphabetical order
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames);
        Assert.assertEquals("Products are not arranged in alphabetical order.", productNames, sortedProductNames);

        // Sleep added for visualization, you might want to replace this with a wait strategy
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    //Method name verifyTheSortByPriceFilter
    public void verifyTheSortByPriceFilter () throws InterruptedException {

        //Mouse Hover on Women Menu
        mouseHoverToBuild(By.xpath("//span[normalize-space()='Women']"));
        Thread.sleep(2000);

        // Mouse Hover on Tops
        mouseHoverToBuild(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));

        // Click on Jackets
        clickMethod(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        //Select Sort By filter “Price”
        selectByValueFromDropdown(By.id("sorter"),"price");

        //Verify the products price display in Low to High
        List<WebElement> productElements = driver.findElements(By.cssSelector(".item.product.product-item"));
        List<Double> productPrices = new ArrayList<>();

        // Capture product prices
        for (WebElement element : productElements) {
            WebElement productPriceElement = element.findElement(By.cssSelector(".price"));
            String priceText = productPriceElement.getText().replaceAll("[^0-9.]", "");
            double price = Double.parseDouble(priceText);
            productPrices.add(price);
        }

        // Check if product prices are in ascending order
        List<Double> sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices);
        Assert.assertEquals("Products are not arranged in low to high price order.", productPrices, sortedProductPrices);

        // Sleep added for visualization, you might want to replace this with a wait strategy
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
