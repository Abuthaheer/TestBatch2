package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.LoginObject;

public class LoginTests {

	LoginObject lg;

	public LoginTests() {
		lg = new LoginObject();
	}

	@Test
	public void verifyUserName() {
		lg.enterUserName("Abuthaheer");
		String enteredValue = lg.getTxtAttribute(lg.getUserName());
		Assert.assertTrue(enteredValue.equals("Abuthaheer"), "Failed: User Name not entered into the text box");

	}

}
