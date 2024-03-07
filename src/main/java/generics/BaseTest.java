package generics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite
	public void executionstart() {
	System.out.println("Execution Start");
	}

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.logfile", "./log_File/New.txt");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demo.actitime.com");

	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}

	@AfterMethod(alwaysRun = true)
	public void captureScreenshotOnFailure(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			TakesScreenshot ts = (TakesScreenshot) BaseTest.driver;
			File source_file = ts.getScreenshotAs(OutputType.FILE);

			String name = result.getName();

			Date today = Calendar.getInstance().getTime();
			String date = today.toString().replaceAll(":", "");
			System.out.println(today);

			// LocalTime l=LocalTime.now();

			File destfile = new File("./Screenshot/" + name + date + "failed" + ".png");

			try {
				FileUtils.copyFile(source_file, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
