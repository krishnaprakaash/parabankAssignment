package assignments;

import org.openqa.selenium.By;

public class ParabankPage {

	private static final ParabankPage objLocator = new ParabankPage();
	
	public static ParabankPage  GetLocator() 
	{
		return objLocator;
	}
	 

//	Login Page
	By UserNameTextBox = By.xpath("//input[@name='username']");
	By PasswordTextBox = By.xpath("//input[@name='password']");
	By LogInButton = By.xpath("//input[@value='Log In']");
	By RegisterLink = getByText("Register");
	
//	Register
	By FirstName = getById("customer.firstName");
	By LastName = getById("customer.lastName");
	By Address = getById("customer.address.street");
	By City = getById("customer.address.city");
	By State = getById("customer.address.state");
	By Zip = getById("customer.address.zipCode");
	By Phone = getById("customer.phoneNumber");
	By SSN = getById("customer.ssn");
	By UserName = getById("customer.username");
	By Password = getById("customer.password");
	By ConfirmPassword = getById("repeatedPassword");
	By RegisterButton = By.xpath("//input[@value='Register']");
	By CreationSuccess = getByText("Your account was created successfully. You are now logged in.");
	
//	Menu Navigation Links
	By OpenAccountLink = getByText("Open New Account");
	By AccountsOverviewLink = getByText("Accounts Overview");
	By TransferFundsLink = getByText("Transfer Funds");
	By LogoutLink = getByText("Log Out");
	By FindTransactionsLink = getByText("Find Transactions");
	
//	CreateAccount Page
	By AccountTypeDropDown = getById("type");
	By OpenNewAccountButton = By.xpath("//input[@value='Open New Account']");
	By AccountNumberLabel = By.xpath("//b[text()='Your new account number:']/following-sibling::a");
	
//	Transfer Page
	By AmountTextBox = getById("amount"); 
	By FromAccountDropDown = getById("fromAccountId");
	By ToAccountDropDown = getById("toAccountId");
	By TransferButton = By.xpath("//input[@value='Transfer']");
	By TransferCompleteLabel = getByText("Transfer Complete!");
	
//	Acccounts Overview Page
	By AccountTableRows = By.xpath("//table[@id='accountTable']/tbody/tr");
	
	
	
	
	
	public By getByText(String text) {
		return By.xpath(String.format("//*[text()='%s']", text));
	}

	public By getById(String text) {
		return By.xpath(String.format("//*[@id='%s']", text));
	}

	public By getAccNumber(Integer i) {
		return By.xpath(String.format("//table[@id='accountTable']/tbody/tr[%d]/td[1]", i));
	}
	
	public By getAccBalance(Integer i) {
		return By.xpath(String.format("//table[@id='accountTable']/tbody/tr[%d]/td[2]", i));
	}
	
	
	
}
