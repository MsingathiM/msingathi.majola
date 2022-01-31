package mobile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Monefy {
    //public static WebDriver driver;
    @SuppressWarnings("rawtypes")
    public static AppiumDriver driver;
    String actionButton = "com.monefy.app.lite:id/keyboard_action_button";
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent = new ExtentReports();

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        //Set up desired capabilities and pass the Android app-activity and app-package to Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("deviceName", "Pixel 5 API 31");
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("noReset","true");
//        capabilities.setCapability("appPackage","com.monefy.activities.MainActivity_");
//        capabilities.setCapability("appActivity",".MainActivity_");
        capabilities.setCapability("app","/msingathi.majola/apps/com.monefy.app.lite_2021-12-17.apk");

        driver = new AppiumDriver (new URL("http://localhost:4723/wd/hub"), capabilities);


        //Generate Report
        htmlReporter = new ExtentHtmlReporter("/msingathi.majola/" +
                "src/test/java/Monefy.html");
        extent.attachReporter(htmlReporter);
        ExtentTest test = extent.createTest("Monefy");


    }

    @Test
    public void testIncome() throws Exception {

        //close popup on app start
        driver.findElement(By.id("com.monefy.app.lite:id/buttonClose")).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked popup close link button");


        //click income button
        driver.findElement(By.id("com.monefy.app.lite:id/income_button_title")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked income button");


        //Enter numeric value
        driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard5")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        for (int x = 0; x < 3; x++) {

            driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard0")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }

        test.log(Status.INFO, "entered numeric value");

        //clicking Add item button
        driver.findElement(By.id(actionButton)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "added item");


        //Navigate back after value entered
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked the back button");

        //writing reporting data to report
        extent.flush();



    }

    //Entering irregular spending like entertainment, taxi, etc
    @Test
    public void testSpending() throws Exception {

        //click Enter Entertainment
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/" +
                "androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/" +
                "androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.view.ViewGroup/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView[1]")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked entertainment link button");


        //Enter numeric value
        driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard2")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        for(int x = 0; x < 2; x++){

            driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard0")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        }

        test.log(Status.INFO, "entered numeric value");


        //clicking Add item button
        driver.findElement(By.id(actionButton)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked add item button");


        //Navigate back after value is entered
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked back button");
        extent.flush();



    }

    @Test
    public void testDeductions() throws Exception {

        //click subtract button
        driver.findElement(By.id("com.monefy.app.lite:id/expense_button")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked subtract button");


        //Enter numeric value
        driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard2")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        for (int x = 0; x < 3; x++) {

            driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard0")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }

        test.log(Status.INFO, "entered numeric value");

        //clicking Add item button
        driver.findElement(By.id(actionButton)).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked back button");


        //choose house category from list of options
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/" +
                "android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/" +
                "android.widget.GridView/android.widget.FrameLayout[10]/android.widget.LinearLayout/" +
                "android.widget.ImageView")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "selected house category from button list");


        //Navigate back after value entered
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked back button");
        extent.flush();



    }

    @Test
    public void testSpendingBalance() throws Exception {

        //click balance button
        driver.findElement(By.id("com.monefy.app.lite:id/balance_amount")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked Balance button");


        //Navigate back after value entered
        driver.findElement(By.id("com.monefy.app.lite:id/leftLinesImageView")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked back button");


        //View Spending By month, week, day etc

        //click accounts filter button
        driver.findElement(By.id("com.monefy.app.lite:id/leftLinesImageView")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked accounts filter button");


        //click accounts filter button
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation\"]")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        test.log(Status.INFO, "clicked back button button");
        extent.flush();

    }

    @AfterClass
    public static void teardown(){
        //close the app
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }
}
