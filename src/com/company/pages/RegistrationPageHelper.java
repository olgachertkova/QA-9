package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageHelper extends PageBase{
    public RegistrationPageHelper(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementVisible(driver.findElement(By.id("content_inner")), 30);
    }

    public void fillEmailField(String email) {
        WebElement emailField = driver.findElement(By.id("id_registration-email"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        WebElement passwordField = driver.findElement(By.id("id_registration-password1"));
        passwordField.sendKeys(password);
    }

    public void fillConfirmPasswordField(String password) {
        WebElement confirmPasswordField = driver.findElement(By.id("id_registration-password2"));
        confirmPasswordField.sendKeys(password);
    }

    public void clickOnRegisterButton() {
        WebElement registerButton = driver.findElement(By.name("registration_submit"));
        registerButton.click();
    }
}
