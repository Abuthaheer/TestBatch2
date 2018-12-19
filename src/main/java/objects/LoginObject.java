package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginObject extends BasePage {

	@FindBy(id = "username")
	private WebElement userName;
	
	@FindBy(id = "password")
	private WebElement passWord;
	
	@FindBy(id = "login")
	private WebElement btnLogin;
	
	@FindBys(@FindBy(xpath = ""))
	private List<WebElement> all;
	
	public LoginObject(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUserName(String name){
		userName.sendKeys(name);
	}
	
	public WebElement getUserName(){
		return userName;
	}
	
	
}
