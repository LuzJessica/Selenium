import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Scrolling down the window
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		
		//Scrolling down the table
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> valuesOfTable = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		for(int i=0; i<valuesOfTable.size(); i++) {
			
			sum = sum + Integer.parseInt(valuesOfTable.get(i).getText());
		}
		if(sum == Integer.parseInt(driver.findElement
				(By.cssSelector("div.totalAmount")).getText().substring(24, 27))) {
			System.out.println("Sum is correct");
		}

	}

}
