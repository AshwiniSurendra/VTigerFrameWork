package vTiger.GenericUtility;

import java.io.IOException;

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
		String methodName=result.getMethod().getMethodName();
		System.out.println("----"+methodName+"--Execution Started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println("----"+methodName+"--Test Started");

		}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String methodName=result.getMethod().getMethodName();
		System.out.println("----"+methodName+"--Execution finished");
		System.out.println(result.getThrowable());
		
		String screenShotName=methodName+"-"+jutil.getSystemDateInFormat();
		try {
			wutil.takesScreenShot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println("----"+methodName+"--Execution Started");
		System.out.println(result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("------Suite Execution Started-----");

		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("------Suite Execution Finisheded-----");

		}
	

}
