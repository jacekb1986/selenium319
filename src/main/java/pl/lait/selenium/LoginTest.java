package pl.lait.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pl.lait.pageObject.LoginPage;
import pl.lait.pageObject.ReservationPage;
import pl.lait.pageObject.ReservationPage2;

public class LoginTest {

	WebDriver driver;
	
	@Before
	public void bifor( ) {
		driver = Init.getDriver();
	}
	
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("Bielik88", "wercia9");
		
	}

	@Test
	public void reserveTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToLoginPage();
		lp.loginAs("Bielik88", "wercia9");
	
		ReservationPage rp = new ReservationPage();
		rp.from( "Frankfurt","3", "16");
		rp.to( "Frankfurt","3", "20");
		rp.passCount("2");
		rp.firstClass();
		rp.submit();
		//2gi etap
		ReservationPage2 rp2 = new ReservationPage2();
		rp2.selectFlights(2, 4);
		rp2.submit();
		//3 etap
		rp2.pass0("Weonika", "aaaaa", "KSML");
		
	}
	@After
	public void awter() {
		// tu trzeba zamknąć przeglądarkę
		Init.close();
}
	
	
}

