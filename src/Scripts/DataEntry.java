package Scripts;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import Pages.SamplePage;
import Support_functions.functions_support;

public class DataEntry  {
	
	String Firstname = "Rob";
	String Lastname = "Martin";
	String Email = "Rob.Martin@otp.com";
	WebDriver driver;
	functions_support fs = new functions_support();
	Properties prop = new Properties();
	
	
	

	void Append_data(){
		Firstname = fs.Addtext(Firstname, 5);
		Lastname = fs.Addtext(Lastname, 5);
		Email = Firstname + '.'+Lastname +"@mail.com";
	}
	void reset_data(){
		Firstname = "Rob";
		Lastname = "Martin";
		
	}
	
	@Before
	public void Browser_open() throws FileNotFoundException{
		
		fs.loadfile(prop);
		fs.Browser_check(driver, prop);
		System.out.println("URL: " + prop.getProperty("URL"));
		// Getting to the URL : file:///D:/Selenium-Java/Selenium_SamplePJT/Sampleform.html
		driver = fs.Browser_check(driver,prop);
		//driver.get("file:///D:/Selenium-Java/Selenium_SamplePJT/Sampleform.html");
		driver.get(prop.getProperty("URL"));
		// Maximizing the Browser window
		driver.manage().window().maximize();
		// Providing timeouts for each Statement
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("Completing Before----");
	}
	
	@Test
	public void EnterDatas() throws Exception {
		SamplePage Sample_Page_1 = new SamplePage();
		SamplePage Sample_Page_2 = new SamplePage();
		Append_data();
		Sample_Page_1.Setdata(driver,Firstname,Lastname,Email);
		Sample_Page_1.reset();
		reset_data();
		Append_data();
		//wait();
		Sample_Page_2.Setdata(driver,Firstname,Lastname,Email);
		Sample_Page_2.reset();
		reset_data();
	}
	
	@After
	public void Browser_close(){
		System.out.println("Closing the browser");
		driver.close();
	}

}