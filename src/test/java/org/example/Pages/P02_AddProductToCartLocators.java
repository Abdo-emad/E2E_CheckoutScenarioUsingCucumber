package org.example.Pages;

import org.example.StepDefinition.P01_Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class P02_AddProductToCartLocators {
    public By CategoryName(String categoryName){
        return By.xpath("//a[text()='"+categoryName+"']");
    }
    By MP3_PlayersElement = By.xpath("//li[@class='dropdown']/a[text()='MP3 Players']");
    By ShowAllMP3Players= By.xpath("//div[@class='dropdown-menu']/a[text()='Show All MP3 Players']");
    By Mp3Products = By.cssSelector(".product-layout");
    By IpodShuffleSuccessMsg = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public void AccessMP3PlayersPage(String categoryName){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(CategoryName(categoryName)).click();
      //  P01_Hooks.driver.findElement(MP3_PlayersElement).click();
        P01_Hooks.driver.findElement(ShowAllMP3Players).click();
    }

    public void loopOnProductsList(String ProductTextName){
        List<WebElement> products = P01_Hooks.driver.findElements(Mp3Products);
        P01_Hooks.Wait(3);
        for (int i=0;i<products.size();i++){
            String ProductsName= P01_Hooks.driver.findElements(By.cssSelector("div h4")).get(i).getText();
            if (ProductsName.equalsIgnoreCase(ProductTextName)){
                P01_Hooks.driver.findElements(By.xpath("//div[@class=\"button-group\"]/button/span[text()='Add to Cart']")).get(i).click();
                break;
            }
        }
    }
    public Boolean IsIpodShuffleSuccessMsgDisplayed(){
        P01_Hooks.Wait(8);
       return P01_Hooks.driver.findElement(IpodShuffleSuccessMsg).isDisplayed();
    }
}
