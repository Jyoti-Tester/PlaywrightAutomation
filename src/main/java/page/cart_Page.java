package page;
import com.microsoft.playwright.Page;

public class cart_Page {

    Page page;

    public cart_Page(Page page) {
        this.page = page;
    }

    private String checkout = "#checkout";
    private String f_name = "#first-name";
    private String l_name = "#last-name";
    private String z_code = "#postal-code";
    private String Ctn_btn = "#continue";
    private String finishbtn = "#finish";
    //private String successMsg = "//h2[text()='Thank you for your order!']";
    private String successMsg = ".complete-header";
    public void checkout() {
        page.click(checkout);
    }

    public void fst_Name(String FirstName) {
        page.fill(f_name, FirstName);
    }

    public void lst_Name(String LastName) {
        page.fill(l_name, LastName);
    }

    public void z_Code(String ZipCode) {
        page.fill(z_code, ZipCode);
    }

    public void userDetails(String FirstName, String LastName, String ZipCode) {

        fst_Name(FirstName);
        lst_Name(LastName);
        z_Code(ZipCode);

        page.click(Ctn_btn);
        page.click(finishbtn);
    }

    public void verifyOrderSuccess() {

        boolean status = page.locator(successMsg).isVisible();

        System.out.println("Order Success Message Visible: " + status);
    }
}