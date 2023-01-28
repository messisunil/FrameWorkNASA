package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAsserts {

	@Test
	public void test1()
	{
		String s1 = "Hi";
		String s2 = "Hello";
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(s1, s2);
		//below two lines are  not skipped in hard assert
		System.out.println(s1);
		System.out.println(s2);
		soft.assertAll();
	}
	
	@Test
	public void test2()
	{
		System.out.println("Hi");

	}
}
