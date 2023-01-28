package edu.GroupExecution;

import org.testng.annotations.Test;

public class GroupExecutionPractice3 {

	@Test(groups = "sanity")
	public void test0OfP3()
	{
		System.out.println("sanity Testing p3");
	}
	
	@Test(groups = "Regression")
	public void test1OfP2()
	{
		System.out.println("regression Testing p3");
	}
	
	@Test(groups = {"Regression","sanity"})
	public void test2OfP3()
	{
		System.out.println(" regression and sanity testing p3");
	}
	
	@Test
	public void test3OfP4()
	{
		System.out.println("normal testing");
	}
}
