import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		
		/* This class is about Parent and child windows. Once we move from a parent to a child windows,
		 * the driver dont know how to handle with this, in case this is new window. Só we use this class to solve 
		 * this problem*/
		
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();//doing this we have now one id for parent and onde for child window
		Iterator<String> it = windows.iterator();//return the list of windows
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		String email = (driver.findElement(By.cssSelector(".im-para.red")).getText().substring(19, 48));
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
		
	}

}
