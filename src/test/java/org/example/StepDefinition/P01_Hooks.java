package org.example.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01_Hooks {
    public static WebDriver driver;
    @Before
    public void Setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=common/home");

    }

    @After
    public void Quit(){
        driver.quit();

    }

    public static void Wait(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
}
