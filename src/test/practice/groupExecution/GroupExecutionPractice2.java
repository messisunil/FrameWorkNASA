package groupExecution;

import org.testng.annotations.Test;

public class GroupExecutionPractice2 {

	@Test(groups = "smoke")
	public void test0OfP2()
	{
		System.out.println("smoke Testing p2");
	}
	
	@Test(groups = "Regression")
	public void test1OfP2()
	{
		System.out.println("sanity Testing p2");
	}
	
	@Test(groups = {"smoke","Regression"})
	public void test2OfP2()
	{
		System.out.println(" smoke and Regression testing p1");
	}
}
