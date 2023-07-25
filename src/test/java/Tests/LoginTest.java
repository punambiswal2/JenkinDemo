package Tests;

import Library.TestBase;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest  extends TestBase {
    @Test
    public void loginTestWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123",true,null);
    }

    @Test
    public void loginTestWithInValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("sumo", "blahblah", false,"Invalid credentials");
    }
}
