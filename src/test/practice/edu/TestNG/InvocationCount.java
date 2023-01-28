package edu.TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount = 2)
	public void test0()
	{
		Reporter.log("test0",true);
	}
	
	@Test
	public void test1()
	{
		Reporter.log("test1",true);
	}
	
	@Test(invocationCount = 3)
	public void test2()
	{
		Reporter.log("test2",true);
	}
	//this test case is not executing
	@Test(invocationCount = -1)
	public void test3()
	{
		Reporter.log("test3",true);
	}
}
