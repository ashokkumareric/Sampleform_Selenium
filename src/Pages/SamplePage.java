package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class SamplePage {

	WebDriver driver;
	
	By Firstname = By.xpath("//input[@name='first_name']");
	By Lastname = By.xpath("//input[@name='last_name']");
	By EmailID = By.xpath("//input[@name='email']");
	By GenderMale = By.xpath("//input[@name='gender' and @value='male']");
	By GenderFemale = By.xpath("//input[@name='gender' and @value='female']");
	By Status_Single = By.xpath("//input[@name='Status' and @value='Single']");
	By Status_Married = By.xpath("//input[@name='Status' and @value='Married']");
	By SuperHero = By.xpath("//tr/td/select");
	By Tele_Number = By.xpath("//input[@name='telephone']");
	By Comments = By.xpath("//textarea[@name='comments']");
	By  Reset_AllFields = By.xpath("//input[@value='Reset']");
	
	// Set first name and last name
	void Setdata_name(String Firstname,String Lastname){
		
		// Clear the fields
		driver.findElement(this.Firstname).clear();
		driver.findElement(this.Lastname).clear();
		
		// Entering the data in the fields
		driver.findElement(this.Firstname).sendKeys(Firstname);
		driver.findElement(this.Lastname).sendKeys(Lastname);
		
	}
	
	// Set Email ID
	void Setdata_Email(String Email){
		
		// Clear the fields
		driver.findElement(this.EmailID).clear();
		
		// Entering the data in the fields
		driver.findElement(EmailID).sendKeys(Email);
		
	}
	
	void Setdata_Gender_Male(){
		
		// Verify whether "Male" is selected, if it is not selected, then we select
		// 'Male' as Gender
		if (driver.findElement(GenderMale).isSelected()){
			System.out.println("Male is selected prior");
		}else{
			driver.findElement(GenderMale).click();
		}
				
	}
	
	void Setdata_Gender_Female(){
		
		// Verify whether "Female" is selected, if it is not selected, then we select
		// 'female' as Gender
		if (driver.findElement(GenderFemale).isSelected()){
			System.out.println("Female is selected prior");
		}else{
			driver.findElement(GenderFemale).click();
		}
				
	}
	
	void Setdata_MaraitalStatus_Single(){
		
		// Verify whether "Single" is selected, if it is not selected, then we select 
		// "Single" as Marital Status
		if (driver.findElement(Status_Single).isSelected()){
			System.out.println("Single is selected prior");
		}else{
			driver.findElement(Status_Single).click();
		}
		
	}
	
	void Setdata_MaraitalStatus_Married(){
		
		// Verify whether "Married" is selected, if it is not selected, then we select 
		// "Married" as Marital Status
		if (driver.findElement(Status_Single).isSelected()){
			System.out.println("Single is selected prior");
		}else{
			driver.findElement(Status_Single).click();
		}
		
	}
	
	void Setdata_Superhero(){
		
		// Selecting  "Captain America"
		Select select = new Select(driver.findElement(SuperHero));
		select.selectByIndex(1);
	}
	void Setdata_Telephone(){
		
		// Clear the fields
				driver.findElement(Tele_Number).clear(); 
		// Enter Valid Telephone Number
		driver.findElement(Tele_Number).sendKeys("+919897969521");
		
	}
	
	void Setdata_Comments(){
		
		// Clear the fields
			driver.findElement(Comments).clear(); 
		// Enter Valid Telephone Number
			driver.findElement(Comments).sendKeys("Hello World");

	}
	
	public void Setdata(WebDriver driver,String Firstname,String Lastname, String Email){
		
		this.driver = driver;
		// Entering Valid data in the fields
		Setdata_name(Firstname,Lastname);
		Setdata_Email(Email);
		Setdata_Gender_Male();
		Setdata_MaraitalStatus_Single();
		Setdata_Superhero();
		Setdata_Telephone();
		Setdata_Comments();
				
	}
	
	public void reset(){
		
		// Resetting all the fields in the Form
		driver.findElement(Reset_AllFields).click();
	}
}