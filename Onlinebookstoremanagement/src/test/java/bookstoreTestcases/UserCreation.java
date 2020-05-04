package bookstoreTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserCreation {
	
	public static WebDriver driver;
	
	@Test
	public static void createUser()
	{
		String workingDir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",workingDir+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://localhost:9090/onlinebookstore-0.0.1-SNAPSHOT/");
		
		driver.findElement(By.linkText("New user ! Register Here")).click();
		
		driver.findElement(By.name("username")).sendKeys("Mayuresh");
		
		driver.findElement(By.name("password")).sendKeys("admin");
		
		driver.findElement(By.name("firstname")).sendKeys("Mayuresh");
		
		driver.findElement(By.name("lastname")).sendKeys("Marathe");
		
		driver.findElement(By.name("address")).sendKeys("Pune");
		
		driver.findElement(By.name("phone")).sendKeys("9090909090");
		
		driver.findElement(By.name("mailid")).sendKeys("m@m.com");
		
		driver.findElement(By.xpath("//input[@value=' I AGREE FOR ALL TERMS & CONDITIONS ! REGISTER ME ']")).click();
		
		driver.quit();
	}

}
