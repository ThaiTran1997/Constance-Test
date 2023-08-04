import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testLogin {
    WebDriver driver;
    @BeforeTest
    public WebDriver setUp(){
        // Replace 'path_to_chromedriver' with the actual path to your chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    @Test
    public void testLogin() {
        // Open the web application login page
        driver.get("https://constance-staging-appserver.nextwaytech.vn/admin/login");
        // Find the username and password input fields by their IDs and enter valid credentials
        driver.findElement(By.id("username")).sendKeys("wangconstance@gmail.com");
        driver.findElement(By.id("password")).sendKeys("!Q2w3e4r5t6y");

        // Click on the login button
        driver.findElement(By.className("login")).click();
        Assert.assertTrue(driver.getTitle().contains("Users"));
    }
    @AfterTest
    public void tearDown() {
        // Close the browser window when the test is finished
        driver.quit();
    }
}
