package Test_Junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;



public class JunitTest {
	WebDriver driver = new FirefoxDriver();
	//Methods
	@BeforeClass
	public static void Test_Login_Spdood(){
		System.out.println("Started Testing");
	}
	
	@Before
	public void Login_Credentials_Test(){
		driver.get("https://www.google.com");
		driver.findElement(By.xpath(".//*[@id='sb_ifc0']")).sendKeys("Selenium");
		
	}
	@Test
	public void Test_OS_Version() throws FindFailed, InterruptedException{
		Screen screen = new Screen();
		Pattern image = new Pattern("/home/amuthupa/Pictures/Selection_001.png");
		System.out.println("came to testos version");
//		driver.findElement(By.xpath(".//*[@id='gs_htif0']")).sendKeys("Selenium");
		screen.click(image);
		Thread.sleep(10);
	}
	@After
	public void Driver_Test(){
		driver.close();
	}
	@AfterClass
	public static void Test_Complete(){
		System.out.println("Completed Testing");
	}
}
