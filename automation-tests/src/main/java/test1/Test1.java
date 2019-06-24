package test1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// open google.com
		String baseUrl = "https://www.google.com";
		String expectedTitle = "Google";
		String actualTitle = "";
		driver.get(baseUrl);

		// search for wedoqa
		WebElement element = driver.findElement(By.name("q"));
		Thread.sleep(3000);
		element.sendKeys("wedoqa.com");
		element.submit();
		Thread.sleep(3000);

		// first result which will navigate to wedoqa.com
		driver.findElement(By.xpath("//h3[text()='Front Page - WeDoQa by ALAS doo']")).click();
		
		//take screenshots
		WebElement e = driver.findElement(By.xpath("//*[@id='testimonials']"));
		//driver.findElement(By.xpath("//*[@id='testimonials']"));
		WebElement es = driver.findElement(By.xpath("//h6[text()='EverSave']"));
		Thread.sleep(1500);
		TakesScreenshot ts = (TakesScreenshot) es;
		File source = ts.getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		FileUtils.copyFile(source, new File("./Test1ScreenShots/EverSave"));
		
		WebElement sim = driver.findElement(By.xpath("//h6[text()='SimplyMap']	"));
		Thread.sleep(1500);
		TakesScreenshot takes = (TakesScreenshot) sim;
		File simsource = takes.getScreenshotAs(OutputType.FILE);
		Thread.sleep(2000);
		FileUtils.copyFile(simsource, new File("./Test1ScreenShots/Simplymap"));
		
		WebElement pattern = driver.findElement(By.xpath("//h6[text()='Pattern Publishing']"));
		Thread.sleep(2000);
		TakesScreenshot ptakes = (TakesScreenshot) pattern;
		File psource = ptakes.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(psource, new File("./Test1ScreenShots/PatternPublishing"));
		
		//Print the testimonials from above to the console
		String dataes = driver.findElement(By.cssSelector("[id*='illdy'][id*='20']  q")).getAttribute("textContent");
		System.out.println("Result: " + dataes);
		//Print text from Tekyz !!!!!
		String datasim = driver.findElement(By.cssSelector("[id*='illdy'][id*='6']  q")).getAttribute("textContent");
		System.out.println("Result: " + datasim);
		
		String datapattern = driver.findElement(By.cssSelector("[id*='illdy'][id*='10']  q")).getAttribute("textContent");
		System.out.println("Result: " + datapattern);
		
		//Search Team
		/*String searchTeam = "Tt";*/
		/*WebElement search = (WebElement) driver.findElement(By.xpath("//*[@id='team']"));
		System.out.println(search);*/
		/*List<WebElement> team = driver.findElements(By.xpath("//*[@id='team']"));
		System.out.println("Number of elements: " + team.size());
		for(WebElement ele : team) {
			//System.out.println(ele.getText());
			int c=0;
			if(ele.equals('T') || ele.equals('t')) {
				c+=1;
				System.out.println("Number of char T i t: " + c);
			}
		}*/
		
		//Go to Blog
		driver.findElement(By.xpath("//*[@id='menu-item-3127']")).click();
		//Screenshot Blog
		WebElement blog = driver.findElement(By.xpath("//*[@id=\"header\"]"));
		Thread.sleep(2000);
		TakesScreenshot blogTs = (TakesScreenshot) blog;
		File bsource = blogTs.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(bsource, new File("./Test1ScreenShots/Blog"));
		
		//Search test
		WebElement test = driver.findElement(By.xpath("//*[@id=\"s\"]"));
		test.sendKeys("Test");
		test.submit();
		
		//Read out the date of the last entry and calculate how much days have passed since then
		

		/*actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}*/
		
		//close Chrome
		driver.close();

	}

}
