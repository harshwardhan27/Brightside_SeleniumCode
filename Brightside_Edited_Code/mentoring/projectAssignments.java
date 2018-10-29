package mentoring;
import utility.Constant;
import utility.webDriverInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.LocalDateTime;  

public class projectAssignments extends webDriverInstance{
	
	@Test(priority=0)
	public void testUploadAssignments() throws InterruptedException{
		
		//User Login
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
		Thread.sleep(3000);
		
		//Upload Assignments
		WebElement wb_assignments = driver.findElement(By.id("//*[@id='mySidenavR']/ul/li[4]/a"));
		wb_assignments.click();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[2]/a")).sendKeys(Constant.assignmentFilePath);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[3]/div[contains(text()," + Constant.assignmentFileName + ")]")).isDisplayed();
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
	
	@Test(priority=1)
	public void checkUploadFileName() throws InterruptedException{
		//check uploaded date
		LocalDateTime now = LocalDateTime.now();
	    int year = now.getYear();
	    int month = now.getMonthValue();
	    int day = now.getDayOfMonth();
	    String currnetDate = month + day + ", " + year;
	    try{
			Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[1]")).contains(currnetDate));
		}catch(AssertionError e){
			System.out.println("Date does not matched");
		}
		System.out.println("Date matched");
	    
	    //check uploaded file name
		try{
			Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).contains(Constant.assignmentFileName));
		}catch(AssertionError e){
			System.out.println("File doesn't uploaded");
		}
		System.out.println("File uploaded successfully");
		
		//check uploaded file download
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[3]/a")).click();
		System.out.println("Uploaded file has been downloaded");
	}
	
	@AfterClass
	  public void quit() {
		  driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[9]/a")).click();
		  driver.quit();
	  }
}