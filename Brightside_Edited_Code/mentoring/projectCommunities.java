package mentoring;
import utility.Constant;
import utility.webDriverInstance;
import org.openqa.selenium.*;
import org.testng.Assert;

public class projectCommunities extends webDriverInstance{
	
	public void communities_topics(){
		try{
			//User Login
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(Constant.newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(Constant.newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			
			//communities
			driver.findElement((By) By.xpath("//*[@id='mySidenavR']/ul/li[6]/a")).click();
			Thread.sleep(3000);
			String currentCommunitiesURL = driver.getCurrentUrl();
			Assert.assertEquals(currentCommunitiesURL,Constant.myCommunitiesURL, "Communities URL doesn't matched");
			System.out.println("Communities URL matched");		
			
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/communities/div/div[2]/div/div[1]"));
			Assert.assertTrue(driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/communities/div/div[3]/div/viewtopics/div/div[2]/div[contains(text(),'No data found']")).isDisplayed());
			System.out.println("Topics are present");
			
			//get topic description from communities page
			String topic_description = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/communities/div/div[3]/div/viewtopics/div/div[2]/div[2]/ul/li/div/div[2]")).getText();
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/communities/div/div[3]/div/viewtopics/div/div[2]/div[2]/ul/li/div/div[contains(text()," + Constant.topicName + ")]")).click();
		
			//check topic name on topics page 
			String currentTopicHeader = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/topicsthread/div/div[1]/div[2]/div[1]")).getText();
			Assert.assertEquals(currentTopicHeader, Constant.topicName, "Topics name doesn't matched");
			System.out.println("Topics name matched");
			
			//check topic description on topics page
			String currenTopicDescription = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/communities/div/div[3]/div/viewtopics/div/div[2]/div[2]/ul/li/div/div[2]")).getText();
			Assert.assertEquals(currenTopicDescription, topic_description, "Topics description doesn't matched");
			System.out.println("Topics description matched");
			
			//Add Thread
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/topicsthread/div/div[2]/div[1]/div[1]/div/a")).click();
			Thread.sleep(3000);
			String currentAddThreadURL = driver.getCurrentUrl();
			Assert.assertEquals(currentAddThreadURL,Constant.myAddThreadURL, "Add Thread URL doesn't matched");
			System.out.println("Add Thread URL matched");
			
			String currentTopicsName = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/addthread/div/div[3]/div[1]/div/angular2-multiselect/div/div[1]/div")).getText();
			Assert.assertEquals(currentTopicsName, Constant.topicName, "Topic name is not present in the topics drop-down");
			System.out.println("Topics name in topics drop-down matched");
			
		//Cases to create thread
			//With empty thread name field
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/addthread/div/div[3]/div[3]/textarea")).sendKeys(Constant.threadDescription);
			WebElement wb_submit = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/addthread/div/div[3]/fieldset/input"));
			Assert.assertFalse(wb_submit.isEnabled(), "Submit button is enabled");
			System.out.println("Submit button is not enabled");
			
			//With empty thread description field
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/addthread/div/div[3]/div[2]/textarea")).sendKeys(Constant.threadName);
			Assert.assertFalse(wb_submit.isEnabled(), "Submit button is enabled");
			System.out.println("Submit button is not enabled");
			
			//With both thread name and thread description
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/addthread/div/div[3]/div[2]/textarea")).sendKeys(Constant.threadName);
			driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/addthread/div/div[3]/div[3]/textarea")).sendKeys(Constant.threadDescription);
			Assert.assertTrue(wb_submit.isEnabled(), "Submit button is not enabled");
			System.out.println("Submit button is enabled");
			driver.findElement((By) wb_submit).click();
			Thread.sleep(5000);
			Alert addingMessage = driver.switchTo().alert();
			String currentAddedThreadMessage = addingMessage.getText();
			Assert.assertEquals(currentAddedThreadMessage,Constant.successAddThreadMessage, "Thread doesn't added successfully");
			System.out.println(currentAddedThreadMessage);
			
			//Check thread name
			String currentThreadName = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/threadspost/div[1]/span")).getText();
			Assert.assertEquals(currentThreadName, Constant.threadName, "Thread name doesn't matched");
			System.out.println("Thread name matched");
		} catch (Exception e) {
			e.printStackTrace();
			}
	}	
}
