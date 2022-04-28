package com.schrack.sfsAutomation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.schrack.sfsAutomation.annotations.LazyCompMobile;
import com.schrack.sfsAutomation.pages.PageManager;
import com.schrack.sfsAutomation.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
@LazyCompMobile
@SpringBootTest
public class BaseTest_Mobile extends BaseTest {
    public ExtentTest test;
    public ExtentReports extent;
    public ExtentSparkReporter spark;
    String slash = System.getProperty("file.separator");
    SoftAssert softAssert= new SoftAssert();
    
    @Value("${env}")
    public String env;
    
    @Autowired
    public ApplicationContext ctx;

    @Autowired
    public AppiumDriver<MobileElement> mDriver;

    @Autowired
    PageManager page;
    
    @Override
    @BeforeSuite
    protected void springTestContextPrepareTestInstance() throws Exception {
        // TODO Auto-generated method stub
        super.springTestContextPrepareTestInstance();
    }
    
    
    @Override
    @AfterSuite(alwaysRun = true)
    protected void springTestContextAfterTestClass() throws Exception {
        super.springTestContextAfterTestClass();
    }

    @BeforeTest
    public void setup() {
        Log.info("Value of Driver in setup:......" + mDriver);

    }
    
    
    /*
     * Extent Report Implementation
     * 
     */
    @BeforeSuite
    public ExtentReports getInstance() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(
                System.getProperty("user.dir") + slash + "test-output" + slash + "ExtentReport.html");
        extent.attachReporter(spark);
        return extent;
    }

    // ----- Method to start the reporting in a test case -----//
    public void startTest(String testcaseName) {
    //    test = getInstance().createTest(testcaseName);
        test = extent.createTest(env + " | " + testcaseName);
    }
    

    // ----- Method to capture a screenshot -----//
    public String getScreenShot(String fileName) throws IOException {
        String pathScreenShotsFolder = System.getProperty("user.dir");

        try {
            File scrFile = ((TakesScreenshot) mDriver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(pathScreenShotsFolder + slash + fileName + ".jpg"));
            fileName = pathScreenShotsFolder + slash + fileName + ".jpg";
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;

    }

    // ----- Method to log the results and screenshots in the report -----//
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.SUCCESS) {
            try {
                test.log(Status.PASS, result.getName() + " is Passed.");
            } catch (Exception e) {

            }
        } else if (result.getStatus() == ITestResult.FAILURE) {
            Log.info("result.getName() is: " + result.getName());
            try {
                test.log(Status.FAIL, result.getName() + " is Failed.");
                test.addScreenCaptureFromPath(getScreenShot(result.getName()));
            } catch (Exception e) {

            }
        }
    }

    public void log(String message) {
        test.log(Status.INFO, message);
        Log.info(message);
    }

    // ----- Method to close and flush the report -----//
    @AfterSuite
    public void endReport() {
        extent.flush();
        if (mDriver != null) {
            mDriver.quit();
        }
        Log.info("-------------..........Driver instance is killed .......------------------");
        // if (service.isRunning())
        // service.stop();
    }

}
