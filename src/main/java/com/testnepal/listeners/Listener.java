package com.testnepal.listeners;

import com.testnepal.reporter.ExtentManager;
import org.testng.*;


public class Listener implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentManager.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentManager.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createExtentTest(result.getMethod().getDescription(), "regression", "sadab", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.extentTest.pass(result.getMethod().getDescription() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.extentTest.fail(result.getMethod().getDescription() + " is failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.extentTest.skip(result.getMethod().getDescription() + " is skipped");
    }

}
