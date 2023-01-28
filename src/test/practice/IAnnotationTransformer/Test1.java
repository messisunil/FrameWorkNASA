package IAnnotationTransformer;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class Test1 extends BaseClass {
	@Test
	public void test1()
	{
		System.out.println("Test1");
		Assert.fail();
	}
}
