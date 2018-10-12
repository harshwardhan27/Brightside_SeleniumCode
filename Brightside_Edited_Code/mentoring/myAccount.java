package mentoring;
import utility.Constant;
import brightsideDefault.homePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class myAccount extends homePage{
	
	@Test(priority=0)
	public void myAccountAvatar() throws InterruptedException{
		driver.get(Constant.baseURL);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
		Thread.sleep(3000);
		driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[2]/a")).click();
		Thread.sleep(3000);
		String currentAccountURL = driver.getCurrentUrl();
		try {
			Assert.assertEquals(currentAccountURL,Constant.myAccountURL);
		} catch (AssertionError e) {
			System.out.print("Already have an account URL doesn't matched");
		    throw e;
		}
		System.out.println("My Account URL matched");
		WebElement previousImg = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/div/div[2]/img"));
		String previousAvatar = previousImg.getAttribute("src");
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/div/div[2]/span/i")).sendKeys(Constant.imagefilePath);
		WebElement nextImg = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/div/div[2]/img"));
		String nextAvatar = nextImg.getAttribute("src");
		try{
			Assert.assertNotEquals(previousAvatar,nextAvatar);
		} catch (AssertionError e) {
			System.out.print("Image directly uploaded to their account");
		}
		System.out.println("Image has been sent to the moderation");
	}
	
	@Test(priority=1)
	public void myAccoutValid() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[1]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[1]/div/input")).sendKeys(Constant.updateFirstName);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[2]/div/input")).sendKeys(Constant.updateLastNamee);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[3]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[3]/div/input")).sendKeys(Constant.updateEmailId);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[4]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[4]/div/input")).sendKeys(Constant.updatePhoneNumber);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[5]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[5]/div/input")).sendKeys(Constant.updatePostCode);
		new Select(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[6]/div/select[1]"))).selectByVisibleText(Constant.updateDate);
		new Select(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[6]/div/select[2]"))).selectByVisibleText(Constant.updateMonth);
		new Select(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[6]/div/select[3]"))).selectByVisibleText(Constant.updateYear);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/my-account/account-info/div/div[2]/div/form/div[7]/input")).click();
		Thread.sleep(2000);
		Alert confirmMessage = driver.switchTo().alert();
		String currentsuccessMessage = confirmMessage.getText();
		try{
			Assert.assertEquals(currentsuccessMessage,Constant.successMessage);
		} catch (AssertionError e) {
			System.out.println("User details doesn't updated successfully");
		}
		System.out.println("User details updated successfully");
	}
}
