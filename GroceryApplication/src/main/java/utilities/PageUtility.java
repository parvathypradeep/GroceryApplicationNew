package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropContainsValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByContainsVisibleText(value);
	}
	
	public void selectDragDropWithIndex(WebElement element, int index) {
		Select object=new Select(element);
		object.selectByIndex(index);
	}
	
	public void selectDragDropWithVisibleText(WebElement element, String text) {
		Select object=new Select(element);
		object.selectByVisibleText(text);
	}
	
	public void deselectDragDrop(WebElement element, String value) {
		Select object=new Select(element);
		object.deselectAll();
	}
	
	public void deselectDragDropContainsValue(WebElement element, String value) {
		Select object=new Select(element);
		object.deSelectByContainsVisibleText(value);
	}
	
	public void deselectDragDropWithVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.deselectByIndex(0);
	}
	
	public void deselectDragDropWithIndex(WebElement element, String value) {
		Select object=new Select(element);
		object.deselectByIndex(0);
	}
	
	public void deselectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.deselectByValue(value);
	}
	
	public void sendKeys(WebElement element, String text) 
	{
		element.sendKeys(text);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		Alert a1=driver.switchTo().alert();
		a1.accept();
	}
	public void handlingFrame(WebDriver driver,WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	
	public void clickUsingJS(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void scrollUsingJS(WebDriver driver, WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	public void selectUsingRadioButton(WebElement element) 
	{
		element.click();
	}
	
	public void selectUsingCheckbox(WebElement element1, WebElement element2) 
	{
		element1.click();
		element2.click();
	}
	
}
