package IRetryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;
@Listeners(genericLibraries.ListenersImplementation.class)
public class Test1 {

	public class Test2 extends BaseClass {

		@Test(retryAnalyzer = genericLibraries.RetryAnalyzerImplementation.class)
		public void test()
		{
			System.out.println("Test");
			Assert.fail();
		}
}
}
