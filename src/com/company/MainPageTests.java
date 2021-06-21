package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase{
    @Test
    public void changeLanguageTest(){
        Select langDropDown = new Select(driver.findElement(By.name("language")));
        langDropDown.selectByValue("ru");
        WebElement submitLangButton = driver.findElement(By.cssSelector("[data-loading-text=\"Submitting...\"]"));
        submitLangButton.click();

        WebElement basketButton = driver.findElement(By.className("btn-group"));
        String text = basketButton.getText();
        Assert.assertEquals(text, "Посмотреть корзину");
    }
}
