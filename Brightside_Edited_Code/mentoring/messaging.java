package mentoring;
import utility.Constant;
import brightsideDefault.homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


public class messaging extends homePage{
	  
	   @Test(priority=4)
	   public void mesaging() throws InterruptedException{
		try {
			driver.get(Constant.baseURL);
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/feeds/div/div[1]/div/div[1]/a")).click();
			Thread.sleep(3000);
			String mentoringURL = driver.getCurrentUrl();
			if (mentoringURL.equalsIgnoreCase(Constant.messagingURL)){
				System.out.println("Channels URL Matched");
				driver.findElement(By.linkText("Mentoring")).click();
				driver.findElement(By.id("chat__input")).sendKeys(Constant.testMessage);
				WebElement textbox = driver.findElement(By.id("chat__input"));
				textbox.sendKeys(Keys.SPACE);
				driver.findElement(By.id("chat__send-message")).click();
				if(driver.getPageSource().contains("Text Message")){
					System.out.println(Constant.testMessage + " " + "message is sent");
				} else{
					System.out.println(Constant.testMessage + " " + "message is not sent");
				    }
			} else {
			    System.out.print("Channels URL doesn't matched");
			    driver.get(Constant.baseURL + "/signout");
			 	}
		 } catch (Exception e) {
			e.printStackTrace();
			}
	  }	
	   
	  @AfterClass
	  public void quit() {
		driver.quit();
	  }
}
