package page;

import com.microsoft.playwright.Page;

public class LoginPage {
	Page page;

	public LoginPage(Page page) {
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

	public void UserName(String username) {
		page.fill(usernameField, username);
	}

	public void Password(String password) {
		page.fill(PasswordField, password);
	}

	public void LoginBtn() {
		page.click(LoginbtnField);
	}

	public void Login(String username, String password) {
		UserName(username);
		Password(password);
		LoginBtn();
		
		 // Verify login successful
	  
	}
}
