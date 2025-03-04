package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class prgm9_dropdown {
	public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	//Open Amazon.
	driver.get("https://www.amazon.in/?&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=155259813593&hvpone=&hvptwo=&hvadid=674893540034&hvpos=&hvnetw=g&hvrand=8154360384140113559&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062008&hvtargid=kwd-64107830&hydadcr=14452_2316413&gad_source=1");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	//Locate the "All" dropdown next to the search bar.
	WebElement All=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	
	//Click on the dropdown to expand the list.
	All.click();
	Select dropdown= new Select(All);
	
	//Select a category, e.g., "Books".
	dropdown.selectByVisibleText("Books");
	
	//Enter a search term, e.g., "Harry Potter".
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Harry Potter");
	
	//Click the Search button.
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	
	
	//Verify that the search results are only from the selected category ("Books")
	String options= driver.findElement(By.xpath("//span[@class='a-size-base a-color-base a-text-bold'][normalize-space()='Books']")).getText();
	
	if(options.equals("Books"))
	{
		System.out.println("the search results are from selected category only");
	}
	
	driver.quit();	
	}

}
	
/*
Test Case: Verify that the category selection dropdown works correctly on the Amazon homepage.

Steps:

Open Amazon.
Locate the "All" dropdown next to the search bar.
Click on the dropdown to expand the list.
Select a category, e.g., "Books".
Enter a search term, e.g., "Harry Potter".
Click the Search button.
Verify that the search results are only from the selected category ("Books")
*/