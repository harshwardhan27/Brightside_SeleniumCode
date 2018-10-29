package mentoring;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import brightsideDefault.homePage;
public class projectResources extends homePage{
	
	public void projectExternalMaterils(){
		WebElement resources_div = driver.findElement(By.xpath("/html/body/app/main/pages/div/div/div/project-resources/div/div/div[2]/div[]"));
 		if (resources_div.isDisplayed()){
 			
 		} else{
 			System.out.println("External Materials are not assigned");
 		}
	}
}
