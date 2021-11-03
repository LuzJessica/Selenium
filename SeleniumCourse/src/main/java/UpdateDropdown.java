import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Alex\\SeleniumCourse\\SeleniumCourse\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int numberOfAdults = 4;
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(500);

		while (numberOfAdults != 0 ) {

			driver.findElement(By.xpath("//div/span[@id='hrefIncAdt']")).click();
			numberOfAdults --;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
