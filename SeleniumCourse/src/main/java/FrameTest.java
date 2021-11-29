import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		
		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com/droppable/");
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//moves to frame 
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		//now we can click on element
		driver.findElement(By.id("draggable")).click();
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		//dragging and dropping
		a.dragAndDrop(source, target).build().perform();
		//backing to outside of frame
		driver.switchTo().defaultContent();
		

	}

}
