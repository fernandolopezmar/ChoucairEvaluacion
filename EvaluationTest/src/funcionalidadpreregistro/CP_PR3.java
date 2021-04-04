package funcionalidadpreregistro;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_PR3 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String URL = "http://automationpractice.com/index.php";
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		//Click en el botón "Sign in"
		driver.findElement(By.linkText("Sign in")).click();
		 
		//Ingresar el correo
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("{{fernando@test.com");
		
		//Click en el botón "Create an account"
		driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
				
		// Validar que ingreso al siguiente formulario
		try {
			driver.findElement(By.id("customer_firstname"));
			System.out.println("Ingreso al siguiente formulario,prueba insatisfactoria");
		}catch (NoSuchElementException e){
			System.out.println("No ingreso al siguiente formulario,prueba satisfactoria");
		}
	}
	
}
