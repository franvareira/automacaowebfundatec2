package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutoPage {

    private WebDriver driver;
    private Waits waits;

    public ProdutoPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getAddToCartButton(){

        waits.visbilityOfElement(By.id("add-to-cart-sauce-labs-onesie"));
        return driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
    }

    public WebElement getCartButton(){

        return driver.findElement(By.className("shopping_cart_link"));

    }
}
