package org.example.tests;

import org.example.utility.Browser;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class ResultListenerTests implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName()+" was "+(result.isSuccess()?"SUCCESS ":"FAILED "));
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName()+" was "+(result.isSuccess()?"SUCCESS ":"FAILED "));
        try {
            Browser.saveScreenShot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
