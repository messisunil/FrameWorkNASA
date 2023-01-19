package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consists of reusable java methods
 * @author sunil
 *
 */
public class JavaUtility {
	/**
	 * This method is used to get random numbers
	 * @param limit
	 * @return
	 */
	public int generateRandomNumber(int limit)
	{
		Random random = new Random();
		return random.nextInt(limit);
	}
	
	/**
	 * This method is used to get current date and time
	 * @return
	 */
	public String getCurrentTime()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_mm_yyyy_hh_mm_sss");
		return sdf.format(date);
	}
}

