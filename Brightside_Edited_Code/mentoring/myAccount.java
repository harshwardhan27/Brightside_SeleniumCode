package mentoring;
import utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class myAccount extends webDriverInstance{
	
	@Test(priority=5)
	private void myAccountAvatar() throws InterruptedException{
		try{
			//User login
			defaultLogin.user_login(constant.newEmailId, constant.newPassword);

			//Redirection to my account
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[2]/a")).click();
			Thread.sleep(3000);
			String currentAccountURL = driver.getCurrentUrl();
			Assert.assertEquals(currentAccountURL,constantURL.myAccountURL, "Already have an account URL doesn't matched");
			System.out.println("Already have an account URL matched");
			WebElement previousImg = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/div/div[2]/img"));
			String previousAvatar = previousImg.getAttribute("src");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/div/div[2]/span/i")).sendKeys(constant.imagefilePath);
			WebElement nextImg = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/div/div[2]/img"));
			String nextAvatar = nextImg.getAttribute("src");
			try{
				Assert.assertNotEquals(previousAvatar,nextAvatar);
			} catch (AssertionError e) {
				System.out.print("Image directly uploaded to their account");
			}
			System.out.println("Image has been sent to the moderation");
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[9]/a")).click();
		} catch (Exception e) {
			e.printStackTrace();
			}
	 }

	@Test(priority=6)
	private void myAccoutUpdateDetails() throws InterruptedException{
		try{
			//Step-1
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[1]/div/input")).clear();
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).isEnabled(), "First name field is cleared but update button remains enabled");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[1]/div/input")).sendKeys(constant.updateFirstName);
			
			//Step-2
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[2]/div/input")).clear();
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).isEnabled(), "Last name field is cleared but update button remains enabled");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[2]/div/input")).sendKeys(constant.updateLastName);
			
			//Step-3
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[3]/div/input")).clear();
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).isEnabled(), "Email Id is cleared but update button remains enabled");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[3]/div/input")).sendKeys(constant.updateEmailId);
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).isEnabled(), "User enters invalid email");
			
			//Step-4
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[4]/div/input")).clear();
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[4]/div/input")).sendKeys(constant.updatePhoneNumber);
			
			//Step-5
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[5]/div/input")).clear();
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).isEnabled(), "Post code field is cleared but update button remains enabled");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[5]/div/input")).sendKeys(constant.updatePostCode);
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).isEnabled(), "User enters invalid postcode");
			
			new Select(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[6]/div/select[1]"))).selectByVisibleText(constant.updateDate);
			new Select(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[6]/div/select[2]"))).selectByVisibleText(constant.updateMonth);
			new Select(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[6]/div/select[3]"))).selectByVisibleText(constant.updateYear);
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).click();
			Thread.sleep(2000);
			Alert confirmMessage = driver.switchTo().alert();
			String currentsuccessMessage = confirmMessage.getText();
			Assert.assertEquals(currentsuccessMessage,constant.successMessage, "User details doesn't updated successfully");
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[9]/a")).click();
		} catch (Exception e) {
			e.printStackTrace();
			}
	  }	
	
	@AfterMethod
	public void browserClose(){
		driver.close();
	}
}
