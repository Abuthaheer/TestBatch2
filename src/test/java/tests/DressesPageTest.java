package tests;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.DressesPageObject;
import objects.HomePageObject;
import objects.WomenPageObject;

public class DressesPageTest {

	HomePageObject hp;
	DressesPageObject dp;

	public DressesPageTest() {
		hp = new HomePageObject();
		dp = new DressesPageObject();

	}
	
	
	@Test
	public void verifyPriceInAscendingOrder(){
		hp.clickDresses();
		dp.selectSortBy("price:asc");
		ArrayList<Double> prices = dp.getProductPrices();
		for(Double d : prices){
			System.out.println(d);
		}
		
		for(int i = 0; i<prices.size()-1; i++){
			Assert.assertTrue(prices.get(i) < prices.get(i + 1), "Failed: Not in Order");
		}
		
	}
	
	
	@Test
	public void verifyDiscountPrice(){
		hp.clickDresses();
		dp.clickListGrid();
		List<WebElement> products = dp.getGridProducts();
		
		for(WebElement e: products){
			if (dp.verifyDiscountPrice(e)) {
				Assert.assertTrue(dp.verifyReducedPrice(e));
			}
		}
	}
	
	
	

}
