package mentoring;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import utility.webDriverInstance;

public class safeword extends webDriverInstance{
	
	public void safeword_data() throws InterruptedException{
	
		driver.get("http://dev.angular.brightsidementoring.tudip.uk");
	    driver.findElement(By.linkText("Sign in")).click();
	    driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[1]/div/input")).sendKeys("mentee.test@tudip.com");
	    driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[2]/div/input")).sendKeys("tudip123");
	    driver.findElement(By.xpath("/html/body/app/main/sign-in/div/div/div/div/form/div[3]/input")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/feeds/div/div[1]/div/div[1]/a")).click();
	    
	    String safeword_list[]={"Analyse","Analysed","Analysing","Analyze","Analyzing","Analyst","Analysts","Aston","Astronomy","Astronomical","Astrological","Black","Butterfly","Butterflies","Button","Buttons","Callum","Cocker","Cracked","Cumbria","Cumbrian","Cumulative","Cumulation","Deadline","Deadlines","Dickens","Hundred","Hundreds","Instance","Instances","Instant","Install","Installments","Installments","Japan","Japanese","Maxillofacial","Maximum","Method","Methods","Methodology","Methodologies","Methodological","Mongolia","Mongolian","Muffin","Muffins","Nadia","Nazihah","Pakistan","Pakistani","Paint","Paints","Painter","Painters","Painting","Paintings","Pool","Pools","Pooling","Poor","Poorer","Poorest","Punchy","Punchier","Space","Spacing","Tested","Tester","Textbook","Textbooks","Titanic","Title","Titles","Titling","Vague","Vaguely","Vagueness","Virginia"};
	    for(int n=0;n<safeword_list.length;n++)
	    {
		    WebElement textbox = driver.findElement(By.id("chat__input"));
		    
		  //scenario 1: 
		    textbox.sendKeys(safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 2:
		    textbox.sendKeys("africoon " + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 3:
		    textbox.sendKeys("africoon" + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 4:
		    textbox.sendKeys(safeword_list[n] + " africoon");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 5:
		    textbox.sendKeys(safeword_list[n] + "africoon");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 6:
		    textbox.sendKeys("africoon " + safeword_list[n] + " demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 7:
		    textbox.sendKeys("africoon" + safeword_list[n] + " demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 8:
		    textbox.sendKeys("africoon" + safeword_list[n] + "demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 9:
		    textbox.sendKeys("https://www.google.com " + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 10:
		    textbox.sendKeys("https://www.google.com" + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 11:
		    textbox.sendKeys("https://www.google.com " + safeword_list[n] + "demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 12:
		    textbox.sendKeys("https://www.google.com" + safeword_list[n] + "demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //scenario 13:
		    textbox.sendKeys("https://www.google.com" + safeword_list[n] + " demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
	    }
	}
}