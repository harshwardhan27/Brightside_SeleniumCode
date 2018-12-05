package utility;
import org.openqa.selenium.*;
import org.testng.Assert;

public class modulesNavigation extends webDriverInstance {

	//Users: Messaging
	public static void messaging_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/feeds/div/div[1]/div/div[1]/a")).click();
		Thread.sleep(3000);
		String mentoringURL = driver.getCurrentUrl();
		Assert.assertEquals(mentoringURL,constantURL.myMessagingURL, "Channels URL doesn't matched");
		System.out.println("Channels URL matched");
	}

	//Users: My Account
	public static void myAccount_navigation() throws InterruptedException{
		driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[2]/a")).click();
		Thread.sleep(3000);
		String currentAccountURL = driver.getCurrentUrl();
		Assert.assertEquals(currentAccountURL,constantURL.myAccountURL, "My account URL doesn't matched");
		System.out.println("Already have an account URL matched");
	}
	
	//Users: Assignments
	public static void assignments_navigation() throws InterruptedException{
		driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[2]/a")).click();
		Thread.sleep(3000);
		String currentAssignmentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentAssignmentURL,constantURL.myAssignmentURL, "Assignments URL doesn't matched");
		System.out.println("Assignments URL matched");
	}
	
	//Users: Project Resources
	public static void resources_navigation() throws InterruptedException{
		driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[5]/a")).click();
		Thread.sleep(3000);
		String currentResourcesURL = driver.getCurrentUrl();
		Assert.assertEquals(currentResourcesURL,constantURL.myResourcesURL, "Resources URL doesn't matched");
		System.out.println("Resources URL matched");
	}

	//Users: Activities
	public static void activities_navigation() throws InterruptedException{
		driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[5]/a")).click();
		Thread.sleep(3000);
		String currentActivitiesURL = driver.getCurrentUrl();
		Assert.assertEquals(currentActivitiesURL, constantURL.myActivitiesURL, "Activities URL doesn't matched");
	}
	
	//Users: Communities
	public static void communities_navigation() throws InterruptedException{
		driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[6]/a")).click();
		Thread.sleep(3000);
		String currentCommunitiesURL = driver.getCurrentUrl();
		Assert.assertEquals(currentCommunitiesURL,constantURL.myCommunitiesURL, "Communities URL doesn't matched");
		System.out.println("Communities URL matched");
	}
	
	//Users: Ask the Graduates
	public static void askTheGraduate_navigation() throws InterruptedException{
		driver.findElement(By.xpath("//*[@id='mySidenavR']/ul/li[3]/a")).click();
		Thread.sleep(3000);
	}
	
	//Admin: Partner
	public static boolean partners_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[1]/a")).click();
		Thread.sleep(3000);
		String curentPartnerURL = driver.getCurrentUrl();
		Assert.assertEquals(curentPartnerURL,constantURL.partnerURL, "Partner URL doesn't matched");
		System.out.println("Partner URL matched");
		return true;
	}

	public static void createPartners_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/app-partners/div/div[2]/div[1]/a")).click();
		Thread.sleep(3000);
		String currentCreatePartnerURL = driver.getCurrentUrl();
		Assert.assertEquals(currentCreatePartnerURL, constantURL.createPartnerURL);
	}
}
