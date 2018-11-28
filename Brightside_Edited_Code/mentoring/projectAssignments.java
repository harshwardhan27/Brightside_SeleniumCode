package mentoring;
import utility.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.LocalDateTime;  

public class projectAssignments extends webDriverInstance{
	
	@Test(priority=7)
	private void testUploadAssignments() throws InterruptedException{
		try{
			//User Login
			defaultLogin.user_login(constant.newEmailId, constant.newPassword);
			
			//Upload Assignments
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[2]/a")).click();
			Thread.sleep(3000);
			String currentAssignmentURL = driver.getCurrentUrl();
			Assert.assertEquals(currentAssignmentURL,constantURL.myAssignmentURL, "Assignments URL doesn't matched");
			System.out.println("Assignments URL matched");
			
			WebElement wb_assignments = driver.findElement(By.id("//*[@id='mySidenavR']/ul/li[4]/a"));
			wb_assignments.click();
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[2]/a")).sendKeys(constant.assignmentFilePath);
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[3]/div[contains(text()," + constant.assignmentFileName + ")]")).isDisplayed(), "File has not been selected");
			System.out.println("File has been selected");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[1]/div[3]/div[2]/a")).click();
			Thread.sleep(2000);
			Alert uploadingMessage = driver.switchTo().alert();
			String currentUploadConfirmMessage = uploadingMessage.getText();
			Assert.assertEquals(currentUploadConfirmMessage,constant.uploadConfirmMessage, "User details doesn't updated successfully");
			System.out.println(currentUploadConfirmMessage);
		 } catch (Exception e) {
				e.printStackTrace();
				}
	}	
	
	@Test(priority=8)
	private void checkUploadFileName() throws InterruptedException{
		try{
			//check uploaded date
			LocalDateTime now = LocalDateTime.now();
		    int year = now.getYear();
		    int month = now.getMonthValue();
		    int day = now.getDayOfMonth();
		    String currnetDate = month + day + ", " + year;
			Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[1]")).contains(currnetDate), "Date does not matched");		
			System.out.println("Date matched");
		    
		    //check uploaded file name
			Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).contains(constant.assignmentFileName), "File doesn't uploaded");
			System.out.println("File uploaded successfully");
			
			//check uploaded file download
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/assignments/div/div/div[2]/div/table/tbody/tr[2]/td[3]/a")).click();
			System.out.println("Uploaded file has been downloaded");
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