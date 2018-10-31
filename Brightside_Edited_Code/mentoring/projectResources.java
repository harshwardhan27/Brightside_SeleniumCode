package mentoring;
import utility.webDriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class projectResources extends webDriverInstance{

	public void projectExternalMaterils(){
		
		WebElement resources_div = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[]"));
 		if (resources_div.isDisplayed()){
 			//Project Resources Test Cases
 		} else{
 			System.out.println("External Materials are not assigned");
 		}
	}
}
