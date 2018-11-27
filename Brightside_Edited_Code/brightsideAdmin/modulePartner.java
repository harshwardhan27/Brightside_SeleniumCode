package brightsideAdmin;
import org.openqa.selenium.*;
import org.testng.Assert;
import utility.Constant;
import utility.webDriverInstance;

public class modulePartner extends webDriverInstance{
	
	//Method: Create Partner
	public void create_partner() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
		Thread.sleep(3000);
		//Redirection to Admin Dashboard
		driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[5]/a")).click();
		Thread.sleep(5000);
		String curentAdminURL = driver.getCurrentUrl();
		Assert.assertEquals(curentAdminURL,Constant.adminURL, "Admin URL doesn't matched");
		System.out.println("Admin URL matched");
		
		//Redirection to Partner module
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[1]/a")).click();
		Thread.sleep(3000);
		String curentPartnerURL = driver.getCurrentUrl();
		Assert.assertEquals(curentPartnerURL,Constant.partnerURL, "Partner URL doesn't matched");
		System.out.println("Partner URL matched");
		
		//Create Partner
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[1]/div[1]/input")).sendKeys(Constant.newPartnerName);
		driver.findElement(By.xpath("")).sendKeys(Constant.newPartnerDomain);
		driver.findElement(By.xpath("")).sendKeys(Constant.newPartnerCommunityDomain);
		driver.findElement(By.xpath("")).sendKeys(Constant.newPartnerTagline);
		driver.findElement(By.xpath("")).sendKeys(Constant.newPartnerInvitationName);
		driver.findElement(By.xpath("")).sendKeys(Constant.newAboutPartner);
		driver.findElement(By.xpath("")).sendKeys(Constant.newPartnerPrimaryColor);
		driver.findElement(By.xpath("")).sendKeys(Constant.newPartnerSecondaryColor);
		driver.findElement(By.xpath("")).sendKeys(Constant.logoFilePath);
		driver.findElement(By.xpath("")).sendKeys(Constant.backgroundImageFilePath);
		
		//To enable Assignments
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[1]")).click();
		//To enable Activities
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[2]")).click();
		//To enable External Material
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[3]")).click();
		//To enable Surveys
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[4]")).click();
		//To enable Coordinator moderation 
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[5]")).click();
		//To enable Ask the Graduate
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[6]")).click();
		
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[4]/input")).click();
		
		//check partner title
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-partner-details/div/div[1]/div[2]/h4[contains(text()," + Constant.newPartnerName + ")]")).isDisplayed();
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-partner-details/div/div[1]/div[2]/div[contains(text()," + Constant.newPartnerTagline + ")]")).isDisplayed();
		System.out.println("Partner Created Successfully");
	}
}
