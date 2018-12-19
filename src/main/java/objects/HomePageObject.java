package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class HomePageObject extends BasePage {

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[1]/a")
	private WebElement tabWomen;

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[2]/a")
	private WebElement tabDresses;

	@FindBy(xpath = ".//*[@id='block_top_menu']/ul/li[3]/a")
	private WebElement tabTshirt;

	@FindBy(id = "newsletter-input")
	private WebElement txtBoxNewsLetter;

	@FindBy(name = "submitNewsletter")
	private WebElement btnSubmitNewsLetter;

	@FindBy(xpath = "//*[@class='alert alert-success']")
	private WebElement txtAlertSuccess;

	@FindBys(@FindBy(xpath = "//ul[@id='homefeatured']/li"))
	private List<WebElement> lstProduct;

	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}

	public void clickDresses() {
		tabDresses.click();
	}

	public void clickWomen() {
		tabWomen.click();
	}

	public void clickTshirts() {
		tabTshirt.click();
	}

	public WebElement getDresses() {
		return tabDresses;
	}

	public void enterEmailInNewsLetter(String email) {
		setText(email, txtBoxNewsLetter);
		btnSubmitNewsLetter.click();
	}

	public String getAlertMsg() {
		return txtAlertSuccess.getText();
	}

	public List<WebElement> getProducts() {
		return lstProduct;
	}

	public boolean verifyAddtoCartBtn(WebElement parent) {
		return elementFound(parent.findElement(By.xpath(".//a[@title='Add to cart']")));
	}

}
