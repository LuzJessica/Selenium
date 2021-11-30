import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.qaclickacademy.com/practice.php");
		String elementToClick = "/html[1]/body[1]/div[1]/div[4]/fieldset[1]/label[3]";
		driver.findElement(By.xpath(elementToClick+"/input[1]")).click();
		
		String optionSelectedName = driver.findElement(By.xpath(elementToClick)).getText(); 
		
		WebElement exampleDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(exampleDropdown);
		dropdown.selectByVisibleText(optionSelectedName);
		
		driver.findElement(By.id("name")).sendKeys(optionSelectedName);
		
		driver.findElement(By.id("alertbtn")).click();
		
		if(driver.switchTo().alert().getText().contains(optionSelectedName)) {
			System.out.println("Popup alert contains the name of selected option");
		}
		
	}

}
