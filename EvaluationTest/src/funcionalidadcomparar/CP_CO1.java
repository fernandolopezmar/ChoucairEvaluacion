package funcionalidadcomparar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP_CO1 {
	

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\browserdrivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		String URL = "http://automationpractice.com/index.php";
		
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		//Adicionar el vestido para comparar
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li/ul/li[2]/ul/li[3]/a")));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@id='center_column']/ul/li[2]/div/div[3]/div[2]/a")));
		
		//Se obtiene el nombre del vestido seleccionado
		String dress = driver.findElement(By.xpath("//div[@id='center_column']/ul/li[2]/div/div[2]/h5/a")).getText();
		
		//Se ingresa ala sección compare
		driver.findElement(By.xpath("//div[@id='center_column']/div[3]/div/form/button/span")).click();
		
		//Se obtiene el texto de la tabla de comparación
		String compareDress = driver.findElement(By.xpath("//table[@id='product_comparison']/tbody/tr/td[2]")).getText();
		
		// Verificar que el vestido seleccionado para comparar se encuentre en la sección de comparar
		if(compareDress.contains(dress)) {
			System.out.println("Se adiciono el vestido a la sección Compare, prueba satisfactoria");
		}else {
			System.out.println("No se adiciono el vestido a la sección Compare, prueba insatisfactoria");
		}
	}
}
