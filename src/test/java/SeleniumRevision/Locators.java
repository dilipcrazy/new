package SeleniumRevision;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {
	WebDriver driver;
	
	public void launchBrowser(String url)
	{
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.get(url);
	    driver.manage().window().maximize();
	}
	public WebElement findLocators(String locator,String value)
	{  
		if(locator.equals("id")) {
		WebElement element = driver.findElement(By.id(value));
		return element;
		}
		else if(locator.equals("name")) {
		WebElement element = driver.findElement(By.name(value));
		return element;
		}
		else {
			WebElement element = driver.findElement(By.xpath(value));
			return element;
		}	
	}
	public Alert alert(){
		Alert a=driver.switchTo().alert();
		return a;
	}
	public WebDriver frame() {
		WebDriver frame = driver.switchTo().defaultContent();
		return frame;
	}
	public Actions actionClass(WebElement element) {
		Actions act=new Actions(driver);
	     Actions moveToElement = act.moveToElement(element);
		 return act;
	}
	public void javaScript(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object javaScriptdriver = js.executeScript("arguments[0].setAttribute('value','1245')",element);
		
	}
	
	public static void main(String[] args) {
		Locators l=new Locators();
		l.launchBrowser("https://testautomationpractice.blogspot.com/");
		WebDriver frame = l.frame();
		frame.switchTo().frame(0);
		WebElement element = l.findLocators("xpath", "//*[@id=\"RESULT_TextField-3\"]");
		 l.javaScript(element);
		System.out.println("Branch D");
	
        
       
        
        
        

	}

}
