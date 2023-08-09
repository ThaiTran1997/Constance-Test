import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class testQuestion {
    WebDriver driver;

   /* @BeforeTest
    public void setUp() {
        // Replace 'path_to_chromedriver' with the actual path to your chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }*/

   /* @Test
    public void testLogin() {
        testLogin Login = new testLogin();
        Login.testLogin();
// Open the web application login page
      /*  driver.get("https://constance-staging-appserver.nextwaytech.vn/admin/login");
        // Find the username and password input fields by their IDs and enter valid credentials
        driver.findElement(By.id("username")).sendKeys("wangconstance@gmail.com");
        driver.findElement(By.id("password")).sendKeys("!Q2w3e4r5t6y");

        // Click on the login button
        driver.findElement(By.className("login")).click();
        Assert.assertTrue(driver.getTitle().contains("Users"));
    }*/

    @Test
    public void testCreateQuestion() {
        testLogin Login = new testLogin();
        driver=Login.setUp();
        Login.testLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='menu']/li[5]"))).click();
        // Create textbox question
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdownMenuLink\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/form/div[2]/div/ul/li[3]/a"))).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/a[2]")).click();
        String errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]"))).getText();
        Assert.assertTrue(errorMessage.contains("Invalid data name"));
        driver.findElement(By.id("question_name")).sendKeys("Test Selenium Question");
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/a[2]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("All Questions"));
        // Create checkbox question
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"dropdownMenuLink\"]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/form/div[2]/div/ul/li[1]/a"))).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/div/div[3]/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/div/div[1]/div[1]/input")).sendKeys("Answer 1");
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/div/div[2]/div[1]/input")).sendKeys("Answer 2");
        driver.findElement(By.id("question_name")).sendKeys("Test Selenium Checkbox Question");
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[4]/a[2]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("All Questions"));

    }
    @Test(dependsOnMethods = "testCreateQuestion" )
    public void editQuestion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[5]/div/button/i")));
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[5]/div/ul/li[1]/a"))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"question_name\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"question_name\"]")).sendKeys("Question test after updating");
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[4]/a[2]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[1]")).getText().contains("Question test after updating"));
    }
    @Test(dependsOnMethods = "editQuestion" )
    public void deleteQuestion(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[5]/div/button/i")));
        element.click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[5]/div/ul/li[2]/a")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[1]")).getText().contains("Question test after updating"));
    }

    @AfterTest
    public void tearDown() {
        // Close the browser window when the test is finished
        driver.quit();
    }

}
