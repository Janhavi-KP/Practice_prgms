package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class prgm7_datePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		
		//input
		String requiredYear="2021";
		String requiredMonth="Jun";
		String requiredDate="15";
		//selecting month
		//driver.findElement(By.xpath("//select[@aria-label='Select month']")).click();
		WebElement month=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select month1=new Select(month);
		month1.selectByContainsVisibleText(requiredMonth);
		
		//selecting year
		WebElement year=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select year1=new Select(year);
		year1.selectByContainsVisibleText(requiredYear);
		
		//selectdate
		List<WebElement> date=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		for(WebElement op:date)
		{
			if(op.getText().equals(requiredDate))
			{
				op.click();
				break;
			}
		}

		
		
	}

}
