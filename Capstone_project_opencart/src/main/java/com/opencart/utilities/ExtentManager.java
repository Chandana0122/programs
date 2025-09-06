package com.opencart.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = PROJECT_PATH + "/Reports/ReportsOpencart.html"; // ✅ simplified path
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
}
