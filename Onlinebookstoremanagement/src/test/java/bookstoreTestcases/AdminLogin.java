package bookstoreTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminLogin {

	public static WebDriver driver;
	
	@Test
	public void adminLogin()
	{
		String workingDir=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",workingDir+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://localhost:9090/onlinebookstore-0.0.1-SNAPSHOT/");
		
		driver.findElement(By.linkText("Login As Admin")).click();
		
		driver.findElement(By.name("username")).sendKeys("Mayuresh");
		
		driver.findElement(By.name("password")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@value=' LOGIN AS ADMIN ']")).click();
		
		driver.quit();
	}
}
