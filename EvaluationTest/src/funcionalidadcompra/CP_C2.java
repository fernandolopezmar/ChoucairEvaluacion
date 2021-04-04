package funcionalidadcompra;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_C2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String URL = "http://automationpractice.com/index.php";
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/ul/li[2]/ul/li[3]/a")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='center_column']/ul/li[3]/div/div[3]/div/a")));
		
		String ErrorText=driver.findElement(By.xpath("//body[@id='category']/div[2]/div/div/div/div/p")).getText();
		
		// Verificar que la alerta se ha mostrado
		if(ErrorText.contains("manage your wishlist")) {
			System.out.println("Se desplego la alerta, prueba satisfactoria");
		}else {
			System.out.println("No se desplego la alerta, prueba insatisfactoria");
		}
	}
}
