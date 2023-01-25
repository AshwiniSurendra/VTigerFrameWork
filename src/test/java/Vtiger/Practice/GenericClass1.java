package Vtiger.Practice;

public class GenericClass1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//caller
		add(10,20);
		int c=add(20,30);
		System.out.println(c);
		int t= sub(50,30);
		System.out.println(t);
		int u=mul(2,5);
		System.out.println(u);

	}
	//called
	public static int add(int a,int b)
	{
		int c =a+b;
		return c;
	}
	public static int sub(int e,int f)
	{
		int g=e-f;
		return g;
	}
	public static int mul(int m,int n)
	{
		int o=m*n;
		return o;
	}
	

}
