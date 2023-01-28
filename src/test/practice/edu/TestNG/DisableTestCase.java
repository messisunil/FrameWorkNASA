package edu.TestNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DisableTestCase {

	//follows ASCII values
		@Test(priority = 'a', invocationCount = 2)
		public void test0()
		{
			Reporter.log("test0",true);
		}
		//This test case will be skipped from execution
		@Test(enabled = false)
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
