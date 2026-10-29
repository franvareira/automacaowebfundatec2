package Tasks;

import Framework.Browser.Waits;
import PageObjects.CartPage;
import PageObjects.ProdutoPage;
import Validacao.GenericValidacao;
import org.openqa.selenium.WebDriver;

public class ProdutoTask {

    private WebDriver driver;
    private ProdutoPage produtoPage;
    private GenericValidacao genericValidacao;
    private CartPage cartPage;
    private Waits waits;

    public ProdutoTask (WebDriver driver){

        this.driver = driver;
        produtoPage = new ProdutoPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        cartPage = new CartPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void selecionarProduto(){

        produtoPage.getAddToCartButton().click();
        produtoPage.getCartButton().click();
        waits.loadElement(cartPage.getCheckoutButton());
        genericValidacao.validationTitlePages("Your Cart");
        genericValidacao.validationProduto();
        cartPage.getCheckoutButton().click();

    }

}
