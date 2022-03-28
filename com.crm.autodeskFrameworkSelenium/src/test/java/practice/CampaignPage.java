package practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CampaignPage {
	public void campaignClick(WebDriver driver) {
		WebElement moreOption = driver.findElement(By.linkText("More"));
		Actions action= new Actions(driver);
		action.moveToElement(moreOption).perform();
		driver.findElement(By.name("Campaigns")).click();
	}
	public void createCampaign(WebDriver driver, String campaignName,String productName) throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@name='product_name']/../img")).click();
		Set<String> allWindowIds = driver.getWindowHandles();
		allWindowIds.remove(parentWindow);
		for (String string : allWindowIds) {
			driver.switchTo().window(string);
			break;
		}
		List<WebElement> productIds = driver.findElements(By.xpath("//a[text()]"));
		for (WebElement ele : productIds) {
			if (ele.getText().equalsIgnoreCase(productName)) {
				ele.click();
				break;
			}
		}
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
}
