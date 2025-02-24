package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prgm6_staticTable {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.blazedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.tagName("input")).click();
			List<Double> prices = new ArrayList<>(); // List to store price values
	
			// Find total number of rows
			 List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tr"));
			        int rowCount = rows.size();
	
			        for (int r = 2; r <= rowCount; r++)
			        { // Assuming first row is a header
			            WebElement priceElement = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]"));
			            String priceText = priceElement.getText().replace("$", ""); // Remove $ symbol if present
			            prices.add(Double.parseDouble(priceText)); // Convert to double and add to list
			        }
	
			        // Sort the prices in ascending order
			        Collections.sort(prices);
			        System.out.println("Sorted Prices: " + prices);
			        
	
			        driver.quit(); // Close the browser
			    }
		

		
		
	}

/* 
choose departure and destination city
selecting lowest price
*/