package Tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.FileOperations;
import PageObjects.CheckoutPage;
import PageObjects.FinishPage;
import Validacao.CheckoutValidacao;
import Validacao.GenericValidacao;
import org.openqa.selenium.WebDriver;

public class CheckoutTask {

    private WebDriver driver;
    private CheckoutPage checkoutPage;
    private GenericValidacao genericValidacao;
    private CheckoutValidacao checkoutValidacao;
    private FakersGeneration fakersGeneration;
    private FinishPage finishPage;

    public CheckoutTask (WebDriver driver){

        this.driver = driver;
        checkoutPage = new CheckoutPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        checkoutValidacao = new CheckoutValidacao(this.driver);
        fakersGeneration = new FakersGeneration();
        finishPage = new FinishPage(this.driver);
    }

    public void preencherCheckout() throws InterruptedException {

        genericValidacao.validationTitlePages("Checkout: Your Information");
        checkoutPage.getFirstNameInput().sendKeys(fakersGeneration.getFisrtName());
        Thread.sleep(1000);
        checkoutPage.getLastNameInput().sendKeys(fakersGeneration.getLastName());
        Thread.sleep(1000);
        checkoutPage.getZipCodeInput().sendKeys(fakersGeneration.getZipCode());
        Thread.sleep(1000);
        checkoutValidacao.validaForm();
        checkoutPage.getContinueButton().click();
        genericValidacao.validationTitlePages("Checkout: Overview");
        genericValidacao.validationProduto();
        finishPage.getFinishButton().click();


    }

    public void preencherCheckout2() throws InterruptedException {

        String name = fakersGeneration.getFisrtName();
        String lastName = fakersGeneration.getLastName();
        String zipCode = fakersGeneration.getZipCode();

        FileOperations.setProperties("form","primeiroNome",name);
        FileOperations.setProperties("form","ultimoNome",lastName);
        FileOperations.setProperties("form","cep",zipCode);

        genericValidacao.validationTitlePages("Checkout: Your Information");
        checkoutPage.getFirstNameInput().sendKeys(name);
        Thread.sleep(1000);
        checkoutPage.getLastNameInput().sendKeys(lastName);
        Thread.sleep(1000);
        checkoutPage.getZipCodeInput().sendKeys(zipCode);
        Thread.sleep(1000);
        checkoutValidacao.validaCamposForm();
        checkoutPage.getContinueButton().click();
        genericValidacao.validationTitlePages("Checkout: Overview");
        genericValidacao.validationProduto();
        finishPage.getFinishButton().click();



    }
}
