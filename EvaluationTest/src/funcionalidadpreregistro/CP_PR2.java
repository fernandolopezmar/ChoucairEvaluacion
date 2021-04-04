package funcionalidadpreregistro;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_PR2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String URL = "http://automationpractice.com/index.php";
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		//Click en Sign in
		driver.findElement(By.linkText("Sign in")).click();
		
		//Click en el botón "Create an account"
		driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
		
		String campo ="create_account_error";
		
		// Validar si se muestra el mensaje de error
		try {
			driver.findElement(By.id("create_account_error"));
			System.out.println("Se muestra el mensaje de error, prueba satisfactoria");
		}catch (NoSuchElementException e){
			System.out.println("No se muestra el mensaje de error, prueba insatisfactoria");
		}
	}
	
}
