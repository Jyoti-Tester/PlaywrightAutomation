package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest {

    public Playwright playwright;
    public Browser browser;
    public Page page;

    @BeforeMethod
    public void setup() {

        playwright = Playwright.create();

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                .setHeadless(false));

        page = browser.newContext().newPage();
    }

    @AfterMethod
    public void tearDown() {

        browser.close();
        playwright.close();
    }
}