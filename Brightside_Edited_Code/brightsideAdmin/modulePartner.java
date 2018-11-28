package brightsideAdmin;
import org.openqa.selenium.*;
import org.testng.Assert;
import utility.*;

public class modulePartner extends webDriverInstance{
	
	//Method 1: Create Partner
	public void create_partner() throws InterruptedException{
		
		//Coordinator Login
		defaultLogin.admin_login(Constant.newEmailId, Constant.newPassword);
		
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
		
		//Fill create partner fields
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
		
		//Click Submit
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[4]/input")).click();
		
		//check partner title
		Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-partner-details/div/div[1]/div[2]/h4[contains(text()," + Constant.newPartnerName + ")]")).isDisplayed(), "Partner Title doesn't matched");
		Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-partner-details/div/div[1]/div[2]/div[contains(text()," + Constant.newPartnerTagline + ")]")).isDisplayed(), "Partner Description doesn't matched");		
		Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/nav/ul/li[2]")).isDisplayed(), "Activites doesn't enabled");
		Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/nav/ul/li[3]")).isDisplayed(), "External Materials doesn't enabled");
		System.out.println("Partner created successfully");
	}
	
	//Method 2: Search Partner
	public void search_partner() throws InterruptedException {
		
		//Coordinator Login
		defaultSignIn.admin_login(Constant.newEmailId, Constant.newPassword);
		
		//Enter partner name in search field
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[2]/div[2]/input")).sendKeys(Constant.newPartnerName);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[2]/div[2]/i[1]")).click();
		
		//Check partner name in partner list
		Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[3]/div/table/tbody")).contains(Constant.newPartnerName), "Partner doesn't found");
		System.out.println("Partner name is present");
	
		//Navigate to edit partner page
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[3]/div/table/tbody/tr[2]/td[3]/a/i")).click();
		
	}
}
