package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class prgm2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//valid credentials
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		//add a product to cart and verifying displayed or not 
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();//selecting product
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();//add cart icon
		Thread.sleep(5000);
		
		WebElement product1=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		if(product1.getText().equals("Sauce Labs Bolt T-Shirt")) {
			System.out.println("product added to cart successfull");
		}
		else {
			System.out.println("failed");
		}
		
		//logout
		driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
		
	}

}
/*
Open the browser and navigate to SauceDemo.
Enter valid credentials:
Username: standard_user
Password: secret_sauce
Click the Login button.
Add a product (e.g., "Sauce Labs Backpack") to the cart.
Click on the cart icon to view the cart.
Verify that the product is displayed in the cart.
Logout from the application.*/