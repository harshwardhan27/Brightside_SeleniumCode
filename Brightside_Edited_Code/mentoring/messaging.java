package mentoring;
import brightsideDefault.homePage;
import utility.Constant;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class messaging extends homePage {
	
   @Test
   public void mesaging() throws InterruptedException{
	try {
		driver.get(Constant.baseURL);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
		Thread.sleep(3000);
		String mentoringURL = driver.getCurrentUrl();
		if (mentoringURL.equalsIgnoreCase(Constant.messagingURL)){
			System.out.println("Channels URL Matched");
			driver.findElement(By.linkText("Mentoring")).click();
			driver.findElement(By.linkText("Mentoring")).click();
			driver.findElement(By.id("chat__input")).sendKeys(Constant.testMessage);
			Thread.sleep(3000);
			driver.findElement(By.id("chat__send-message")).click();
			System.out.println(Constant.testMessage + " " + "message to be sent");		
		} else {
		    System.out.print("Channels URL doesn't matched");
		    driver.get(Constant.baseURL + "/signout");
		    driver.close();
		 	}
	 } catch (Exception e) {
		e.printStackTrace();
		}
   }	
}
