package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Import ChromeOptions
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceTest {
    private WebDriver driver;

    @BeforeTest
    public void loadHomePage() {
        // Set up ChromeOptions for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        
        // Pass ChromeOptions to the ChromeDriver
        driver = new ChromeDriver(options);
    }

    @Test
    public void measureLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get("http://sunil-virtualbox:8050/webapp/");
        
        // Time to fully load the page
        long endTimeFullyLoaded = System.currentTimeMillis();
        long fullyLoadTime = endTimeFullyLoaded - startTime;
        
        // Simulate user interaction (e.g., click a button)
        WebElement submit = driver.findElement(By.xpath("/html/body/form/input[2]"));
        submit.click();
        
        // Time to interact
        long endTimeInteract = System.currentTimeMillis();
        long interactTime = endTimeInteract - startTime;

        // Print the metrics
        System.out.println("Page load time: " + fullyLoadTime + " milliseconds");
        System.out.println("Time to interact: " + interactTime + " milliseconds");
        System.out.println("Time to fully load: " + fullyLoadTime + " milliseconds");

        // Close the browser
        driver.quit();
    }
}
