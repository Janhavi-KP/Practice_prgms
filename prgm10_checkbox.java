package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class prgm10_checkbox {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		try {
		//Open Amazon.
		driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=8154360384140113559&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062008&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Search for a product, e.g., "Laptop".
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Laptop");
		Actions act= new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();		
		
		//On the left-side filter panel, locate the "Brand" section.
		
		driver.findElement(By.xpath("//span[normalize-space()='Brands']"));
		
		//Select a checkbox for a specific brand, e.g., "HP".
		WebElement hp_checkbox=driver.findElement(By.xpath("//a[@aria-label='Apply the filter HP to narrow results']//i[@class='a-icon a-icon-checkbox']"));	
		hp_checkbox.click();
		
		//Observe if the search results update.
		Thread.sleep(5000);
		WebElement hp_filter=driver.findElement(By.xpath("//span[contains(text(),'HP ')]"));
		if(hp_filter.isDisplayed())
		{
			System.out.println("search results are updated");
		}
		
		//Select another brand, e.g., "Dell", and check if results change accordingly.
		WebElement dell_checkbox=driver.findElement(By.xpath("//a[@aria-label='Apply the filter Dell to narrow results']//i[@class='a-icon a-icon-checkbox']"));	
		dell_checkbox.click();
		WebElement dell_filter=driver.findElement(By.xpath("//span[contains(text(),'HP')or contains(text(),'Dell')]"));
		if(dell_filter.isDisplayed())
		{
			System.out.println("both hp and dell results are updated");
		}
		
		//Uncheck one of the selected checkboxes and verify the result update
		
		driver.findElement(By.xpath("//a[@aria-label='Remove the filter HP to expand results']//i[@class='a-icon a-icon-checkbox']")).click();
		WebElement only_dell =driver.findElement(By.xpath("//span[contains(text(),'Dell ')]"));
		if(only_dell.isDisplayed())
		{
			System.out.println(" dell results are updated");
		}
		}
		catch(Throwable e)
		{
			System.out.println("error"+e.getMessage());
		}
		
		finally {
			driver.quit();
		}
	}
}
/*Test Case: Verify that selecting a filter checkbox refines the search results.

Steps:

Open Amazon.
Search for a product, e.g., "Laptop".
On the left-side filter panel, locate the "Brand" section.
Select a checkbox for a specific brand, e.g., "HP".
Observe if the search results update.
Select another brand, e.g., "Dell", and check if results change accordingly.
Uncheck one of the selected checkboxes and verify the result update
*/	
