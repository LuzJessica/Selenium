import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Base {

	public static void main(String[] args) throws InterruptedException {

		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		String[] itemsNeeded = {"Brocolli","Cucumber","Carrot"};
		int j = 0;

		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(1000);



		List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));

		for(int i=0 ; i<products.size();i++) {

			String[] name = products.get(i).getText().split("-");
			String formattedName= name[0].trim();
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}

	}

}
