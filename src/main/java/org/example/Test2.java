package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    WebDriver driver;


    public void start() throws InterruptedException {

        System.setProperty(
        "webdriver.chrome.driver",
                "C:\\Users\\jorge\\Documents\\courses\\Selenium\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Thread.sleep(3000);
        driver.findElement(By.id("APjFqb")).sendKeys("javascript");
        //driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        List<WebElement> searchList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        Thread.sleep(5000);
        String expectedTitl = "javascript tutorial";
        for (WebElement element:searchList){
            //element.getText();
//            System.out.println("Element:------------------------------ ");
//            System.out.println(element.getText());
              if(expectedTitl.equals(element.getText())){
                  element.click();
                  break;
              }

        }

        //Thread.sleep(5000);
        //driver.close();
        driver.quit();



    }

    // declare driver

    public static void main(String [] args) throws InterruptedException {

        Test2 t2 = new Test2();
        t2.start();

    }
}
