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
	String signUpURL = "http://dev.angular.brightsidementoring.tudip.uk/sign-up?project_code=";
	String feedsURL = "http://dev.angular.brightsidementoring.tudip.uk/feeds";
	String existSignUp = "http://dev.angular.brightsidementoring.tudip.uk/sign-in?project_code=";
	String projectCode = "HCLOHR";
	String newfirstName = "Allen";
	String newlastName = "Hauna";
	String newEmailId = "chinux.hauna+chinux@tudip.com";
	String newPassword = "tudip123";
	String newPostCode = "AB99AB";
	String newDate = "27";
	String newMonth = "October";
	String newYear = "1994";
	
	public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HARSH\\workspace\\MySeleniumCode\\src\\org\\brightside\\chromedriver.exe");
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
			System.out.println("User successfuly logged out from their profile");
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
			if (currentURL.equalsIgnoreCase(signUpURL + projectCode)) {
				System.out.println("Sign up with project code URL matched");
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
						System.out.println(newfirstName + " " + "added successfully");
						driver.get(baseURL + "/signout");
			      }else {
			         System.out.print(newfirstName + " " + "cannot be added");
			         driver.quit();
			      	}
	         }else {
	            System.out.print("Sign up with project code URL doesn't matched");
	            driver.quit();
	         	}
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public void alreadyAccount() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[1]/input")).sendKeys(projectCode);
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[2]/input")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[1]/a")).click();
			Thread.sleep(3000);
			String currentExistSignUpURL = driver.getCurrentUrl();
			if (currentExistSignUpURL.equalsIgnoreCase(existSignUp + projectCode)) {
				System.out.println("Already have an account URL matched");
				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(newEmailId);
				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(newPassword);
				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
				Thread.sleep(5000);
				String currentExistFeedsURL = driver.getCurrentUrl();
				if (currentExistFeedsURL.equalsIgnoreCase(feedsURL)) {
						System.out.println(newfirstName + " " + "added successfully to project");
						driver.get(baseURL + "/signout");
			      }else {
			         System.out.print(newfirstName + " " + "cannot be added to project");
			         driver.quit();
			       }
			 }else {
				  System.out.print("Already have an account URL doesn't matched");
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
		myObj.alreadyAccount();
		myObj.forgot_password();
	}
}
