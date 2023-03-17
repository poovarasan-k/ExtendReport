package seleniumTest;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class OpenGoogle {
 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//when set the env vareible on this project not use that->
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ExtentReports extentReports=new ExtentReports();
		 ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReports.html");
		// ExtentAventReporter avent = new ExtentAventReporter("target/avent.html");
		// ExtentEmailReporter email = new ExtentEmailReporter("target/email.html");
		// ExtentKlovReporter klov = new ExtentKlovReporter("MyProject")
		//ExtentHtmlReporter reporter=new ExtentHtmlReporter("report.html");
		 extentReports.attachReporter(htmlReporter);
		ExtentTest test=extentReports.createTest("open google test");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		//test.pass("Navigeted to google");
		
		String title=driver.getTitle();
		System.out.println(title);
		test.log(Status.INFO, "navigeted to "+title + "page");
		if(title.equals("Gogle")) {
			test.log(Status.PASS, "actual result is same, its pass");
		}else {
			test.log(Status.FAIL, "actual result is NOT same, its fail");
			TakesScreenshot screnshot=(TakesScreenshot)driver;
			File sourceFile=screnshot.getScreenshotAs(OutputType.FILE); //<FILE>
			File decignestion=new File("google.png");
			//FileHandler.copy(sourceFile,decignestion);
			org.openqa.selenium.io.FileHandler.copy(sourceFile, decignestion);
			test.addScreenCaptureFromPath("google.png");
			
		}
		driver.quit();
		extentReports.flush();	

	}
System.out.println("jenkin run to commit status");
}
