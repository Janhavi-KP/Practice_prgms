package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prgm5_autoSuggest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='What are you looking for today?']")).sendKeys("eggs");//searchBar
		
		List<WebElement>options=driver.findElements(By.xpath("//div[@class='list list-group']"));
		System.out.println(options.size());	
		
		for(WebElement op:options)
		{
			//String op1=op.getText();
			System.out.println(op.getText());
			if(op.equals("eggs"))
				{
				op.click();
				}
		}
	}

}
