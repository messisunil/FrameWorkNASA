
package groupExecution;

import org.testng.annotations.Test;

public class GroupExecutionPractice1 {
	@Test(groups = "smoke")
	public void test0OfP1()
	{
		System.out.println("smoke Testing p1");
	}
	
	@Test(groups = "sanity")
	public void test1OfP1()
	{
		System.out.println("sanity Testing p1");
	}
	
	@Test(groups = {"smoke","sanity"})
	public void test2OfP1()
	{
		System.out.println(" smoke and sanity testing p1");
	}
}
