package brightsideDefault;
import utility.Constant;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class homePage {
	
	public WebDriver driver;
	  
	  @SuppressWarnings("unused")
	  @BeforeClass
	  public void invokeBrowser(){
		try {
			if (Constant.driverName == "chromeDriver"){
				System.setProperty("webdriver.chrome.driver",Constant.driverPath);
				driver = new ChromeDriver();
			} else if (Constant.driverName == "IEDriverServer"){
				System.setProperty("webdriver.ie.driver",Constant.driverPath);
				driver = new InternetExplorerDriver();
			} else {
				driver = new FirefoxDriver();
			}
			//Default Properties
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(Constant.baseURL);	
		} catch (Exception e) {
			e.printStackTrace();
		   }
	  }
	  
	  @Test(priority=3)
	  public void user_login() throws InterruptedException{
		try {
			driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			String currentFeedsURL = driver.getCurrentUrl();
			try {
				Assert.assertEquals(currentFeedsURL,Constant.feedsURL);
			} catch (AssertionError e) {
			    System.out.println("URL does not matched");
			    throw e;
			}
			System.out.println("URL matched and User logged in successfully");
			driver.get(Constant.baseURL + "/signout");
//			if (currentFeedsURL.equalsIgnoreCase(Constant.feedsURL)) {
//			Assert.assertTrue(currentFeedsURL.equalsIgnoreCase(Constant.feedsURL));
//			System.out.println("User logged in successfully");
//			driver.get(Constant.baseURL + "/signout");
//		} else {
//			System.out.println("User not able to login");
//			}
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
			try {
				Assert.assertEquals(currentURL,Constant.signUpURL + Constant.projectCode);
			} catch (AssertionError e) {
			    System.out.println("Sign up with project code URL doesn't matched");
			    throw e;
			}
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
			try {
				Assert.assertEquals(currentFeedsURL,Constant.feedsURL);
			} catch (AssertionError e) {
				System.out.print(Constant.newfirstName + " " + "cannot be added");
			    throw e;
			}
			System.out.println(Constant.newfirstName + " " + "added successfully");
			driver.get(Constant.baseURL + "/signout");
//			if (currentURL.equalsIgnoreCase(Constant.signUpURL + Constant.projectCode)) {
//			System.out.println("Sign up with project code URL matched");
//			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[1]/input")).sendKeys(Constant.newfirstName);
//			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[1]/div[2]/input")).sendKeys(Constant.newlastName);	
//			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[2]/div/input")).sendKeys(Constant.newEmailId);
//			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[3]/div/input")).sendKeys(Constant.newPassword);
//			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[1]/input")).sendKeys(Constant.newPostCode);
//			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[1]/select"))).selectByVisibleText(Constant.newDate);
//			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[2]/select"))).selectByVisibleText(Constant.newMonth);
//			new Select(driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[4]/div[2]/div[3]/select"))).selectByVisibleText(Constant.newYear);
//			Thread.sleep(2000);
//			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/form/div/div[5]/input")).click();
//			Thread.sleep(5000);
//			String currentFeedsURL = driver.getCurrentUrl();
//			if (currentFeedsURL.equalsIgnoreCase(Constant.feedsURL)) {
//					System.out.println(Constant.newfirstName + " " + "added successfully");
//					driver.get(Constant.baseURL + "/signout");
//		      }else {
//		         System.out.print(Constant.newfirstName + " " + "cannot be added");
//		      	}
//	    }else {
//	           System.out.print("Sign up with project code URL doesn't matched");
//	   		}
		} catch (Exception e) {
			e.printStackTrace();
			}
	  }
	  
	  @Test(priority=1)
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
			}
			
			//Already have an account
			driver.findElement(By.xpath("/html/body/app/main/sign-up/div/div/div/div/p[1]/a")).click();
			Thread.sleep(3000);
			String currentExistSignUpURL = driver.getCurrentUrl();
			try {
				Assert.assertEquals(currentExistSignUpURL,Constant.existSignUpURL + Constant.projectCode);
			} catch (AssertionError e) {
				System.out.print("Already have an account URL doesn't matched");
			    throw e;
			}
			System.out.println("Already have an account URL matched");
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(5000);
			String currentExistFeedsURL = driver.getCurrentUrl();
			try {
				Assert.assertEquals(currentExistFeedsURL,Constant.feedsURL);
			} catch (AssertionError e) {
				System.out.print(Constant.newfirstName + " " + "cannot be added to project");
			    throw e;
			}
			System.out.println(Constant.newfirstName + " " + "added successfully to project");
			driver.get(Constant.baseURL + "/signout");
//			if (currentExistSignUpURL.equalsIgnoreCase(Constant.existSignUp + Constant.projectCode)) {
//				System.out.println("Already have an account URL matched");
//				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
//				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
//				driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
//				Thread.sleep(5000);
//				String currentExistFeedsURL = driver.getCurrentUrl();
//				if (currentExistFeedsURL.equalsIgnoreCase(Constant.feedsURL)) {
//						System.out.println(Constant.newfirstName + " " + "added successfully to project");
//						driver.get(Constant.baseURL + "/signout");
//			      }else {
//			         System.out.print(Constant.newfirstName + " " + "cannot be added to project");
//			       }
//			 }else {
//				  System.out.print("Already have an account URL doesn't matched");
//			 	}
		} catch (Exception e) {
			e.printStackTrace();
			}
	  }
	  
	  @Test(priority=2)
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
}
