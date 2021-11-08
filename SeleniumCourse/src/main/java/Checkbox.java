import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;

public class Checkbox {

	public static void main(String[] args) {
	
		System.getProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\SeleniumCourse\\SeleniumCourse\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		Assert.assertEquals(6, driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		

	}

}
