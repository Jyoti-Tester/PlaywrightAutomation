package page;

import com.microsoft.playwright.Page;

public class Product_Page {
	Page page;

	public Product_Page(Page page) {
		this.page = page;
	}

	private String item_1 = "#add-to-cart-sauce-labs-backpack";
	private String item_2 = "#add-to-cart-sauce-labs-bike-light";
	private String cartIcon = "#shopping_cart_container";

	public void items() 
	{
		page.click(item_1);
		page.click(item_2);
	}
	
	public void NavigateToCart() {
		page.click(cartIcon);
	}
}
