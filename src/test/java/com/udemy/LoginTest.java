package com.udemy;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Date;


public class LoginTest extends TestBase {


    @Test(description = "Login with valid credential")


    public void LoginWithValidCredentials() {

        Cookie cookie = new Cookie.Builder("dj_session_id", "qe4n7rew89xya6awxyzmfhsdjsamozt6")
                .domain(".udemy.com")
                .expiresOn(new Date(2020, 06, 30))
                .isHttpOnly(true)
                .isSecure(true)
                .path("/")
                .build();


        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get ("https://udemy.com");

        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(siteLoadedLocator));
        WebElement profileLogo = driver.findElement(loggedLogoLocator);

        profileLogo.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(profileNameLocator));
        WebElement profileName = driver.findElement(profileNameLocator);
        Assert.assertEquals(profileName.getText(), "Влад Кузько");

    }

}