package pl.lait.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {

	static WebDriver driver;// typ zmiennej globalnej WebDriver, zmienna obiektowa driver//

	public static WebDriver getDriver() {
		// "C:\\Users\\Jacenty\\chromeDriver\\chromedriver.exe"

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jacenty\\chromeDriver\\chromedriver.exe");
		if(driver==null) {
			driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			return driver;
		} else {
			return driver;
		}
	}

	public static void log(String msg) {
		System.out.println("---" + msg + "---");
	}

	public static void close() {
		driver.close();
		driver.quit();
		driver = null;
		
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
