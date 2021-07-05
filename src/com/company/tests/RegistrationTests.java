package com.company.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    String email = "qwe123" + "@gmail.com";
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
        driver.findElement(By.cssSelector(".alertinner.wicon .icon-ok-sign")).isDisplayed();

    }


}
