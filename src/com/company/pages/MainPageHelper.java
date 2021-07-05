package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPageHelper extends PageBase{
    WebElement basketButton = driver.findElement(By.className("btn-group"));
    WebElement submitLangButton = driver.findElement(By.cssSelector("button.btn.btn-default[type=\"submit\"]"));
    WebElement langButton = driver.findElement(By.name("language"));

    public MainPageHelper(WebDriver driver) {
        super(driver);
    }

    public String getViewBasketButtonText() {
        String text = basketButton.getText();
        return text;
    }

    public void clickOnGoButton() {
        submitLangButton.click();
    }

    public void selectLanguage(String lang) {
        Select langDropDown = new Select(langButton);
        langDropDown.selectByValue(lang);
    }

    public void waitUntilTextChanged() {
        waitUntilElementContainsText("Выполнить", submitLangButton, 20);
    }

    public void selectBooksCategory() {
        driver.findElement(By.className("dropdown-submenu")).click();
    }
}
