package assignments;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ParaBankMethods {
	
	WebDriver driver = null;
	propertyFileMethods prop = new propertyFileMethods();
	CommonMethods comm = new CommonMethods();
	ParabankPage page = new ParabankPage();
	
	String newAccountNumber = "";
	String firstAccount = "";
	String UserName = "";
	
	@BeforeSuite 
	public void setup() throws Throwable{
		UserName = prop.readProp("userName") + comm.randomNumber();
		System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.readProp("url"));
		Driver.setWebDriver(driver);
//		Thread.sleep(3000);
		comm.maximize();
	}
	
	
	@Test(priority=1)
	public void signin(){
		comm.click(page.RegisterLink);
		comm.waitVisible(page.UserName);
//		screenshot
		comm.setText(page.FirstName, prop.readProp("FirstName"));
		comm.setText(page.LastName, prop.readProp("LastName"));
		comm.setText(page.Address, prop.readProp("Address"));
		comm.setText(page.City, prop.readProp("City"));
		comm.setText(page.State, prop.readProp("State"));
		comm.setText(page.Zip, prop.readProp("Zip"));
		comm.setText(page.Phone, prop.readProp("Phone"));
		comm.setText(page.SSN, prop.readProp("SSN"));
		comm.setText(page.UserName, UserName);
		comm.setText(page.Password, prop.readProp("password"));
		comm.setText(page.ConfirmPassword, prop.readProp("password"));
//		screenshot
		comm.click(page.RegisterButton);
		comm.waitVisible(page.CreationSuccess);
//		screenshot
		comm.click(page.LogoutLink);
		comm.waitVisible(page.UserNameTextBox);
//		screenshot
	}
	
	
	//Login
	@Test(priority=2)
	public void login(){
		
		comm.setText(page.UserNameTextBox, UserName);
		comm.setText(page.PasswordTextBox, prop.readProp("password"));
//		screenshot
		comm.click(page.LogInButton);
		comm.waitVisible(page.LogoutLink);
//		screenshot
		
		comm.click(page.AccountsOverviewLink);
		comm.waitVisible(page.AccountTableRows);
		firstAccount = comm.getText(page.getAccNumber(1));
		System.out.println("firstAccount - " + firstAccount);
//		screenshot
	}
	
	
	//Account creation
	@Test(priority=3)
	public void createAccount(){
		comm.click(page.OpenAccountLink);
		comm.waitVisible(page.AccountTypeDropDown);
		comm.select(page.AccountTypeDropDown, prop.readProp("accType"));
		comm.select(page.FromAccountDropDown, firstAccount);
//		screenshot
		comm.click(page.OpenNewAccountButton);
		comm.waitVisible(page.AccountNumberLabel);
		newAccountNumber = comm.getText(page.AccountNumberLabel);
//		screenshot
		comm.click(page.AccountsOverviewLink);
		comm.waitVisible(page.AccountTableRows);
//		screenshot
	}
	
	
	//Transfer
	@Test(priority=4)
	public void transferFunds() throws Throwable{
		comm.click(page.TransferFundsLink);
		comm.waitVisible(page.ToAccountDropDown);
		Thread.sleep(3000);
		comm.setText(page.AmountTextBox, "100");
		comm.select(page.ToAccountDropDown, firstAccount);
		comm.select(page.FromAccountDropDown, newAccountNumber);
//		screenshot
		comm.click(page.TransferButton);
		comm.waitVisible(page.TransferCompleteLabel);
//		screenshot
	}
	
	
	//view txn
	@Test(priority=5)
	public void viewAccount() {
		comm.click(page.AccountsOverviewLink);
		comm.waitVisible(page.AccountTableRows);
		List<WebElement> eles = comm.findElements(page.AccountTableRows);
		for (int i = 1; i<=eles.size(); i++) {
			if (comm.getText(page.getAccNumber(i)).contentEquals(newAccountNumber)){
				String accBal = comm.getText(page.getAccBalance(i));
				System.out.println(accBal);
//				screenshots
			}
		}

		//logout
		comm.click(page.LogoutLink);
		comm.waitVisible(page.LogInButton);
//		screenshot
	}
	
	
	@AfterSuite
	public void exit() {
		comm.closeBrowser();
	}
	
	
}
