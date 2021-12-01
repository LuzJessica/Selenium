
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicCalendar {

	public static void main(String[] args) {
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");

		//Selecting December 3
		driver.findElement(By.xpath(".//*[@id='travel_date']")).click();

		//We need to select month and then date


		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"))
				.getText().contains("April 2022")) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();

		}

		int count = driver.findElements(By.cssSelector("td.day")).size();

		for(int i=0; i<count; i++) {
			String text = driver.findElements(By.cssSelector("td.day")).get(i).getText();
			if(text.equalsIgnoreCase("3")) {
				driver.findElements(By.cssSelector("td.day")).get(i).click();
				break;
			}
		}
	}
}
