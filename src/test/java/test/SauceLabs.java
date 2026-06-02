package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import page.cart_Page;
import page.loginPage;
import page.product_Page;
import utils.ConfigReader;

public class SauceLabs extends BaseTest {
	@Test
	public void verifyCompleteOrderFlow() {

        ConfigReader config = new ConfigReader();

        loginPage loginPage = new loginPage(page);

        loginPage.navigateTo(config.getUrl());

        loginPage.login(
                config.getUsername(),
                config.getPassword());
        Assert.assertTrue(page.url().contains("inventory"),"Login Failed!");
		
        //Add items to cart
		product_Page productPage = new product_Page(page);
		productPage.items();
		productPage.navigateToCart();
		
		//checkout
		cart_Page details = new cart_Page(page);
		details.checkout();
		details.userDetails("Tester", "A", "5600");
		
		//Verify order success
		details.verifyOrderSuccess();
		
		Assert.assertTrue(page.locator(".complete-header").isVisible(),"order failed");
		System.out.println("Complete order flow passed!");
	}

}
