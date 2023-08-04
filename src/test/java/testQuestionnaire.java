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


public class testQuestionnaire {
    WebDriver driver;

    @Test
    public void createQuestionnaire(){
        testLogin Login = new testLogin();
        driver = Login.setUp();
        Login.testLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Create question without the name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-menu\"]/ul/li[4]/a/span"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/a/div"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/form/div[4]/a[2]"))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]")).getText().contains("name is required"));

        // Create English Questionnaire
        driver.findElement(By.xpath("//*[@id=\"question_name\"]")).sendKeys("English Questionnaire");
        driver.findElement(By.xpath("//*[@id=\"detail-card\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_1\"]/div/div[1]/div[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_1\"]/div/div/div[1]/ul/li[44]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_1\"]/div/a"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_1\"]/div/div[2]/div[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_1\"]/div/div[2]/div[1]/ul/li[33]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_1\"]/div/a"))).click();
        driver.findElement(By.xpath("//*[@id=\"question_1\"]/div/div[3]/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[3]/div/div[2]/div/div/div[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/form/div[4]/a[2]")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
        Assert.assertTrue(driver.getTitle().contains("All Questionnaire"));
    }
}
