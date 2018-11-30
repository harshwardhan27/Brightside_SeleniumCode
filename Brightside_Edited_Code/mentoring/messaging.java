package mentoring;
import utility.*;
import org.openqa.selenium.*;
import org.testng.annotations.*;

public class messaging extends webDriverInstance{
	  
	   @Test
	   private void mesaging() throws InterruptedException{
		try {
			//User Login
			defaultLogin.user_login(constant.newEmailId, constant.newPassword);

			//Redirection to messaging
			modulesNavigation.messaging_navigation();
			
			//Sending Messages
			driver.findElement(By.id("chat__input")).sendKeys(constant.testMessage);
			WebElement textbox = driver.findElement(By.id("chat__input"));
			textbox.sendKeys(Keys.SPACE);
			driver.findElement(By.id("chat__send-message")).click();
			if(driver.getPageSource().contains("Text Message")){
				System.out.println(constant.testMessage + " " + "message is sent");
			} else{
				System.out.println(constant.testMessage + " " + "message is not sent");
			    }
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[9]/a")).click();
		 } catch (Exception e) {
			e.printStackTrace();
			}
	  }	
	  
	  @AfterMethod
	  public void tearDown(){
		driver.close();
	  }
}


