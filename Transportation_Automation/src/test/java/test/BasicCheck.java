package test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;


public class BasicCheck {
	public static void main(String args[]) throws InterruptedException
	{
		String usernameXpath = "//input[@class='sc-fzoLsD fvOKch feui-input undefined ' and @type='email']";
		String passwordXpath = "//input[@class='sc-fzoLsD fvOKch feui-input undefined ' and @type='password']";
		String submitXpath   = "//div[@class='sc-AxhUy elBAex']";
		String sideBarXpath  = "//div[@class='sc-oTNDV esqaml']";
		String inPlantXpath  = "//*[text()='In Plant']";
		String homeXpath 	 = "//*[text()='Home']";
		
		/*System.setProperty("webdriver.gecko.driver", "D:\\000Git\\RestAssuredProject\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		*/
		/*System.setProperty("webdriver.ie.driver", "D:\\000Git\\RestAssuredProject\\drivers\\iedriver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();*/
		

		System.setProperty("webdriver.chrome.driver", "D:\\000Git\\RestAssuredProject\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ta-qa.fareye.co/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(usernameXpath)).sendKeys("transportationv2@fareye.co");
		driver.findElement(By.xpath(passwordXpath)).sendKeys("Fareye@123");
		driver.findElement(By.xpath(submitXpath)).click();
		

		WebElement element = driver.findElement(By.xpath(sideBarXpath));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		//element.click();

		Thread.sleep(10000);
		
		driver.close();
		
	}

}
