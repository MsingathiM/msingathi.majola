package driverAssessment;

import com.aventstack.extentreports.Status;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverAutomation {

    // Instantiate a WebDriver class.
    public static WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;


    WebElement element;

    @AfterClass
    public static void closeBrowser(){
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }

    @BeforeClass
    public static void setUP(){
        System.setProperty("webdriver.chrome.driver", "/Users/admin/Downloads/chromedriver-2");
        //System.setProperty("webdriver.gecko.driver", "/Users/admin/Downloads/geckodriver");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Launch Website
        driver.navigate().to("https://www.ilabquality.com");
        driver.manage().window().maximize();
    }

    @Test
    public void jobApplication() throws InterruptedException {

         htmlReporter = new ExtentHtmlReporter("/Users/admin/Documents/Work/apitestcucumber/" +
                "src/test/java/ilabReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("iLabAssessment");


        // Find careers and click
        Thread.sleep(3000);
        WebElement careers = driver.findElement(By.xpath("/html/body/header/div/div/div[3]/nav/ul/li[4]/a"));
        careers.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked careers link");

        //Navigate to South Africa
        WebElement country = driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]" +
                "/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a"));
        country.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked South Africa on country link");


        // Click on first available job post
        WebElement job = driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]" +
                "/div/div/div/div/div/div[1]/div[1]/div[2]/div[1]/a"));
        job.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "selected first job post");


        //click to Apply
        WebElement apply = driver.findElement(By.xpath("/html/body/section[2]/div[2]" +
                "/div/div/div/div/div[2]/div[1]/a"));
        apply.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked the apply link");


        //Fill in form
        WebElement fullname = driver.findElement(By.id("applicant_name"));
        fullname.clear();
        fullname.sendKeys("John Doe");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "populated name field");


        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("automationAssessment@iLABQuality.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "populated email field");


        WebElement phone = driver.findElement(By.id("phone"));
        phone.clear();
        phone.sendKeys("083 568 7859");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "populated phone number field");


        WebElement message = driver.findElement(By.id("message"));
        message.clear();
        message.sendKeys("I think with an organisation like iLab, there is a lot of room to grow " +
                "and for me share what I have learnt, that for me is definitely the reason why I think it would be " +
                "a great opportunity for both sides.");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "populated message field");


        WebElement submit = driver.findElement(By.id("wpjb_submit"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked the submit button");


        //Validate Error message displayed after submitting without an upload
        WebElement error = driver.findElement(By.xpath("/html/body/section[2]/div[2]" +
                "/div/div/div/div/div[2]/div[1]/a"));
        Assert.assertEquals(true,error.isDisplayed());
        test.log(Status.PASS, "error message displayed");

        //writing to report
        extent.flush();

    }

}
