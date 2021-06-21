package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;

public class OscarShopTests extends TestBase{
    String email = "qwe" + System.currentTimeMillis() + "@gmail.com";
    String password = "Qwe123123";

    @Test(priority = 1)
    public void registrationTest() {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.id("id_registration-email"));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id("id_registration-password1"));
        passwordField.sendKeys(password);
        WebElement confirmPasswordField = driver.findElement(By.id("id_registration-password2"));
        confirmPasswordField.sendKeys(password);
        WebElement registerButton = driver.findElement(By.name("registration_submit"));
        registerButton.click();

    }

    @Test(priority = 2, dependsOnMethods = "registrationTest")
    public void loginTest() throws InterruptedException {
        WebElement loginLink = driver.findElement(By.id("login_link"));
        loginLink.click();
        WebElement loginEmailField = driver.findElement(By.xpath("//input[@id='id_login-username']"));
        loginEmailField.sendKeys(email);
        WebElement loginPasswordField = driver.findElement(By.id("id_login-password"));
        loginPasswordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log In')]"));
        loginButton.click();
        Thread.sleep(5000);
        loginButton.isDisplayed();

    }


}
