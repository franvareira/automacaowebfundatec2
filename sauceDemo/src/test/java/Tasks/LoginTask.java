package Tasks;

import Framework.Utils.FileOperations;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTask {

    private static final Logger log = LoggerFactory.getLogger(LoginTask.class);
    private WebDriver driver;
    private LoginPage loginPage;

    public LoginTask (WebDriver driver){

        this.driver = driver;
        loginPage = new LoginPage(this.driver);
    }

    public void efetuarLogin() throws InterruptedException {

        loginPage.getUserNameInput().sendKeys(FileOperations.getProperties("user").getProperty("usuario"));
        Thread.sleep(5000);
        loginPage.getPasswordInput().sendKeys(FileOperations.getProperties("user").getProperty("password"));
        Thread.sleep(5000);
        loginPage.getLoginButton().click();

    }
}
