package brightsideAdmin;
import java.util.List;
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
	
	@Test
	//Method 4: Partner Activities 
	public void partner_activities() throws InterruptedException{
		
		search_partner();
		driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[3]/div[1]/table/tbody/tr[2]/td[1]/a"));
		Thread.sleep(2000);
		if(constant.enableActivities == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/nav/ul/li[2]")).click();
			Thread.sleep(2000);
			Assert.assertFalse(driver.findElement((By) By.xpath("//*[@id='activities-wrap']/div[1]/h4")).isDisplayed(), "Core Activites title doesn't present");	
			
			//To Assign Core Activities
			driver.findElement((By) By.xpath("//*[@id='activities-wrap']/div[1]/a")).click();
			Assert.assertFalse(driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/app-new-partner-activities/div/div[3]/table/tbody/tr/td[2]/div/div/div[1]/span")).contains("Activities (0)"), "Default Activities Count is not corrrect");
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-new-partner-activities/div/div[3]/table/tbody/tr/td[1]/div/ul[1]/li")).click();
			
			WebElement category = driver.findElement(By.className("list-heading"));
			List list = (List) category.findElement(By.xpath(".//li"));
			list.size();
			for(int n=1;n>=list.size();n++){
				driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-new-partner-activities/div/div[3]/table/tbody/tr/td[1]/div/ul[" + n	 + "]/li")).click();
				boolean list_record = driver.findElement(By.className("sublist")).isDisplayed();
				if(list_record == true){
					WebElement sub_category = driver.findElement(By.className("sublist"));
					List sub_list = (List) sub_category.findElement(By.xpath(".//li"));
					sub_list.size();
					for(int p=1;p>=sub_list.size();p++){
						driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-new-partner-activities/div/div[3]/table/tbody/tr/td[1]/div/ul[" + n + "]/ul/li[" + p + "]")).click();
						boolean no_record = driver.findElement(By.className("no-record")).isDisplayed();
						if (no_record == false){
							driver.findElement(By.className("select-all-checkbox")).click();
							driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-new-partner-activities/div/div[3]/table/tbody/tr/td[2]/div/div/div[1]/a")).click();
							Thread.sleep(3000);
						}
					}
				}
			}
		}
	}
	
	//Method 5: Partner Materials 
	public void partner_materials() throws InterruptedException{
		
		search_partner();
		driver.findElements(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[3]/div[1]/table/tbody/tr[2]/td[1]/a"));
		Thread.sleep(2000);
		if(constant.enableExternalMaterial == true){
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/nav/ul/li[3]/a")).click();
			Thread.sleep(3000);
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-external-materials/div/div[1]/h4")).isDisplayed(), "External Materials title doesn't present");	
			
			//To Assign External Materials
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-manage-partner/div/div[2]/div/div/app-external-materials/div/div[1]/a")).click();
			Thread.sleep(3000);
			boolean material_record = driver.findElement(By.className("no-record")).isDisplayed();
			if(material_record == false){
				driver.findElement(By.id("allId")).click();
				driver.findElement(By.className("activities-btn")).click();
				Thread.sleep(3000);
				System.out.println("All selected materials assigned successfully");
			}
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}