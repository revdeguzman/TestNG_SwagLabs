package base.files;

import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	Screenshot sshot = new Screenshot();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
        String passedFolder = System.getProperty("user.dir") + "\\Screenshots\\Passed";
        new File(passedFolder).mkdirs(); // Ensure the directory exists
        try {
            sshot.FullPageScreenShot(passedFolder);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
        String failedFolder = System.getProperty("user.dir") + "\\Screenshots\\Failed";
        new File(failedFolder).mkdirs(); // Ensure the directory exists
        try {
            sshot.FullPageScreenShot(failedFolder);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
