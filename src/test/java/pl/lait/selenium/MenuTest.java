package pl.lait.selenium;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) // Do ustawiania kolejności testu
@Ignore

public class MenuTest {

	WebDriver driver;

	// Własny framework (metoda) ułatwiający pracę przy kolejnych powtarzalnych
	// czynnościach:
	public void linkClick(String linkText) {
		Init.log("Klikam w link: " + linkText);
		driver.findElement(By.linkText(linkText)).click();
	}

	// Test - czy klika w dany element? czy wartości się zgadzają (przy aktualizacji
	// danych!!!);
	public void radioClick(String xpath) {
		Init.log("Klikam w element z xpath: " + xpath);
		driver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * Select - nazwa i Select - wartość Metoda wyszukuje element typu SELECT i
	 * wybiera wartość jako visible text
	 */
	public void selectByText(String name, String txt) {
		WebElement tmpWebElem = driver.findElement(By.name(name));
		Select tmpSelect = new Select(tmpWebElem);
		tmpSelect.selectByVisibleText(txt);
	}

	@Before
	public void bifor() {
		// otwieramy przeglądarkę przed testem
		Init.log("Otwieram okno przeglądarki");
		driver = Init.getDriver();
	}
	// żeby test mógł się uruchomić musi być fraza "@Test"

	@Test
	public void topMenu() {
		linkClick("CONTACT");
		driver.findElement(By.linkText("CONTACT")).click();
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
		Init.log(driver.getTitle());

		Init.sleep(3);

	}

	@Test
	public void leftMenu() {
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Flights")).click();
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.linkText("Car Rentals")).click();
		driver.findElement(By.linkText("Cruises")).click();
		driver.findElement(By.linkText("Destinations")).click();
		driver.findElement(By.linkText("Vacations")).click();

		Init.sleep(5);
	}
	@Ignore
	@Test
	public void loginAndReservationLevel1() {
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys("Bielik88");
		driver.findElement(By.name("password")).sendKeys("wercia9");
		driver.findElement(By.name("login")).click();

		String oneWayXpath = "html/body/div/table/tbody/tr/td[2]/table/"
				+ "tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/"
				+ "tbody/tr[2]/td[2]/b/font/input[2]";

		driver.findElement(By.xpath(oneWayXpath)).click();
		
		WebElement passCountWebElem = driver.findElement(By.name("passCount"));
		Select passCountSelect = new Select(passCountWebElem);
		passCountSelect.selectByVisibleText("2");

		Select fromPortSelect = new Select(driver.findElement(By.name("fromPort")));
		fromPortSelect.selectByVisibleText("Acapulco");
		Select fromMonth = new Select(driver.findElement(By.name("fromMonth")));
		fromMonth.selectByValue("3");
		Select fromDay = new Select(driver.findElement(By.name("fromDay")));
		fromDay.selectByValue("15");

		Select toPortSelect = new Select(driver.findElement(By.name("toPort")));
		toPortSelect.selectByVisibleText("Sydney");
		Select toMonth = new Select(driver.findElement(By.name("toMonth")));
		toMonth.selectByValue("4");
		Select toDay = new Select(driver.findElement(By.name("toDay")));
		toDay.selectByValue("18");

		String eco = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/input";
		String biz = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]";
		String fir = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[2]";
		radioClick(fir);
		radioClick(biz);
		radioClick(eco);
		radioClick(fir);
		selectByText("airline", "Blue Skies Airlines");
		Init.sleep(3);

		driver.findElement(By.name("findFlights")).click();
		
		

		/*
		 * Po wyciągnięciu XPath z F12; name; prawy przycisk myszy - Copy: CopyXpath:
		 * html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/
		 * table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]
		 */
	}

	@After
	public void awter() {
		// tu trzeba zamknąć przeglądarkę
		Init.close();

	}

}
