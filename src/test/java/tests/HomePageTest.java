package tests;

import java.util.List;
import java.util.Random;

import javax.sound.midi.SysexMessage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import objects.DressesPageObject;
import objects.HomePageObject;
import objects.WomenPageObject;

public class HomePageTest {

	HomePageObject hp;
	DressesPageObject dp;
	WomenPageObject wp;

	int value = new Random().nextInt(50000);

	public HomePageTest() {
		hp = new HomePageObject();
		dp = new DressesPageObject();
		wp = new WomenPageObject();
	}

	@Test
	public void verifyTabsNavigation() {
		hp.clickWomen();
		System.out.println(wp.getHeaderText());
		Assert.assertTrue(wp.getHeaderText().trim().equals("WOMEN"), "Failed: Women page not navigated");
		hp.clickDresses();
		Assert.assertTrue(dp.getHeaderText().trim().equals("DRESSES"));

	}

	@Test
	public void verifyNewsLetter() {
		String email = "AbuTestautomation" + value + "@gmail.com";
		hp.enterEmailInNewsLetter(email);
		String alertMessage = hp.getAlertMsg();
		Assert.assertTrue(alertMessage.contains("Newsletter : You have successfully subscribed to this newsletter"),
				"Failed: Subscriptiont is not successfull");
	}

	@Test
	public void verifyProductCount() {
		hp.clickDresses();
		Assert.assertEquals(dp.getProductCount(), dp.getProductCountFromHeader(), "Failed: Count Mismatched");

	}

	@Test
	public void verifyAddToCart() {
		List<WebElement> products = hp.getProducts();

		for (WebElement element : products) {
			hp.mouseHove(element);
			Assert.assertTrue(hp.verifyAddtoCartBtn(element), "Failed: Add to cart button not displayed");

		}
	}

}
