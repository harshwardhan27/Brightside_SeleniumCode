package brightsideAdmin;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import utility.*;

public class modulePartner extends webDriverInstance{

	@Test
	//Method 1: Create Partner
	public void create_partner() throws InterruptedException{
		
		//Coordinator Login
		defaultLogin.admin_login(constant.newEmailId, constant.newPassword);
		
		//Redirection to Partner module
		modulesNavigation.partners_navigation();
		
		//Redirection to Create Partner page
		modulesNavigation.createPartners_navigation();
		
		//Fill create partner fields
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[1]/div[1]/input")).sendKeys(constant.newPartnerName);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[1]/div[2]/input")).sendKeys(constant.newPartnerDomain);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[1]/div[3]/input")).sendKeys(constant.newPartnerCommunityDomain);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[2]/textarea")).sendKeys(constant.newPartnerTagline);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[2]/div[1]/textarea")).sendKeys(constant.newPartnerInvitationName);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[2]/div[2]/textarea")).sendKeys(constant.newAboutPartner);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[1]/div[1]/input")).sendKeys(constant.newPartnerPrimaryColor);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[1]/div[2]/input")).sendKeys(constant.newPartnerSecondaryColor);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[1]/div[3]/div/span")).sendKeys(constant.logoFilePath);
		driver.findElement((By) By.xpath("//*[@id='upload-btn-2']/div/span")).sendKeys(constant.backgroundImageFilePath);
		
		//To enable Assignments
		if (constant.enableAssignments == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[1]")).click();
		}
		
		//To enable Activities
		if (constant.enableActivities == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[2]")).click();
		}
		
		//To enable External Material
		if (constant.enableExternalMaterial == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[3]")).click();
		}
		
		//To enable Surveys
		if (constant.enableSurveys == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[4]")).click();
		}
		
		//To enable Coordinator moderation 
		if (constant.enableCoordinatorModeration == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[5]")).click();
		}
		
		//To enable Ask the Graduate
		if (constant.enableAskTheGraduate == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[6]")).click();
		}
		
		//Click Submit
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[4]/input")).click();
		
		//check partner title
		Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-partner-details/div/div[1]/div[2]/h4[contains(text()," + constant.newPartnerName + ")]")).isDisplayed(), "Partner Title doesn't matched");
		Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-partner-details/div/div[1]/div[2]/div[contains(text()," + constant.newPartnerTagline + ")]")).isDisplayed(), "Partner Description doesn't matched");		
	
		if (constant.enableActivities == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/nav/ul/li[2]")).isDisplayed(), "Activites doesn't enabled");
		}
		
		if (constant.enableExternalMaterial == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/nav/ul/li[3]")).isDisplayed(), "External Materials doesn't enabled");
		}		
		System.out.println("Partner created successfully");
	}
	
	@Test
	//Method 2: Search Partner
	public void search_partner() throws InterruptedException {
		
		//Coordinator Login
		defaultLogin.admin_login(constant.newEmailId, constant.newPassword);
				
		//Redirection to Partner module
		modulesNavigation.partners_navigation();
		
		//Enter partner name in search field
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[2]/div[2]/input")).sendKeys(constant.newPartnerName);
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[2]/div[2]/i[1]")).click();
		
		//Check partner name in partner list
		Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[3]/div/table/tbody")).contains(constant.newPartnerName), "Partner doesn't found");
		System.out.println("Partner name is present");
	}

	@Test
	//Method 3: Edit Partner
	@SuppressWarnings("unused")
	public void edit_partner() throws InterruptedException {
		
		//To search partner
		search_partner();
		
		//Navigate to edit partner page
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[3]/div/table/tbody/tr[2]/td[3]/a/i")).click();
		
		//Check partner fields data
		String currentPartnerName = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[1]/div[1]/input")).getAttribute("value");
		Assert.assertEquals(currentPartnerName, constant.newPartnerName, "Partner name doesn't match");
		
		String currentPartnerDomain = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[1]/div[2]/input")).getAttribute("value");
		Assert.assertEquals(currentPartnerDomain, constant.newPartnerDomain, "Partner domain doesn't match");
		
		String currentPartnerCommunityDomain = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[1]/div[3]/input")).getAttribute("value");
		Assert.assertEquals(currentPartnerCommunityDomain, constant.newPartnerCommunityDomain, "Partner Community domain doesn't match");
		
		String currentPartnerTagline = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[1]/div[2]/textarea")).getAttribute("value");
		Assert.assertEquals(currentPartnerTagline, constant.newPartnerTagline, "Partner tagline doesn't match");
		
		String currentPartnerInvitationName = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[2]/div[1]/textarea")).getAttribute("value");
		Assert.assertEquals(currentPartnerInvitationName, constant.newPartnerInvitationName, "Partner Invitation name doesn't match");
		
		String currentAboutPartner = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[2]/div[2]/textarea")).getAttribute("value");
		Assert.assertEquals(currentAboutPartner, constant.newAboutPartner, "About Partner doesn't match");
		
		String currentPartnerPrimaryColor = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[1]/div[1]/input")).getAttribute("value");
		Assert.assertEquals(currentPartnerPrimaryColor, constant.newPartnerPrimaryColor, "Primary color doesn't match");
		
		String currentPartnerSecondaryColor = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[1]/div[2]/input")).getAttribute("value");
		Assert.assertEquals(currentPartnerSecondaryColor, constant.newPartnerSecondaryColor, "Secondary color doesn't match");
		
		//To check enabled features
		if (constant.enableAssignments == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[1]")).isSelected());
		} else{
			Assert.assertFalse(!driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[1]")).isSelected());
		}
		if (constant.enableActivities == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[2]")).isSelected());
		}else{
			Assert.assertFalse(!driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[2]")).isSelected());
		}
		if (constant.enableExternalMaterial == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[3]")).isSelected());
		}else{
			Assert.assertFalse(!driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[3]")).isSelected());
		}
		if (constant.enableSurveys == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[4]")).isSelected());
		}else{
			Assert.assertFalse(!driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[4]")).isSelected());
		}
		if (constant.enableCoordinatorModeration == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[5]")).isSelected());
		}else{
			Assert.assertFalse(!driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[5]")).isSelected());
		}
		if (constant.enableAskTheGraduate == true){
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[6]")).isSelected());
		}else{
			Assert.assertFalse(!driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[3]/div[2]/div[6]")).isSelected());
		}
		
		//Click Update button to update the partner details
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-edit-partner/div/form/div[4]/input")).click();
	}
	
	//Method 4: Partner Activities 
	public void partner_activities(){
		//TODO - Test Cases for Partner Activities
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}