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
		
			
		//Create a array of strings that contains the products that I need/want to add to my cart
		String[] itemsNeeded = {"Brocolli","Cucumber","Carrot"};
		//controll variable to know when the number os desired items were added to cart
		int j = 0;

		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		driver.navigate().to("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(1000);

		

		//receive de list of all the web elements called product-name in the website
		List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));

		for(int i=0 ; i<products.size();i++) {

			/* variable name created to receive the name os products that were found in List of webelements. Also split that string 
			based on de - character */
			String[] name = products.get(i).getText().split("-");
			/*the name of products are like this: Brocolli - 1 Kg. When we do a .split(-), the string is divided in 2
			 Brocolli  and 1 Kg, but the first parte of the string has a space in the end that does not appear in the string 
			in the array. For comparation this is important, because Brocolli with space is diferent of Brocolli whitout space
			so, to guarantee that behaviour, we trim the string, is will remove all the spaces, before and after them */
			String formattedName= name[0].trim();
			
			//parsing the arrar of string to a list of strings
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			//if the itens of list contains one of the formatted string, so we click on ADD TO CART button
			if(itemsNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				/* if the value of j is equal the lenght of the array of desired items, them we stop the the process because it means
				that all the needed items are in the cart */
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}

	}

}
