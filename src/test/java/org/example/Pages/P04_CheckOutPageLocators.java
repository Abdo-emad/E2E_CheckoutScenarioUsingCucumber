package org.example.Pages;

import org.example.StepDefinition.P01_Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P04_CheckOutPageLocators {
    By checkOutBtn = By.xpath("//a[text()='Checkout']");
    By NewAddressRadioButton = By.xpath("//input[@value=\"new\"]");
    By FNameId = By.id("input-payment-firstname");
    By LNameId= By.id("input-payment-lastname");
    By AddressId= By.id("input-payment-address-1");
    By CityId = By.id("input-payment-city");
    By postCodeId = By.id("input-payment-postcode");
    By CountryId = By.id("input-payment-country");
    By StateId = By.id("input-payment-zone");
    By ContinueButton = By.id("button-payment-address");
    By ShippingContinueButton= By.id("button-shipping-address");
    By AddCommentTextArea = By.cssSelector("textarea[name=\"comment\"]");
    By DeliveryMethodContinueButton = By.id("button-shipping-method");
    By TermsAndConditionsCheckBox = By.cssSelector("input[type=\"checkbox\"]");
    By PaymentContinueButton = By.id("button-payment-method");
    By confirmOrderButton = By.id("button-confirm");
    By SuccessOrderMsg= By.cssSelector("div[id='content'] h1");
    By zeroItems= By.cssSelector("div[id='cart'] button");
    public void AccessCheckOutPage(){
        P01_Hooks.Wait(5);
        WebElement element=  P01_Hooks.driver.findElement(checkOutBtn);
       /* Actions actions = new Actions(P01_Hooks.driver);
        actions.moveToElement(element);*/
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)P01_Hooks.driver;
       javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
       P01_Hooks.driver.findElement(checkOutBtn).click();

}

    public void ClickOnNewAddressRadioButton(){
        P01_Hooks.Wait(3);
    P01_Hooks.driver.findElement(NewAddressRadioButton).click();
}
    public void FillBillDetailsForm(String FName , String LName , String Address1,String City,String PostCode,String CountryName,String StateName){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(FNameId).sendKeys(FName);
        P01_Hooks.driver.findElement(LNameId).sendKeys(LName);
        P01_Hooks.driver.findElement(AddressId).sendKeys(Address1);
        P01_Hooks.driver.findElement(CityId).sendKeys(City);
        P01_Hooks.driver.findElement(postCodeId).sendKeys(PostCode);
        P01_Hooks.driver.findElement(CountryId).click();
        WebElement countryDDL = P01_Hooks.driver.findElement(CountryId);
        P01_Hooks.Wait(3);
        Select Countryselect = new Select(countryDDL);
        Countryselect.selectByVisibleText(CountryName);
        P01_Hooks.Wait(5);
        WebElement stateDDL = P01_Hooks.driver.findElement(StateId);
        P01_Hooks.driver.findElement(StateId).click();
        P01_Hooks.Wait(5);
        Select citySelect = new Select(stateDDL);
        citySelect.selectByVisibleText(StateName);
        P01_Hooks.Wait(3);
        WebElement element = P01_Hooks.driver.findElement(ContinueButton);
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)P01_Hooks.driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        P01_Hooks.driver.findElement(ContinueButton).click();
    }
    public void ClickOnShippingContinueButton(){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(ShippingContinueButton).click();
    }
    public void AddComment(String comment){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(AddCommentTextArea).sendKeys(comment);
    }
    public void ClickOnDeliveryMethodContinueButton(){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(DeliveryMethodContinueButton).click();
    }

    public void ClickOnTermsAndConditionsCheckBox(){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(TermsAndConditionsCheckBox).click();
    }
    public void ClickOnPaymentContinueButton(){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(PaymentContinueButton).click();
    }
    public void ClickOnConfirmOrderButton(){
        P01_Hooks.Wait(3);
        P01_Hooks.driver.findElement(confirmOrderButton).click();
    }
    public Boolean IsSuccessMessageDisplayed(){
        P01_Hooks.Wait(3);
      return   P01_Hooks.driver.findElement(SuccessOrderMsg).isDisplayed();
    }

    public Boolean CheckZeroItemsFromSmallCart(){

        WebDriverWait wait = new WebDriverWait(P01_Hooks.driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(zeroItems));
        System.out.println(P01_Hooks.driver.findElement(zeroItems).getText());
        return P01_Hooks.driver.findElement(zeroItems).getText().contains("0 item(s)");
    }

}
