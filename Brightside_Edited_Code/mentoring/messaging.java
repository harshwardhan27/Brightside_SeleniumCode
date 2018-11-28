package mentoring;
import utility.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class messaging extends webDriverInstance{
	  
	   @Test(priority=4)
	   private void mesaging() throws InterruptedException{
		try {
			//User Login
			defaultLogin.user_login(Constant.newEmailId, Constant.newPassword);

			//Redirection to messaging
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/feeds/div/div[1]/div/div[1]/a")).click();
			Thread.sleep(3000);
			String mentoringURL = driver.getCurrentUrl();
			Assert.assertEquals(mentoringURL,Constant.messagingURL, "Channels URL doesn't matched");
			System.out.println("Channels URL matched");
			driver.findElement(By.id("chat__input")).sendKeys(Constant.testMessage);
			WebElement textbox = driver.findElement(By.id("chat__input"));
			textbox.sendKeys(Keys.SPACE);
			driver.findElement(By.id("chat__send-message")).click();
			if(driver.getPageSource().contains("Text Message")){
				System.out.println(Constant.testMessage + " " + "message is sent");
			} else{
				System.out.println(Constant.testMessage + " " + "message is not sent");
			    }
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


