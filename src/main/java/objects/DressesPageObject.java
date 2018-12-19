package objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DressesPageObject extends BasePage {

	@FindBy(xpath = "//span[@class='cat-name']")
	private WebElement txtProductHeader;

	@FindBy(xpath = ".//*[@class='heading-counter']")
	private WebElement txtProductHeaderCount;

	@FindBys(@FindBy(xpath = ".//*[@class='product_list grid row']/li"))
	List<WebElement> lstProducts;

	@FindBy(id = "selectProductSort")
	private WebElement dropDownSort;

	@FindBys(@FindBy(xpath = "//*[@class='right-block']//*[@class='price product-price']"))
	private List<WebElement> lstPrices;

	@FindBy(id = "layered_ajax_loader")
	private WebElement loadingIcon;

	@FindBy(id = "list")
	private WebElement lstGrid;

	@FindBys(@FindBy(xpath = ".//*[@class='product_list row list']/li"))
	List<WebElement> lstProductGrid;

	public DressesPageObject() {
		PageFactory.initElements(driver, this);
	}

	public String getHeaderText() {
		return txtProductHeader.getText();
	}

	public int getProductCount() {
		return lstProducts.size();
	}

	public int getProductCountFromHeader() {
		/*
		 * String text = txtProductHeaderCount.getText(); String[] arr =
		 * text.split(" "); int value = Integer.parseInt(arr[2]); return value;
		 */
		return Integer.parseInt(txtProductHeaderCount.getText().split(" ")[2]);
	}

	public void selectSortBy(String options) {
		selectFromDropDown(dropDownSort, options);
	}

	public ArrayList<Double> getProductPrices() {
		ArrayList<Double> list = new ArrayList<Double>();
		isElementVisible(loadingIcon);
		isElementInVisible(loadingIcon);
		for (WebElement e : lstPrices) {
			String text = e.getText();
			text = text.replace("$", "").trim();
			double value = Double.parseDouble(text);
			list.add(value);
		}
		return list;
	}

	public void clickListGrid() {
		lstGrid.click();
	}

	public List<WebElement> getGridProducts() {
		return lstProductGrid;
	}

	public boolean verifyDiscountPrice(WebElement parent) {
		return elementFound(parent.findElement(
				By.xpath("//div[contains(@class,'right-block')]//span[@class='price-percent-reduction']")));
	}

	public boolean verifyReducedPrice(WebElement parent) {
		return elementFound(parent.findElement(By.xpath("//div[contains(@class,'center')]//span[@class='discount']")));
	}

}
