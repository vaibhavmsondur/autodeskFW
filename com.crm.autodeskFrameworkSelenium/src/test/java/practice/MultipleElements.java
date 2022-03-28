package practice;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleElements {
	public MultipleElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> checkBoxes;
	
	public List<WebElement> getCheckBoxes() {
		return checkBoxes;
	}
	
	public void clickOnCheckBox() {
		int count=0;
			for (WebElement ele : checkBoxes) {
				if( count<2) {
					ele.click();
					count++;
				}else {
					break;
			}	
		}
		
	}
}
