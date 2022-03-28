package com.crm.autodeskFrameworkSelenium.genericUtility;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * it contains WebDriver specific reusable actions
 * @author VAIBHAV
 *
 */
public class WebDriverUtility {
	/**
	 * wait for the page to load before identifying any synchronized element in DOM [HTML=- Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * wait for the page to load before identifying any asynchronized element [Java scripts actions] in DOM [HTML=- Document]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	/**
	 * used to wait for element to be click-able in GUI and Check for Specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to wait for element to be visible in GUI and Check for Specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * used to wait for element to be click-able in GUI and Check for Specific element for every 500 milli seconds 
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to Switch to any window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it= set.iterator();
		
		while (it.hasNext()) {
			String wID= it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle= driver.getTitle();
			if (currentWindowTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	
	/**
	 * used to switch to Alert Window and Click on accept button
	 * @param driver
	 */
	public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to switch to Alert Window and Click on cancel button
	 * @param driver
	 */
	public void switchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel= new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropdown based on visible Text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);;
	}
	
	/**
	 * used to select the value from the dropdown based on value attribute
	 * @param element
	 * @param text
	 */
	public void select(String value,WebElement element) {
		Select sel= new Select(element);
		sel.selectByValue(value);;
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions action= new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions action= new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * used to Wait and Click on an element with a period of 1 second
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count=0;
		while (count<20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * used to execute Async java script
	 * @param driver
	 * @param javaScript
	 */
	public void executeAsyncJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	/**
	 * used to execute sync java script
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript(javaScript, null);
	}
	
	/**
	 * used to TakeScreenshot of a Web Page
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		String timeStamp= LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts= (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotName+timeStamp+".PNG");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
	}
	
	/**
	 * used to TakeScreenshot of a Web Element
	 * @param element
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebElement element, String screenshotName) throws Throwable {
		String timeStamp= LocalDateTime.now().toString().replace(":", "-");
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshot/"+screenshotName+timeStamp+".PNG");
		FileUtils.copyFile(src, dest);
	}
	
	/**
	 * used to press Enter key
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions action= new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
}
