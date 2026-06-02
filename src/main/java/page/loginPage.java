package page;

import com.microsoft.playwright.Page;

public class loginPage {
	Page page;

	public loginPage(Page page) {
		this.page = page;
	}

	private String usernameField = "#user-name";
	private String PasswordField = "#password";
	private String LoginbtnField = "#login-button";
	// private String ErrorMsg = "#//h3[text()='Epic sadface: Username and password
	// do not match any user in this service']";

	public void navigateTo(String url) {
		page.navigate(url);
	}

	public void userName(String username) {
		page.fill(usernameField, username);
	}

	public void password(String password) {
		page.fill(PasswordField, password);
	}

	public void loginBtn() {
		page.click(LoginbtnField);
	}

	public void login(String username, String password) {
		userName(username);
		password(password);
		loginBtn();
		
		 // Verify login successful
	  
	}
}
