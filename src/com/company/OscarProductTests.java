package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class OscarProductTests extends TestBase{
    @Test
    public void addProductToBasketTest(){
        selectBooksCategory();
        Assert.assertTrue(isItBooksPage());
        List<WebElement> productList = driver.findElements(By.className("product_pod"));
        String firstBookName = productList.get(0).findElement(By.tagName("h3")).getText();
        String firstBookPrice = productList.get(0).findElement(By.cssSelector(".product_price .price_color")).getText();
        addToBasketFirstBook();
        Assert.assertTrue(alertsIsPresent());
        List<WebElement> alertsData = driver.findElements(By.cssSelector(".alert strong"));
        Assert.assertTrue(isItBookName(firstBookName, alertsData));
        Assert.assertTrue(isItBookPrice(firstBookPrice, alertsData));
    }

    @Test
    public void countProductInBasketTest(){
        selectBooksCategory();
        addToBasketFirstBook();
//        selectBooksCategorySecondTime();
        driver.navigate().refresh();
        addToBasketFirstBook();
        clickOnViewBasketButton();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement pageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Basket')]")));
        Assert.assertTrue(pageTitle.isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("basket"));
        int count = getProductCountInBasket();
        Assert.assertTrue(count==2);
    }

    private void selectBooksCategorySecondTime() {
        driver.findElement(By.xpath("//strong[contains(text(),'Books')]")).click();
    }

    private int getProductCountInBasket() {
        return Integer.parseInt(driver.findElement(By.id("id_form-0-quantity")).getAttribute("value"));
    }

    private void clickOnViewBasketButton() {
        driver.findElement(By.cssSelector(".btn-group a.btn.btn-default")).click();
    }

    private boolean isItBookPrice(String firstBookPrice, List<WebElement> alertsData) {
        return alertsData.get(2).getText().equals(firstBookPrice);
    }

    private boolean isItBookName(String firstBookName, List<WebElement> alertsData) {
        return alertsData.get(0).getText().equals(firstBookName);
    }

    private boolean alertsIsPresent() {
        return driver.findElements(By.className("alert")).size() == 3;
    }

    private void addToBasketFirstBook() {
        List<WebElement> productList = driver.findElements(By.className("product_pod"));
        productList.get(0).findElement(By.cssSelector("[type=\"submit\"]")).click();
    }

    private boolean isItBooksPage() {
        return driver.findElement(By.className("page-header")).getText().contains("Books");
    }

    private void selectBooksCategory() {
        driver.findElement(By.className("dropdown-submenu")).click();
    }
}
