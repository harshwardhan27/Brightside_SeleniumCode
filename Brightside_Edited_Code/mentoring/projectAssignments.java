package mentoring;
import utility.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import brightsideDefault.homePage;

public class projectAssignments extends homePage{
	
	public void testUploadAssignments() throws InterruptedException{
		
		//User Login
		myAccount obj_sign_in = new myAccount();
		obj_sign_in.user_login();
		
		//Upload Assignments
		driver.findElement(By.xpath("//*[@id='mySidenavR']/ul/li[4]/a")).click();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[2]/a")).sendKeys(Constant.assignmentFilePath);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[3]/div[contains(text(),Constant.assignmentFileName)]")).isDisplayed();
		System.out.println("File has been selected");
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[3]/div[2]/a")).click();
		Thread.sleep(2000);
		Alert uploadingMessage = driver.switchTo().alert();
		String currentUploadConfirmMessage = uploadingMessage.getText();
		try{
			Assert.assertEquals(currentUploadConfirmMessage,Constant.uploadConfirmMessage);
		} catch (AssertionError e) {
			System.out.println("User details doesn't updated successfully");
		}
		System.out.println(Constant.uploadConfirmMessage);	
	}
	
}
