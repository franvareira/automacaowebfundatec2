package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {

    private WebDriver driver;
    private Waits waits;

    public GenericPage(WebDriver driver){

        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTextTitle(){

        return waits.visbilityOfElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
        //return driver.findElement(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"));
    }

    public WebElement getTextProduto(){

        return waits.visbilityOfElement(By.className("inventory_item_name"));
        //return driver.findElement(By.className("inventory_item_name"));
    }

}
