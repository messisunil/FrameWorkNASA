package listenersImplementation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

@Listeners(genericLibraries.ListenersImplementation.class)
public class TestCase1 extends BaseClass {

	@Test
	public void test()
	{
		System.out.println("Test");
		//Assert.fail();
	}
}
