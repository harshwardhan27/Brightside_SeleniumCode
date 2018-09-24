package org.brightside.selenium;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class firstClass{
	WebDriver driver;
	String baseURL = "http://dev.angular.brightsidementoring.tudip.uk";
	String signUpURL = "http://dev.angular.brightsidementoring.tudip.uk/sign-up?project_code";
	String feedsURL = "http://dev.angular.brightsidementoring.tudip.uk/feeds";
	String projectCode = "HCLOHR";
	String newfirstName = "Allen";
	String newlastName = "Hauna";
	String newEmailId = "allen.hauna+amy@tudip.com";
	String newPassword = "tudip123";
	String newPostCode = "AB99AB";
	String newDate = "27";
	String newMonth = "October";
	String newYear = "1994";
	
	public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get(baseURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void user_login() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			System.out.println("User logged in successfully");
			Thread.sleep(3000);
			driver.get(baseURL + "/signout");
			System.out.println("User Successfuly logged out from their profile");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sign_up() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[1]/input")).sendKeys(projectCode);
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[2]/input")).click();
			Thread.sleep(3000);
			String currentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentURL,signUpURL + "=" + projectCode);
			System.out.println("URL Matched");
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[1]/input")).sendKeys(newfirstName);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys(newlastName);	
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[2]/div/input")).sendKeys(newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[3]/div/input")).sendKeys(newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[1]/input")).sendKeys(newPostCode);
			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[1]/select"))).selectByVisibleText(newDate);
			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[2]/select"))).selectByVisibleText(newMonth);
			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[3]/select"))).selectByVisibleText(newYear);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[5]/input")).click();
			Thread.sleep(5000);
			String currentFeedsURL = driver.getCurrentUrl();
			if (currentFeedsURL.equalsIgnoreCase(feedsURL)) {
					System.out.println("User Profile Created Successfully");
					driver.get(baseURL + "/signout");
		      }else {
		         System.out.print("User Profile cannot be created");
		      }
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public void forgot_password(){
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[4]/div/span/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/new/div/div/div/div/form/div/div[1]/div/input")).sendKeys(newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/new/div/div/div/div/form/div/div[2]/input")).click();
			System.out.println("Reset email has been sent to your email Id");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		firstClass myObj = new firstClass();
		myObj.invokeBrowser();
		myObj.sign_up();
		myObj.user_login();
		myObj.forgot_password();
	}
}
