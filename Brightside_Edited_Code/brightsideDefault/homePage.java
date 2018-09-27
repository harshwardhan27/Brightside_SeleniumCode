package brightsideDefault;
import utility.Constant;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class homePage {
  
	public WebDriver driver;
	  
	  @BeforeTest
	  public void invokeBrowser(){
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HARSH\\workspace\\MySeleniumCode\\src\\org\\brightside\\chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(Constant.baseURL);	
		} catch (Exception e) {
			e.printStackTrace();
		   }
	  }
	  
	  @Test(priority=0)
	  public void user_login() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			String currentFeedsURL = driver.getCurrentUrl();
			if (currentFeedsURL.equalsIgnoreCase(Constant.feedsURL)) {
				Assert.assertTrue(currentFeedsURL.equalsIgnoreCase(Constant.feedsURL));
				System.out.println("User logged in successfully");
				driver.get(Constant.baseURL + "/signout");
			} else {
				System.out.println("User not able to login");
//				driver.close();
			}
		} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  @Test(priority=0)
	  public void sign_up() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[1]/input")).sendKeys(Constant.projectCode);
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[2]/input")).click();
			Thread.sleep(3000);
			String currentURL = driver.getCurrentUrl();
			if (currentURL.equalsIgnoreCase(Constant.signUpURL + Constant.projectCode)) {
				System.out.println("Sign up with project code URL matched");
				driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[1]/input")).sendKeys(Constant.newfirstName);
				driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys(Constant.newlastName);	
				driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[2]/div/input")).sendKeys(Constant.newEmailId);
				driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[3]/div/input")).sendKeys(Constant.newPassword);
				driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[1]/input")).sendKeys(Constant.newPostCode);
				new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[1]/select"))).selectByVisibleText(Constant.newDate);
				new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[2]/select"))).selectByVisibleText(Constant.newMonth);
				new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[3]/select"))).selectByVisibleText(Constant.newYear);
				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[5]/input")).click();
				Thread.sleep(5000);
				String currentFeedsURL = driver.getCurrentUrl();
				if (currentFeedsURL.equalsIgnoreCase(Constant.feedsURL)) {
						System.out.println(Constant.newfirstName + " " + "added successfully");
						driver.get(Constant.baseURL + "/signout");
			      }else {
			         System.out.print(Constant.newfirstName + " " + "cannot be added");
			         driver.close();
			      	}
		      }else {
		           System.out.print("Sign up with project code URL doesn't matched");
		           driver.close();
		   	}
		} catch (Exception e) {
			e.printStackTrace();
			}
	  }
	  
	  @Test(priority=2)
	  public void alreadyAccount() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[1]/input")).sendKeys(Constant.projectCode);
			driver.findElement(By.xpath("/html/body/app/main/project-code-sign-up/div/div/div/div/form/div[2]/input")).click();
			
			//Terms and Conditions
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[3]/a[1]")).click();
			Thread.sleep(3000);
			String termsURL = driver.getCurrentUrl();
			if (termsURL.equalsIgnoreCase(Constant.termsConditionURL)) {
				System.out.println("Terms and Condition page successfully opened");
				driver.navigate().back();
			} else{
				System.out.println("Terms and Condition page doesn't opened");
				driver.close();
			}
				
			//Privacy and Policy
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[3]/a[2]")).click();
			Thread.sleep(3000);
			String policyURL = driver.getCurrentUrl();
			if (policyURL.equalsIgnoreCase(Constant.privacyPolicyURL)) {
				System.out.println("Privacy policy page successfully opened");
				driver.navigate().back();
			} else{
				System.out.println("Privacy policy page doesn't opened");
				driver.close();
			}
			
			//Already have an account
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[1]/a")).click();
			Thread.sleep(3000);
			String currentExistSignUpURL = driver.getCurrentUrl();
			if (currentExistSignUpURL.equalsIgnoreCase(Constant.existSignUp + Constant.projectCode)) {
				System.out.println("Already have an account URL matched");
				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
				Thread.sleep(5000);
				String currentExistFeedsURL = driver.getCurrentUrl();
				if (currentExistFeedsURL.equalsIgnoreCase(Constant.feedsURL)) {
						System.out.println(Constant.newfirstName + " " + "added successfully to project");
						driver.get(Constant.baseURL + "/signout");
			      }else {
			         System.out.print(Constant.newfirstName + " " + "cannot be added to project");
			         driver.close();
			       }
			 }else {
				  System.out.print("Already have an account URL doesn't matched");
				  driver.close();
			 	}
		} catch (Exception e) {
			e.printStackTrace();
			}
	  }
	  
	  @Test(priority=3)
	  public void forgot_password(){
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[4]/div/span/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/new/div/div/div/div/form/div/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/new/div/div/div/div/form/div/div[2]/input")).click();
			System.out.println("Reset email has been sent to your email Id");
			driver.get(Constant.baseURL);
		} catch (Exception e) {
			e.printStackTrace();
		   }
	  }
	  
	  @AfterClass
	  public void quit() {
		driver.quit();
	  }
}
