package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Isradon {
    WebDriver driver;

    @BeforeTest
    public void initTests() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.isradon.com/");
        System.out.println("Page title: " + driver.getTitle());
        Thread.sleep(3000);
        driver.manage().window().maximize();
    }

    @Test
    public void isradonTabsTitles() throws InterruptedException {
//            driver.findElement(By.className("col1")).click();
//            Thread.sleep(3000);
//            System.out.println("Title: " + driver.findElement(By.tagName("h1")).getText());
//
//            driver.findElement(By.className("withsubs")).click();
//            Thread.sleep(3000);
//            System.out.println("Title: " + driver.findElement(By.tagName("h1")).getText());

//            driver.findElement(By.linkText("Детский мир")).click();
        driver.findElement(By.cssSelector("#menu .only_desktop.nav-main li:nth-child(4)")).click();
            Thread.sleep(3000);

            System.out.println("Title: " + driver.findElement(By.tagName("h1")).getText());

            driver.findElement(By.linkText("CARMANI")).click();
            Thread.sleep(3000);
            System.out.println("Title: " + driver.findElement(By.tagName("h1")).getText());

            driver.findElement(By.linkText("Досуг")).click();
            Thread.sleep(3000);
            System.out.println("Title: " + driver.findElement(By.tagName("h1")).getText());

            driver.findElement(By.linkText("Канцтовары")).click();
            Thread.sleep(3000);
            System.out.println("Title: " + driver.findElement(By.tagName("h1")).getText());

            driver.findElement(By.linkText("Универмаг \"Исрадон\"")).click();
            Thread.sleep(3000);
            System.out.println("Title: " + driver.findElement(By.tagName("h1")).getText());
            driver.quit();
    }

}