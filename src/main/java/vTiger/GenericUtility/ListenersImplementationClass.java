package vTiger.GenericUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/** this class provides implementation to all the methods in ITestListeners interface
 * 
 * @author soori
 *
 */
public class ListenersImplementationClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName;
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
			}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		}
	

}
