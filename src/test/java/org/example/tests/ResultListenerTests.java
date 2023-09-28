package org.example.tests;


import org.apache.log4j.Logger;
import org.example.utility.Browser;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.IOException;


public class ResultListenerTests implements ITestListener {
    private Logger log = Logger.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult result) {
        log.info("The test: "+result.getName()+"is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+" was "+(result.isSuccess()?"SUCCESS ":"FAILED "));
        log.info("Test success: "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test failure: "+result.getName());
        try {
            Browser.saveScreenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("Test skipped: "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
