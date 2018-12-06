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
		Assert.assertEquals(currentCreatePartnerURL, constantURL.createPartnerURL, "Create Partner URL doesn't matched");
	}	
	
	//Admin: Projects
	public static void project_navigation() throws InterruptedException{
		String currentProjectURL = driver.getCurrentUrl();
		Assert.assertEquals(currentProjectURL, constantURL.projectURL, "Project URL doesn't matched");
	}
	
	//Admin: Users
	public static void users_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[3]/a")).click();
		Thread.sleep(3000);
		String currentUsersURL = driver.getCurrentUrl();
		Assert.assertEquals(currentUsersURL, constantURL.usersURL, "Users URL doesn't matched");
	}
	
	//Admin: Moderation
	public static void moderation_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[4]/a")).click();
		Thread.sleep(3000);
		String currentModerationURL = driver.getCurrentUrl();
		Assert.assertEquals(currentModerationURL, constantURL.moderationURL, "Moderation URL doesn't matched");
	}

	//Admin: Support Request
	public static void support_request_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[5]/a")).click();
		Thread.sleep(3000);
		String currentSupportRequestURL = driver.getCurrentUrl();
		Assert.assertEquals(currentSupportRequestURL, constantURL.supportRequestURL, "Support Request URL doesn't matched");
	}
	
	//Admin: Reporting
	public static void reporting_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[6]/a")).click();
		Thread.sleep(3000);
		String currentSupportRequestURL = driver.getCurrentUrl();
		Assert.assertEquals(currentSupportRequestURL, constantURL.reportingURL, "Reporting URL doesn't matched");
	}

	//Admin: Communities
	public static void admin_communities_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[7]/a")).click();
		Thread.sleep(3000);
		String currentAdminCommunitiesURL = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminCommunitiesURL, constantURL.communitiesURL, "Communities URL doesn't matched");
	}
	
	//Admin: Activities
	public static void admin_activities_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[8]/a")).click();
		Thread.sleep(3000);
		String currentAdminActivitiesURL = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminActivitiesURL, constantURL.activitiesURL, "Activities URL doesn't matched");
	}
	
	//Admin: News
	public static void admin_news_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[9]/a")).click();
		Thread.sleep(3000);
		String currentAdminNewsURL = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminNewsURL, constantURL.newsURL, "News URL doesn't matched");
	}
	
	//Admin: Published Articles
	public static void admin_published_articles_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[9]/a")).click();
		Thread.sleep(3000);
		String currentAdminPublishedArticlesURL = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminPublishedArticlesURL, constantURL.published_articlesURL, "Published Articles URL doesn't matched");
	}

	//Admin: Draft Articles
	public static void admin_draft_articles_navigation() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[9]/a")).click();
		Thread.sleep(3000);
		String currentAdminDraftArticlesURL = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminDraftArticlesURL, constantURL.draft_articlesURL, "Draft Articles URL doesn't matched");
	}
	
	//Admin: Categories
	public static void admin_categories() throws InterruptedException{
		driver.findElement(By.xpath("")).click();		
		Thread.sleep(3000);
		String currentAdminCategories = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminCategories, constantURL.categoriesURL, "Categories URL doesn't matched");	
	}

	//Admin: Published Materials
	public static void admin_published_materials() throws InterruptedException{
		driver.findElement(By.xpath("")).click();		
		Thread.sleep(3000);
		String currentAdminPublishedMaterials = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminPublishedMaterials, constantURL.published_materialsURL, "Published materials URL doesn't matched");	
	}
	
	//Admin: Draft Materials
	public static void admin_draft_materials() throws InterruptedException{
		driver.findElement(By.xpath("")).click();		
		Thread.sleep(3000);
		String currentAdminDraftMaterials = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminDraftMaterials, constantURL.draft_materialsURL, "Draft materials URL doesn't matched");	
	}

	//Admin: Draft Materials
	public static void admin_mentoring() throws InterruptedException{
		driver.findElement(By.xpath("/html/body/app/main/pages/div/left-side-menu/div/ul/li[11]/a")).click();		
		Thread.sleep(3000);
		String currentAdminMentoring = driver.getCurrentUrl();
		Assert.assertEquals(currentAdminMentoring, constantURL.admin_mentoringURL, "Admin Mentoring URL doesn't matched");	
	}
}