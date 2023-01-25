package Vtiger.Practice;

import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;

public class DemoTest2 extends BaseClass {
	@Test(groups="SmokeSuite")
	public void Demo1Test()
	{
		System.out.println("hello");
	}
	
	/*@Test(groups="SmokeSuite")
	public void dTest()
	{
		System.out.println("Demo2");
	}
	@Test(groups="SmokeSuite")
	public void demoTest2()
	{
		System.out.println("demoTest2");
	}
*/
}
