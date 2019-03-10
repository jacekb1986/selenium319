package pl.lait.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuTest {

	WebDriver driver;

	@Before
	public void bifor() {
		// otwieramy przeglądarkę przed testem
		Init.log("Otwieram okno przeglądarki");
		driver = Init.getDriver();
	}
	// żeby test mógł się uruchomić musi być fraza "@Test"

	@Test
	public void topMenu() {
		Init.log("Klikam w link CONTACT");
		driver.findElement(By.linkText("CONTACT")).click();
		Init.log("Klikam Support");
		driver.findElement(By.linkText("SUPPORT")).click();
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.linkText("SIGN-ON")).click();
		Init.log(driver.getTitle());

	}

	@After
	public void awter() {
		// tu trzeba zamknąć przeglądarkę
		Init.close();

	}

}
