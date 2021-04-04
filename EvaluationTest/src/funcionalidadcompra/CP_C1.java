package funcionalidadcompra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CP_C1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String URL = "http://automationpractice.com/index.php";
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		//Click en el botón "Sign in"
		driver.findElement(By.linkText("Sign in")).click();
		
		//Ingresar con el usuario registrado
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testfernando@test.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		
		//Seleccionar el producto, la cantidad y su talla
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/ul/li[2]/ul/li[3]/a")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[2]")));
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_wanted']")).sendKeys("3");
		Select size = new Select (driver.findElement(By.xpath("//select[@id='group_1']")));
		size.selectByValue("2");
		driver.findElement(By.id("color_15"));
		
		//Añadir al carrito
		driver.findElement(By.xpath("//p[@id='add_to_cart']/button/span")).click();
		
		//Confirmar en Summary
		driver.findElement(By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a/span")).click();
		
		//Confirmar en Address
		driver.findElement(By.xpath("//div[@id='center_column']/p[2]/a/span")).click();
		
		//Confirmar en Shipping
		driver.findElement(By.xpath("//div[@id='center_column']/form/p/button/span")).click();
		driver.findElement(By.id("cgv")).click();
		
		//Confirmar en Payment
		driver.findElement(By.xpath("//form[@id='form']/p/button/span")).click();
		
		//Obtener texto
		String ConfirmationText=driver.findElement(By.id("center_column")).getText();
		  
		// Verificar que el producto ha si pedido
		if(ConfirmationText.contains("Pay by bank wire")) {
			System.out.println("Orden completada, prueba satisfactoria");
		}else {
		   System.out.println("Orden no completada: prueba insatisfactoria");
		}
	}	
}
