package funcionalidadregistro;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CP_R4 {
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
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("testfernando999@test.com");
		
		//Click en el botón "Create an account"
		driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
		
		//Ingresar la información personal 
		driver.findElement(By.xpath("//input[@id='id_gender2']"));
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Testers");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Testers");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345");
		Select days = new Select (driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("15");
		Select months = new Select (driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByValue("11");
		Select years = new Select (driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByValue("1985");
		
		//Ingresar la dirección faltando el campo Zip/Postal Code y phone number
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Test company");
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Stree test");
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("Second street test");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Orlando");
		Select state =new Select (driver.findElement(By.xpath("//select[@id='id_state']")));
		state.selectByVisibleText("Florida");
		Select country =new Select (driver.findElement(By.xpath("//select[@id='id_country']")));
		state.selectByValue("2");
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("\"Neque error porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...\"");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("Test");
		
		//Dar click en el botón "Register"
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		
		//Verificar si se muestra el mensaje de error
		try {
			driver.findElement(By.xpath("//div[@id='center_column']/div/ol"));
			System.out.println("Se muestra el mensaje de error, prueba satisfactoria");
		}catch (NoSuchElementException e){
			System.out.println("No se muestra el mensaje de error, prueba insatisfactoria");
		}
	}

}
