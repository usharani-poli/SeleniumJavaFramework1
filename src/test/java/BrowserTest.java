import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	private static WebDriver driver = null;
	
	/*public static void main(String[] args) {
		String projectLocation = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectLocation+"\\drivers\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//System.setProperty("webdriver.chrome.driver", projectLocation+"\\drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://facebook.com");
		driver.close();
	}*/
	
	@BeforeTest
	public void setupTest() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("opened browser");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get("http://facebook.com");
		System.out.println("title of the page is: " + driver.getTitle());
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
	}
	
}
