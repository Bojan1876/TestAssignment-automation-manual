package test3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// open orangehrml
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");

		// Click login
		driver.findElement(By.xpath("//*[@id='btnLogin']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		// Go to Recruitment page
		driver.findElement(By.xpath("//*[@id='menu_recruitment_viewRecruitmentModule']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		// Open the left side panel !!!
		driver.findElement(By.cssSelector(".mdi-navigation-menu")).click();;
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		
		//Click the Candidates
		driver.findElement(By.xpath("//*[@id=\"slide-out\"]/li[5]/a")).click();

		// close Chrome
		driver.close();
	}

}
