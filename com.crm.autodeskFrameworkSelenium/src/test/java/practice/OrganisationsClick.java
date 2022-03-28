 package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrganisationsClick {
	
	public void organisationClick(WebDriver driver) {
		driver.findElement(By.xpath("//td[@class='tabUnSelected']//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}
	
	public void organisationDetails(WebDriver driver, String orgName) {
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	public void organisationDetails(WebDriver driver, String orgName, String industry) {
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Select s= new Select(driver.findElement(By.name("industry")));
		s.selectByVisibleText(industry);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	public void logOut(WebDriver driver) {
		WebElement moves = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(moves));
		Actions action= new Actions(driver);
		action.moveToElement(moves).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
}
