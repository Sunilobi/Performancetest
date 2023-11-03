package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceTest {
    private WebDriver driver;

    @BeforeTest
    public void loadHomePage() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void measureLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get("http://sunil-virtualbox:8050/webapp/");
        long endTime = System.currentTimeMillis();

        long loadTime = endTime - startTime;
        System.out.println("Page load time for the 1st time: " + loadTime + " milliseconds");

        // Assuming you want to set an expected load time
        int expectedTime = 200;
        
        if (loadTime <= expectedTime) {
            Assert.assertTrue(true);
        } else {
            System.out.println("Page load time not matched with expected time: " + loadTime + " milliseconds");
            Assert.fail("Page load time exceeded the expected time.");
        }
    }
}
