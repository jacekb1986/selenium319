package pl.lait.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Klasa:
public class LoginPage {

	//WebDriver- zmienna globalna na koszyk/Przegądarkę:
	
	WebDriver driver; 
	
	@FindBy(linkText = "SIGN-ON")
	WebElement signOnLink;
	
	@FindBy (name = "userName")
	WebElement loginInput;
	
	@FindBy (name = "password")
	WebElement passwdInput;
	
	@FindBy (name = "login")
	WebElement loginBtn;
	
	
	
	
	//Konstruktor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void goToLoginPage() {
		signOnLink.click();
		
		
	}
	public void loginAs(String login, String pass) {
		loginInput.sendKeys(login);
		passwdInput.sendKeys(pass);
		loginBtn.click();
		
	}
	
	
	
	}
	
	



