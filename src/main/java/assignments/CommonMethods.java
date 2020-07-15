package assignments;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	
	public void click(By by) {
		WebDriver driver = Driver.getWebDriver();
		WebElement ele = driver.findElement(by);
		try {
			ele.click();
		}catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
		} 
		slowDownExecution();
	}
	
	public void setText(By by, String text) {

		WebDriver driver = Driver.getWebDriver();
		waitVisible(by);
		WebElement ele = driver.findElement(by);
		try {
			ele.clear();
			ele.sendKeys(text);
		}catch(Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript(String.format("arguments[0].value='%s';",text), ele);
		}
		slowDownExecution();
		
	}

	public void maximize() {
		try {
			WebDriver driver = Driver.getWebDriver();
			driver.manage().window().maximize();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void waitVisible(By by) {
		try {
			WebDriver driver = Driver.getWebDriver();
			WebDriverWait wait = new WebDriverWait(driver,16);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void select(By by, String visible) {
		try {
			WebDriver driver = Driver.getWebDriver();
			Select obj = new Select(driver.findElement(by));
			obj.selectByVisibleText(visible);
			slowDownExecution();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void slowDownExecution() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void closeBrowser() {

		WebDriver driver = Driver.getWebDriver();
		driver.quit();
		
	}
	
	public boolean elementExists(By by) {
		try {
			waitVisible(by);
			WebDriver driver = Driver.getWebDriver();
			return driver.findElements(by).size() > 0;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<WebElement> findElements(By by) {
		try {
			WebDriver driver = Driver.getWebDriver();
			return driver.findElements(by);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getText(By by) {

		WebDriver driver = Driver.getWebDriver();
		WebElement elem = driver.findElement(by);
		return elem.getText();
		
	}
	
	public Integer randomNumber() {
		Random r = new Random();
		return r.nextInt(100);
		
		
	}
	
}

