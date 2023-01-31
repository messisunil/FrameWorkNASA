package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	@Test(dataProvider = "dataProvide")
	public void ticketBooking(String source , String destination)
	{
		System.out.println("source: "+source+"\t destination: "+destination);
	}
	@DataProvider
	public Object[][] dataProvide()
	{
		Object obj[][] = new Object[3][2];
		obj[0][0] = "Bangalore";
		obj[0][1] = "Mumbai";
		
		obj[1][0] = "Hydrabad";
		obj[1][1] = "Chennai";
		
		obj[2][0] = "Delhi";
		obj[2][1] = "Kolkata";
		
		return obj;
	}
}	
