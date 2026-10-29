package Validacao;

import Framework.Utils.FileOperations;
import Framework.Utils.TakeScreenshot;
import PageObjects.CheckoutPage;
import PageObjects.FinishPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutValidacao {

    private WebDriver driver;
    private CheckoutPage checkoutPage;

    public CheckoutValidacao (WebDriver driver){

        this.driver = driver;
        checkoutPage = new CheckoutPage(this.driver);
    }

    public void validaForm(){

        try{
            Assertions.assertFalse(checkoutPage.getFirstNameInput().getAttribute("value").equalsIgnoreCase(" "));
        }catch (Exception e){

            e.getMessage();
        }
    }

    public void validaCamposForm(){
        try{

            String name = FileOperations.getProperties("form").getProperty("primeiroNome");
            String lastName = FileOperations.getProperties("form").getProperty("ultimoNome");
            String zipCode = FileOperations.getProperties("form").getProperty("cep");

            Assertions.assertEquals(name, checkoutPage.getFirstNameInput().getAttribute("value"));
            Assertions.assertEquals(lastName, checkoutPage.getLastNameInput().getAttribute("value"));
            Assertions.assertEquals(zipCode,checkoutPage.getZipCodeInput().getAttribute("value"));
            TakeScreenshot.screenshotPage(driver,"Checkout");
        } catch (Exception e) {

            TakeScreenshot.screenshotPage(driver,"Checkout");
            throw e;
        }



    }
}
