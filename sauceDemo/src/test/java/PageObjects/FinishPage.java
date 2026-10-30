package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishPage {

    private WebDriver driver;
    private Waits waits;

    public FinishPage(WebDriver driver)
    {
      this.driver = driver;
      waits = new Waits(this.driver);
    }

    public WebElement getFinishButton(){

        return driver.findElement(By.id("finish"));
    }

    public WebElement getFinishTextLabel(){

        return driver.findElement(By.className("complete-header"));
    }

    public WebElement getMenuButton(){

        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getMenuLogoutLink(){

        return driver.findElement(By.id("logout_sidebar_link"));
    }




}
