package define_labs;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static void main(String[] args) {
		WebDriver cd = new ChromeDriver();
		
		cd.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		cd.navigate().to("https://www.bhaane.com/");
		cd.findElement(By.xpath("//*[@id=\"mdiv\"]/div/div")).click();
		
//		clicking on account to register
		cd.findElement(By.xpath("//*[@id=\"top-header\"]/div/div/div[4]/ul/li[2]")).click();
		cd.findElement(By.xpath("//*[@id=\"modal-login\"]/div/form/div[4]/div")).click();
//		entering details in all fields
		cd.findElement(By.name("first_name")).sendKeys("Pankaj");
		cd.findElement(By.name("last_name")).sendKeys("Kumar");
		cd.findElement(By.xpath("//*[@id=\"modal-register\"]/div/form/div[1]/div[3]/div/input")).sendKeys("pankaj@kumars.com");
		cd.findElement(By.xpath("//input[@type='tel']")).sendKeys("9898989797");
		cd.findElement(By.xpath("//*[@id=\"modal-register\"]/div/form/div[1]/div[5]/div/input")).sendKeys("pankaj@1234");
		cd.findElement(By.xpath("//*[@id=\"modal-register\"]/div/form/div[2]/button")).click();
//		user will be registered successfully
		
		JavascriptExecutor js = (JavascriptExecutor) cd;
		js.executeScript("window.scrollBy(0, 1000)");
		
//		selecting that product
		cd.findElement(By.xpath("//*[@id=\"rows\"]/div[5]/a/div/img")).click();
		
//		now we have to switch the control of driver to another window
		Set<String> wID = cd.getWindowHandles();
		Iterator<String> it = wID.iterator();
		String firstWinID = it.next();
		String secondWinID = it.next();
		
		System.out.println(cd.getTitle());
		cd.switchTo().window(secondWinID);
		System.out.println(cd.getTitle());
		
//		adding that product to cart
		cd.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/div/div[2]/div/form/div[3]/div/button[1]/span")).click();
		
//		going to final steps for checkout
		cd.findElement(By.xpath("//*[@id=\"modal-bag\"]/div/div[1]/div[3]/a[2]")).click();
	}
}
