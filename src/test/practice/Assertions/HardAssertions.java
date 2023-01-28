package Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	public void test1()
	{
		String s1 = "Hi";
		String s2 = "Hello";
		Assert.assertEquals(s1, s2);
		//below two lines are skipped in hard assert
		System.out.println(s1);
		System.out.println(s2);
	}
	
	@Test
	public void test2()
	{
		String s1 = "Hi";
		String s2 = "Hi";
		Assert.assertEquals(s1, s2);
		System.out.println(s1);
		System.out.println(s2);
	}
}
