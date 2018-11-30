package mentoring;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import utility.*;

public class projectResources extends webDriverInstance{
	
	@Test
	public void assignedExternalMaterils() throws InterruptedException{
		try {
			//User Login
			defaultLogin.user_login(constant.newEmailId, constant.newPassword);
			
			//Redirection to project resources
			modulesNavigation.resources_navigation();
			
			//Project Resources
			WebElement resources_div = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[1]"));
			Assert.assertFalse(resources_div.isDisplayed(), "External Materials are not assigned");
			String materialLink;
			Assert.assertFalse(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[1]/div/span[contains(text()," + constant.externalMaterialTitle + ")]")).isDisplayed());
			System.out.println("Given external material is present");
			WebElement materialLinkSpan = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[1]/div/span[contains(text()," + constant.externalMaterialTitle + ")]"));
			materialLink = materialLinkSpan.getAttribute("href");
			materialLinkSpan.click();
			Thread.sleep(5000);
			String materialCurrentURL = driver.getCurrentUrl();
			Assert.assertEquals(materialLink, materialCurrentURL, "Materials link doesn't opened");
			System.out.println("Materials Current URL matched");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}


