package test;

import org.testng.annotations.Test;

import base.BaseTest;
import page.Cart_Page;
import page.LoginPage;
import page.Product_Page;
import utils.ConfigReader;

public class SauceLabs extends BaseTest {
	@Test
	public void verifyValidLogin() {

        ConfigReader config = new ConfigReader();

        LoginPage loginPage = new LoginPage(page);

        loginPage.navigateTo(config.getUrl());

        loginPage.Login(
                config.getUsername(),
                config.getPassword());
		
		Product_Page productPage = new Product_Page(page);
		productPage.items();
		productPage.NavigateToCart();
		
		Cart_Page details = new Cart_Page(page);
		details.Checkout();
		details.UserDetails("Tester", "A", "5600");
		
	}

}
