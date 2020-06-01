package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class RegistrationTest extends TestBase {

    @Test(description = "Registration with valid credential")
    public void RegistrationWithValidCredentials() {

        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get ("https://udemy.com");


        wait.until(ExpectedConditions.elementToBeClickable(regPopupBtnLocator));
        WebElement registrationPopUpBtn = driver.findElement(regPopupBtnLocator);
        registrationPopUpBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(loginFieldLocator));
        WebElement loginField = driver.findElement(loginFieldLocator);
        loginField.clear();
        loginField.sendKeys("Vladyslav Kuzko");

        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.sendKeys("ekhome"+System.currentTimeMillis()+"work16@gmail.com");

        WebElement passField = driver.findElement(passFieldLocator);
        passField.clear();
        passField.sendKeys("qwerty!@#123");


        wait.until(ExpectedConditions.elementToBeClickable(regButtonLocator));
        WebElement regButton = driver.findElement(regButtonLocator);
        regButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileLogoLocator));
        WebElement profileLogo = driver.findElement(profileLogoLocator);

        profileLogo.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileNameLocator));
        WebElement profileName = driver.findElement(profileNameLocator);
        Assert.assertEquals(profileName.getText(), "Vladyslav Kuzko");

    }


    private void pause(int milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}