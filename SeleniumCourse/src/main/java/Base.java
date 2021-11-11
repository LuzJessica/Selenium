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
			
			/*parsing the array of string to a array list of strings. Doing this because with array list in easier to serch elements
			inside. We can use method contain. For arrays whe do not have this. But we declare array first because array take less 
			memories */
			
			List itemsNeededList = Arrays.asList(itemsNeeded);
			//Thread.sleep(2500); in case of look to the elements of the list by text (name)
			//if the itens of list contains one of the formatted string, so we click on ADD TO CART button
			if(itemsNeededList.contains(formattedName)) {
				
				j++;
				/*do the click in a element find by te name is not the best way, because when in action this name can change.
				If we use this case, we need to put a thread sleep, so it has time to execute the action of click and come back to
				inicial state again. When we dont do that, the program can make a little confusion with the ids of the element in the 
				list. Another way to solve this is not add the element by name, but by a static property, as div-button*/
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				/* if the value of j is equal the lenght of the array of desired items, them we stop the the process because it means
				that all the needed items are in the cart */
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}

	}

}
