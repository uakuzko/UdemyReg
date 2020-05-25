package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class RegistrationTest {

    @Test(description = "Registration with valid credential")
    public void RegistrationWithValidCredentials() {
        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        WebDriver driver = new ChromeDriver(chromeService);

        driver.get ("https://udemy.com");

        pause(4000);

        WebElement RegistrationPopUpBtn = driver.findElement(
                By.xpath("(//button[@class='btn btn-primary'])[1]"));

        RegistrationPopUpBtn.click();

        pause(4000);

        WebElement LoginField = driver.findElement(By.id("id_fullname"));
        LoginField.clear();
        LoginField.sendKeys("Vladyslav Kuzko");

        WebElement EmailField = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
        EmailField.clear();
        EmailField.sendKeys("ekhome"+System.currentTimeMillis()+"work16@gmail.com");

        WebElement PassField = driver.findElement(By.id("password"));
        PassField.clear();
        PassField.sendKeys("qwerty!@#123");

        WebElement RegButton = driver.findElement(By.id("submit-id-submit"));
        RegButton.click();

        pause(4000);

        WebElement ProfileLogo = driver.findElement(By.xpath("(//div[@class='user-avatar__inner fx-c'])[1]"));

        pause(2000);

        ProfileLogo.click();

        pause(4000);

        WebElement profileName = driver.findElement(By.xpath("//hgroup[@class='tooltip-container']"));
        Assert.assertEquals(profileName.getText(), "Vladyslav Kuzko");

        driver.quit();

    }


    private void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }

}