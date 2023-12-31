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

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.time.Duration;
import java.lang.InterruptedException;
import  java.lang.IllegalArgumentException;

public class testQuestionnaire {
    WebDriver driver;
    @Test
    public void createQuestionnaire() {
        System.out.println("createQuestionnaire");
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
        }
        ;
        Assert.assertTrue(driver.getTitle().contains("All Questionnaire"));

        // Edit Questionnaire
        driver.findElement(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/button/i")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/ul/li[1]/a"))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;
        driver.findElement(By.xpath("//*[@id=\"question_name\"]")).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_name\"]"))).sendKeys("Questionnaire after updating");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/form/div[3]/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/form/div[3]/div/div[2]/div/div[1]/div[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_2\"]/div/div/div/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"question_2\"]/div/div/div[1]/ul/li[36]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/form/div[4]/a[2]"))).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(driver.getTitle().contains("All Questionnaire"));
    }
    // Search Questionnaire
    @Test
    public void searchQuestionnaire(){
        System.out.println("searchQuestionnaire");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String questionnaireName = driver.findElement(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[2]")).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input"))).sendKeys(questionnaireName);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[2]"))).getText().contains(questionnaireName));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div/div/input"))).clear();
    }
    // Assign Team
    @Test(dependsOnMethods = "createQuestionnaire")
    public void assignTeam(){
        System.out.println("assignTeam");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/ul/li[3]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mcssc_0\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mcssc_1\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]"))).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]"))).getText().contains("Assigned Successfully"));
    }
    // Unassign Team
    @Test(dependsOnMethods = "assignTeam")
    public void unassignTeam(){
        System.out.println("unassignTeam");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/ul/li[3]/a"))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mcssc_0\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mcssc_1\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]"))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]"))).getText().contains("Assigned Successfully"));
    }
    // Publish/Unpublish Questionnaire
    @Test(dependsOnMethods = "unassignTeam")
    public void publishQuestionnaire(){
        System.out.println("publishQuestionnaire");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/ul/li[2]/a"))).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]"))).getText().contains("Published Successfully"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/button/i"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/ul/li[2]/a"))).click();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]"))).getText().contains("Unpublished Successfully"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // Delete Questionnaire
    @Test(dependsOnMethods = "publishQuestionnaire")
    public void deleteQuestionnaire(){
        System.out.println("deleteQuestionnaire");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Delete Questionnaire which was assigned to teams
        assignTeam();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/ul/li[4]/a"))).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]"))).getText().contains("This questionnaire is assign to a team"));
        // Delete Questionnaire which wasn't assigned to any teams
        unassignTeam();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/button"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[6]/div/ul/li[4]/a"))).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[1]/div/div/div[2]"))).getText().contains("Questionnaire Deleted Successfully"));
    }
    @Test(priority = 6)
    public void filterStatus(){
        System.out.println("filterStatus");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/button[2]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div/ul[2]/li[1]/a"))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/table/tbody/tr[1]/td[4]/div"))).getText().contains("Published"));
    }
    @AfterTest
    public void tearDown() {
        // Close the browser window when the test is finished
        driver.quit();
    }
}
