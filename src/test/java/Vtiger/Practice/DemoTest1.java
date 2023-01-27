package Vtiger.Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
@Listeners(vTiger.GenericUtility.ListenersImplementationClass.class)
public class DemoTest1 extends BaseClass {
	@Test
	public void demoTest()
	{
		System.out.println("hai");
		Assert.fail();
	}

}
