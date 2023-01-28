package edu.TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class CombinationOfPriorityNInvocation {
	//follows ASCII values
	@Test(priority = 'a', invocationCount = 2)
	public void test0()
	{
		Reporter.log("test0",true);
	}
	
	@Test(priority = 2)
	public void test1()
	{
		Reporter.log("test1",true);
	}
	//follows ASCII values
	@Test(priority = 'A', invocationCount = 3)
	public void test2()
	{
		Reporter.log("test2",true);
	}
	
}
