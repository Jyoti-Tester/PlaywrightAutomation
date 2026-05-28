package page;
import com.microsoft.playwright.Page;

public class Cart_Page {

    Page page;

    public Cart_Page(Page page) {
        this.page = page;
    }

    private String checkout = "#checkout";
    private String f_name = "#first-name";
    private String l_name = "#last-name";
    private String z_code = "#postal-code";
    private String Ctn_btn = "#continue";
    private String finishbtn = "#finish";
    private String successMsg = "//h2[text()='Thank you for your order!']";

    public void Checkout() {
        page.click(checkout);
    }

    public void Fst_Name(String FirstName) {
        page.fill(f_name, FirstName);
    }

    public void Lst_Name(String LastName) {
        page.fill(l_name, LastName);
    }

    public void Z_Code(String ZipCode) {
        page.fill(z_code, ZipCode);
    }

    public void UserDetails(String FirstName, String LastName, String ZipCode) {

        Fst_Name(FirstName);
        Lst_Name(LastName);
        Z_Code(ZipCode);

        page.click(Ctn_btn);
        page.click(finishbtn);
    }

    public void verifyOrderSuccess() {

        boolean status = page.locator(successMsg).isVisible();

        System.out.println("Order Success Message Visible: " + status);
    }
}