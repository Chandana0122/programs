package com.opencart.base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.opencart.utilities.ExtentManager;
import com.opencart.utilities.WaitUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    public void setup(Method method) {
        // Create new test entry in report
        test = extent.createTest(method.getName());
        System.out.println("🚀 Starting Test: " + method.getName());

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/index.php");

        WaitUtil.waitForPageLoad(driver, 20);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                test.pass("✅ Test Passed: " + result.getName());
            } else if (result.getStatus() == ITestResult.FAILURE) {
                test.fail("❌ Test Failed: " + result.getName());
                test.fail(result.getThrowable());
            } else if (result.getStatus() == ITestResult.SKIP) {
                test.skip("⚠️ Test Skipped: " + result.getName());
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @AfterSuite
    public void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
