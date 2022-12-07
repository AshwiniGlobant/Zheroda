package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utility.ExtentReportGenerator;
import base.Screenshot;

public class MyListeners extends Screenshot implements ITestListener {
	ExtentReports report=ExtentReportGenerator.getExtentReport();
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		String testName=result.getName();
		test=report.createTest(testName);
		test.log(Status.INFO,testName+"has started execution");
		
	}

	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		test=report.createTest(testName);
		test.log(Status.PASS,testName+"has got succseefully done execution");
		
	}

	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		test=report.createTest(testName);
		test.log(Status.FAIL,testName+"has got failed execution");
		
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(takesScreenshot(testName,driver),testName);
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		report.flush();
	}

}
