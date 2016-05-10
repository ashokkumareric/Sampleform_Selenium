package Support_functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class functions_support {

	public String Addtext(String Firstname,int range){
		String Str = Firstname;
		int r = range;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		String output;
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		for (int i = 0; i < r; i++) {
		    char c = chars[random.nextInt(chars.length)];
		    sb.append(c);
		}
		output = sb.toString();
		Str = Firstname+'_'+output;
		return Str;
	}
	
	public void loadfile(Properties prop) throws FileNotFoundException{
		File filepath = new File("/home/amuthupa/Eclipse_Workspace/Junit_Practice/src/Scripts/Configuration.properties");
		FileInputStream fp = new FileInputStream(filepath);
		try {
			prop.load(fp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public WebDriver Browser_check(WebDriver driver,Properties prop){
		System.out.println("Reached function: Browser_check--1");
		String driverPath;
		String Browser = prop.getProperty("Browser");
		System.out.println("Browser: "+Browser);
		
		if ( Browser.equals("firefox")){
			System.out.println("Reached function: Browser_check--2");
			// Initializing the driver for firefox Browser
			driver = new FirefoxDriver();
			//driver.get(prop.getProperty("URL"));
			System.out.println("Initialized Driver");
		}else if( Browser.equals("Chrome")){
			// Initializing the driver for Chrome Browser
			driverPath = "opt/google/chrome/google-chrome";
			//System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}else{
			driver = new FirefoxDriver();
		}
	
		return driver;
	}
}