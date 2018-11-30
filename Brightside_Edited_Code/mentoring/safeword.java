package mentoring;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import utility.*;

public class safeword extends webDriverInstance{
	
	@Test
	public void safeword_data() throws InterruptedException{
	
		//User Login
		defaultLogin.user_login(constant.newEmailId, constant.newPassword);
		
	    driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/feeds/div/div[1]/div/div[1]/a")).click();
	    
	    String safeword_list[]={"Analyse","Analysed","Analysing","Analyze","Analyzing","Analyst","Analysts","Aston","Astronomy","Astronomical","Astrological","Black","Butterfly","Butterflies","Button","Buttons","Callum","Cocker","Cracked","Cumbria","Cumbrian","Cumulative","Cumulation","Deadline","Deadlines","Dickens","Hundred","Hundreds","Instance","Instances","Instant","Install","Installments","Installments","Japan","Japanese","Maxillofacial","Maximum","Method","Methods","Methodology","Methodologies","Methodological","Mongolia","Mongolian","Muffin","Muffins","Nadia","Nazihah","Pakistan","Pakistani","Paint","Paints","Painter","Painters","Painting","Paintings","Pool","Pools","Pooling","Poor","Poorer","Poorest","Punchy","Punchier","Space","Spacing","Tested","Tester","Textbook","Textbooks","Titanic","Title","Titles","Titling","Vague","Vaguely","Vagueness","Virginia"};
	    for(int n=0;n<safeword_list.length;n++)
	    {
		    WebElement textbox = driver.findElement(By.id("chat__input"));
		    
		  //Scenario 1: 
		    textbox.sendKeys(safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 2:
		    textbox.sendKeys("africoon " + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 3:
		    textbox.sendKeys("africoon" + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 4:
		    textbox.sendKeys(safeword_list[n] + " africoon");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 5:
		    textbox.sendKeys(safeword_list[n] + "africoon");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 6:
		    textbox.sendKeys("africoon " + safeword_list[n] + " demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 7:
		    textbox.sendKeys("africoon" + safeword_list[n] + " demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 8:
		    textbox.sendKeys("africoon" + safeword_list[n] + "demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 9:
		    textbox.sendKeys("https://www.google.com " + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 10:
		    textbox.sendKeys("https://www.google.com" + safeword_list[n]);
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 11:
		    textbox.sendKeys("https://www.google.com " + safeword_list[n] + "demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 12:
		    textbox.sendKeys("https://www.google.com" + safeword_list[n] + "demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
		    
		  //Scenario 13:
		    textbox.sendKeys("https://www.google.com" + safeword_list[n] + " demo");
		    textbox.sendKeys(Keys.SPACE);
		    driver.findElement(By.id("chat__send-message")).click();
		    Thread.sleep(2000);
	    }
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}