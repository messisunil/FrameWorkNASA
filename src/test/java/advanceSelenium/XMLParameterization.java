package advanceSelenium;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class XMLParameterization {

	@Test
	public static void m1(XmlTest xml)
	{
		System.out.println("Hi, how are you");
		System.out.println(xml.getParameter("url"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));
		System.out.println(xml.getAllParameters());
	}
}
