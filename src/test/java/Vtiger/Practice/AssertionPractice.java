package Vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void assertTest1()
	{
		System.out.println("Step1");
		System.out.println("step2");
		System.out.println("Step3");
		Assert.assertEquals(true, false);
		System.out.println("Step4");
		System.out.println("Step5");

		System.out.println("Step6");

	}
	@Test
public void assertTest2()
{
	SoftAssert sa=new SoftAssert();
	System.out.println("Step1");
	System.out.println("step2");
	System.out.println("Step3");
	//sa.assertEquals(false, true);
	System.out.println("Step4");
	//Assert.assertTrue(false);
	System.out.println("Step5");

	System.out.println("Step6");
	sa.assertAll();

	
	
}
}
