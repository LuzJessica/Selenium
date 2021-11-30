
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");

		//Give me the count of links on the page, based on that links are referenced by 'a' tag
		System.out.println(driver.findElements(By.tagName("a")).size());

		//Give me the count of links on the footer page
		System.out.println(driver.findElements(By.xpath("//div/table/tbody/tr/td/ul/li")).size());


		//Limiting webdriver scope to footer
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		//Now limiting to first footer column 
		WebElement firstColumnFooterDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(firstColumnFooterDriver.findElements(By.tagName("a")).size());

		/* Click on each link in the column and check if pages are opening each one in one tab
		  This method is used to improve the solution because, if we don't use it, we need to click
		  in each tab and after back to the previous page to click in the next link
		 */

		for(int i=1; i<firstColumnFooterDriver.findElements(By.tagName("a")).size(); i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);

			Thread.sleep(5000L);
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while(it.hasNext()){
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
}


