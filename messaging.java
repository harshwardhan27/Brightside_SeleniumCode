package org.brightside.selenium;

import org.openqa.selenium.By;

public class messaging extends firstClass {
	
	String messagingURL = "http://dev.angular.brightsidementoring.tudip.uk/channels";
	String testMessage = "Test Message";
	
	public void mesaging() throws InterruptedException{
		try {
			driver.get(baseURL);
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(newEmailId);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(newPassword);
			driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
			Thread.sleep(3000);
			String mentoringURL = driver.getCurrentUrl();
			if (mentoringURL.equalsIgnoreCase(messagingURL)){
				System.out.println("Channels URL Matched");
				driver.findElement(By.linkText("Mentoring")).click();
				driver.findElement(By.linkText("Mentoring")).click();
				driver.findElement(By.id("chat__input")).sendKeys(testMessage);
				Thread.sleep(3000);
				driver.findElement(By.id("chat__send-message")).click();
				System.out.println(testMessage + " " + "message to be sent");		
			} else {
			    System.out.print("Channels URL doesn't matched");
			    driver.quit();
			 	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}	

			
	

}