package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Write the browser setup code inside the class
 */

public class BaseTest {
    //Declare browser
    static String browser = "Chrome";
    public static WebDriver driver;

    //Declare if else method with browser

    public void openBrowser(String baseUrl){
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser name");
        }

        // Get baseUrl
        driver.get(baseUrl);

        // Maximize the window with maximize method
        driver.manage().window().maximize();

        // Set duration time with timeout method
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    // close the browser
    public void closeBrowser(){
        driver.quit();
    }
}
