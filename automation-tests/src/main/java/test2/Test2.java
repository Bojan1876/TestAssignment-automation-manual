package test2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// open google.com
		driver.get("https://www.google.com");

		// Search for cheese
		driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("cheese");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"btnK\"]")).sendKeys(Keys.ENTER);

		// Gets all the cheese results on google
		String cheeseNumber = driver.findElement(By.xpath("//*[@id='resultStats']")).getText();
		System.out.println("Result: " + cheeseNumber);

		// Compare results with 777
		int res = 777;
		if (cheeseNumber.equals(res)) {
			System.out.println("Cheeseeeee");
		} else {
			System.out.println("There is too much cheese on the internet");
		}

		//close Chrome
		driver.close();

	}

}
