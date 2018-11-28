package utility;
import org.openqa.selenium.*;

public class defaultLogin extends webDriverInstance{
	
	public static void user_login(String user_email, String user_password) throws InterruptedException{
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(user_email);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(user_password);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
		Thread.sleep(3000);
	}
	
	public static void admin_login(String admin_email, String admin_password) throws InterruptedException{
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("/html/body/app/main/home/mentoringhome/div/div/div/div[1]/div/div[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys(admin_email);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys(admin_password);
		driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
		Thread.sleep(3000);
	}
}
