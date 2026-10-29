package Validacao;

import Framework.Utils.TakeScreenshot;
import PageObjects.GenericPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericValidacao {

    private WebDriver driver;
    private GenericPage genericPage;

    public GenericValidacao (WebDriver driver)
    {
        this.driver = driver;
        genericPage = new GenericPage(this.driver);
    }

    public void validationTitlePages(String texto){

        try {
           String label = genericPage.getTextTitle().getText();
            Assertions.assertEquals(texto,label);
            //TakeScreenshot.screenshotPage(driver,texto);
        } catch (Exception e) {
            //TakeScreenshot.screenshotPage(driver,texto);
            throw e;
        }

    }

    public void validationProduto(){

        try {
            String labelProduto = genericPage.getTextProduto().getText();
            Assertions.assertEquals("Sauce Labs Onesie",labelProduto);
            TakeScreenshot.screenshotPage(driver,"Selecionar Produto");
        } catch (Exception e) {
            TakeScreenshot.screenshotPage(driver,"Selecionar Produto");
            throw e;
        }
    }


}
