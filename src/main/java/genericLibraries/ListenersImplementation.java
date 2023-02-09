package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	 public ExtentReports report;
	 public ExtentTest test;
	 public static ExtentTest stest;
	 
	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		stest = test;
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(new WebDriverUtility().getScreenshot(BaseClass.sjavaUtil, result.getMethod().getMethodName(),BaseClass.sdriver ));
		test.addScreenCaptureFromBase64String(new WebDriverUtility().getScreenshot(BaseClass.sdriver));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName());
		test.fail(result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extent.html");
		spark.config().setDocumentTitle("FrameWork");
		spark.config().setReportName("V-Tiger");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Sunil");
		report.setSystemInfo("platform", "Windows");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
