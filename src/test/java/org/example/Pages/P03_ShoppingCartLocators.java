package org.example.Pages;

import org.example.StepDefinition.P01_Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class P03_ShoppingCartLocators {
    By CartDiv =By.cssSelector("div[id='cart'] button.btn-inverse");
    By ViewCartButton = By.xpath("//a[normalize-space()='View Cart']");
public void AccessShoppingCart(){
     P01_Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    WebElement button = P01_Hooks.driver.findElement(CartDiv);
    ((JavascriptExecutor) P01_Hooks.driver).executeScript("arguments[0].click();", button);
    P01_Hooks.Wait(3);

    // P01_Hooks.driver.findElement(CartDiv).click();
   /* WebElement ViewButton = P01_Hooks.driver.findElement(CartDiv);
    ((JavascriptExecutor) P01_Hooks.driver).executeScript("arguments[0].scrollIntoView(true);", ViewButton);
*/
    WebElement b = P01_Hooks.driver.findElement(ViewCartButton);
    ((JavascriptExecutor) P01_Hooks.driver).executeScript("arguments[0].click();", b);

    //P01_Hooks.driver.findElement(ViewCartButton).click();
}
}
