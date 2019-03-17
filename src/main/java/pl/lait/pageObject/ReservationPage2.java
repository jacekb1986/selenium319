package pl.lait.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pl.lait.selenium.Init;

public class ReservationPage2 {

	WebDriver driver;
	
	
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[1]/"
				+ "tbody/tr[3]/td[1]/input")
				WebElement radio_d_1;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[1]/"
				+ "tbody/tr[5]/td[1]/input")
				WebElement radio_d_2;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[1]/"
				+ "tbody/tr[7]/td[1]/input")
				WebElement radio_d_3;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[1]/"
				+ "tbody/tr[9]/td[1]/input")
				WebElement radio_d_4;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[2]/"
				+ "tbody/tr[3]/td[1]/input")
				WebElement radio_r_1;
		
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[2]/"
				+ "tbody/tr[5]/td[1]/input")
				WebElement radio_r_2;
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[2]/"
				+ "tbody/tr[7]/td[1]/input")
				WebElement radio_r_3;
		@FindBy(xpath = "/html/body/div/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[4]/td/table/tbody/tr/"
				+ "td[2]/table/tbody/tr[5]/td/form/table[2]/"
				+ "tbody/tr[9]/td[1]/input")
				WebElement radio_r_4;
		

		
		@FindBy(name = "reserveFlights")
		WebElement reserveFlightsBtn;
		
		
		public ReservationPage2() {
		driver = Init.getDriver();
		PageFactory.initElements(driver, this);		
	}
		/**
		
		 */
		
		
		//----------RESERVATION 3 LEVEL -----------------
		
		@FindBy(name = "passFirt0")
		WebElement passFirst0Input;


		@FindBy(name = "passLast0")
		WebElement passLast0Input;
		
		@FindBy(name = "pass.0.meal")
		WebElement meal0Select;
		
		
		@FindBy(name = "buyFlights")
		WebElement buyFlights;
		
		
		@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img")
		WebElement log0ut;
		
		
		
		
		//----------RESERVATION 3 LEVEL -----------------
		public void selectFlights(int departing, int returning)	{
			switch (departing) {
				case 1:
					radio_d_1.click();
					break;
				case 2:
					radio_d_2.click();
					break;
				case 3:
					radio_d_3.click();
					break;
				case 4:
					radio_d_4.click();
					break;
				default:
					break;
			}
			
			switch (returning) {
				case 1:
				radio_r_1.click();
				break;
				case 2:
				radio_r_2.click();
				break;
				case 3:
				radio_r_3.click();
				break;
				case 4:
				radio_r_4.click();
				break;
				default:
				break;	
			}// end switch
			
		}//end selectFlights()
		
		
		public void submit() {
			reserveFlightsBtn.click();

		
}//end class
			
		/**
		 * meal code: eg KSML (Kosher) 
		 * @param firstName
		 * @param lastName
		 * @param mealCode
		 */
		//-------------------r3 start -----------
		
		public void pass0(String firstName, String lastName, String mealCode) {
			//KSML 
			passFirst0Input.sendKeys(firstName);
			passLast0Input.sendKeys(lastName);
			Select m = new Select(meal0Select);
			m.selectByValue(mealCode);
			
		}
		/**
		 *Buy Flights (3 ekran) 
		 */
		public void submit2() {
			buyFlights.click();
		}
		public void log0ut() {
			log0ut.click();
		}
		//--------------------r3 end ---------
}



