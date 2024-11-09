package jar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.CovidTrackingPage;

public class baseClass{
	public WebDriver driver;
    CovidTrackingPage covidTrackingPage;
	public ExtentReports extent;
	
    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
        driver.get("https://inerg-test.web.app/");
        covidTrackingPage = new CovidTrackingPage(driver);
    }

   

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
