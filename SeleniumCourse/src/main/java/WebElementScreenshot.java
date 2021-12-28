import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementScreenshot {

	public static void main(String[] args) throws IOException {
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameField = driver.findElement(By.name("name"));
		File sceenshotFieldName = nameField.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(sceenshotFieldName, new File ("fieldName.png"));
		
		System.out.println(nameField.getRect().getDimension().getHeight());
		System.out.println(nameField.getRect().getDimension().getWidth());
		

	}

}
