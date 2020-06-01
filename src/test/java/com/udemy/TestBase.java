package com.udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;

public class TestBase {


    WebDriver driver;

    // locators for login
    By loggedLogoLocator = By.xpath("//div[@class='dropdown--open-on-hover dropdown--user dropdown--open-on-hover dropdown']");
    By siteLoadedLocator = By.xpath("//img[@class='ufb-logo']");


    // locators for registration
    By regPopupBtnLocator = By.xpath("(//button[@class='btn btn-primary'])[1]");
    By loginFieldLocator = By.id("id_fullname");
    By emailFieldLocator = By.xpath("(//input[@class='form-control'])[3]");
    By passFieldLocator = By.id("password");
    By regButtonLocator = By.id("submit-id-submit");
    By profileLogoLocator = By.xpath("(//div[@class='user-avatar__inner fx-c'])[1]");
    By profileNameLocator = By.xpath("//hgroup[@class='tooltip-container']");


    @BeforeMethod(description = "Open browser")
    public void openBrowser(){

        File chromeDriver = new File("src/main/resources/chromedriver.exe");
        ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeDriver)
                .usingAnyFreePort()
                .build();

        driver = new ChromeDriver(chromeService);

    }


    @AfterMethod(description = "Close browser")
    public void closeBrowser(){

        driver.quit();

    }

}
