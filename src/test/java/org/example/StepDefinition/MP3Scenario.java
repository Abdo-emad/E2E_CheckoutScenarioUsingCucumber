package org.example.StepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P01_LoginPageScenarioLocator;
import org.example.Pages.P02_AddProductToCartLocators;
import org.example.Pages.P03_ShoppingCartLocators;
import org.example.Pages.P04_CheckOutPageLocators;
import org.junit.Assert;

public class MP3Scenario {
    P01_LoginPageScenarioLocator loginPageScenarioLocator;
    P02_AddProductToCartLocators p02AddProductToCartLocators;
    P03_ShoppingCartLocators p03ShoppingCartLocators;
    P04_CheckOutPageLocators p04CheckOutPageLocators;
    @Given("the user navigates to the login page")
    public void AccessLoginPage(){
        loginPageScenarioLocator= new P01_LoginPageScenarioLocator();
        loginPageScenarioLocator.GoToLoginPage();
    }
    @When("^user enter valid \"(.*)\" and \"(.*)\" then login$")
    public void SetLoginForm(String email,String pass){
        loginPageScenarioLocator.EnterLoginForm(email,pass);
        loginPageScenarioLocator.Login();
    }
    @Given("^the user accesses the \"(.*)\" page$")
    public void MP3PlayerAccessPage(String CategoryName) {
        p02AddProductToCartLocators= new P02_AddProductToCartLocators();
        p02AddProductToCartLocators.AccessMP3PlayersPage(CategoryName);
    }
    @When("^the user adds \"(.*)\" to the cart$")
    public void AddItemToCart(String productName) {
        p02AddProductToCartLocators.loopOnProductsList(productName);
    }
    @Then("^a success message 'Success: You have added \"(.*)\" to your shopping cart!' is displayed$")
    public void ValidateSuccessMsg(){
        Assert.assertTrue(p02AddProductToCartLocators.IsIpodShuffleSuccessMsgDisplayed());
    }
    @And("the user opens the shopping cart and proceeds to the checkout page")
    public void OpenShoppingCart(){
    p03ShoppingCartLocators = new P03_ShoppingCartLocators();
    p03ShoppingCartLocators.AccessShoppingCart();
        p04CheckOutPageLocators= new P04_CheckOutPageLocators();
        p04CheckOutPageLocators.AccessCheckOutPage();
    }
   @And("the user fills in the billing details with a new address")
    public void Fill_billing_details_by_new_address(){
        p04CheckOutPageLocators.ClickOnNewAddressRadioButton();
        p04CheckOutPageLocators.FillBillDetailsForm("Test"+System.currentTimeMillis(),"Test"+System.currentTimeMillis(),"Cairo","Al Fayyum","868686"+System.currentTimeMillis(),"Egypt","Al Fayyum");
   }
   @And("^user continue shipping then Adding \"(.*)\"$")
    public void ClickOnShippingContinueButton(String comment){
        p04CheckOutPageLocators.ClickOnShippingContinueButton();
       p04CheckOutPageLocators.AddComment(comment+System.currentTimeMillis());
   }
   @And("the user proceeds with the delivery method and accepts the 'Terms & Conditions'")
    public void ClickOnoDeliveryMethodContinueButton(){
        p04CheckOutPageLocators.ClickOnDeliveryMethodContinueButton();
       p04CheckOutPageLocators.ClickOnTermsAndConditionsCheckBox();
   }

   @And("user continue payment and confirm order")
    public void ClickOnPaymentContinueButton(){
        p04CheckOutPageLocators.ClickOnPaymentContinueButton();
       p04CheckOutPageLocators.ClickOnConfirmOrderButton();
   }

   @Then("the message 'Your order has been placed!' is displayed")
    public void IsOrderDisplayedDisplayed(){
        Assert.assertTrue(p04CheckOutPageLocators.IsSuccessMessageDisplayed());

   }
   @And("the shopping cart is now empty")
    public void CheckZeroItemsFoundInSmallShoppingCart(){
       Assert.assertTrue(p04CheckOutPageLocators.CheckZeroItemsFromSmallCart());
   }
   @And("user Log out successfully")
    public void Logout(){
        loginPageScenarioLocator.LogOut();
   }


}
