package org.example.Pages;

import org.example.StepDefinition.P01_Hooks;
import org.openqa.selenium.By;

public class P01_LoginPageScenarioLocator {
    By accountBtn=  By.xpath("//span[text()='My Account']");
    By loginButton = By.linkText("Login");
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginBtn = By.cssSelector("[value='Login']");
    By logoutButton = By.xpath("(//a[text()='Logout'])[1]");
    public void GoToLoginPage(){
        P01_Hooks.driver.findElement(accountBtn).click();
        P01_Hooks.driver.findElement(loginButton).click();
    }
    public void EnterLoginForm(String email,String pass){
        P01_Hooks.driver.findElement(emailField).sendKeys(email);
        P01_Hooks.driver.findElement(passwordField).sendKeys(pass);
    }
    public void Login(){
        P01_Hooks.driver.findElement(loginBtn).click();
    }
    public void LogOut(){
        P01_Hooks.driver.findElement(accountBtn).click();
        P01_Hooks.driver.findElement(logoutButton).click();
    }

}
