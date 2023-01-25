package Vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class DataProviderPractice {
	@Test(dataProvider="Phone")
	public void addProductToCart(String phone,int price,String model)
	{
	System.out.println(phone+" "+price+" "+model);
	}
	
	@DataProvider(name="Phone")
	public Object[][] getData()
	{
		Object[][] data=new Object[2][3];
		data[0][0]="Samsung";
		data[0][1]=12000;
		data[0][2]="S12";
		
		data[1][0]="Apple";
		data[1][1]=15000;
		data[1][2]="A22";
		return data;
		
	}

}
