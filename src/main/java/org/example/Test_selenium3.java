package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test_selenium3{

    WebDriver driver;
    WebElement my_result;
    //By coursera_link = new By.ByXPath("//a[@href='https://www.coursera.org/courses?query=javascript']");

    Coursera_page courseraPageObject;

    public Test_selenium3(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\jorge\\Documents\\courses\\Selenium\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    public void start() throws InterruptedException {

        System.out.println("before wait");

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(20));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#id")));

        System.out.println("after wait");
        driver.get("https://www.google.com");
        driver.manage().window().maximize();


        Thread.sleep(3000);
        driver.findElement(By.id("APjFqb")).sendKeys("javascript");
        Thread.sleep(3000);
        List<WebElement> searchList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
        String searching = "javascript tutorial";
        for (WebElement item:searchList){
            System.out.println(item.getText());
            if(searching.equals(item.getText())){
                System.out.println(item.getText());
                item.click();
                break;

            }// if
        }// for
        //Thread.sleep(1000);





        //driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);


        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.coursera.org/courses?query=javascript']")));

        Thread.sleep(3000);
        List<WebElement> searchedItems = driver.findElements(By.xpath("//a[@jsname='UWckNb']"));
        int count = 0;
        for (WebElement item:searchedItems){
            System.out.println("element ------------------");
            System.out.println(item.getText());
            if(count==7){
                item.click();
                break;
            }count++;
        }

        driver.findElement(By.xpath("//*[contains(text(),'Node.js')]")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        courseraPageObject = new Coursera_page(driver);
        //courseraPageObject.clickOnCourseraLink();

//
//        for (WebElement listed_element: search_results){
//            System.out.println("Element ---------------------");
//            System.out.println(listed_element.getText());
//        }



        Thread.sleep(3000);
        driver.quit();
    }
    public static void main (String [] args) throws InterruptedException {
        Test_selenium3 ft = new Test_selenium3();
        ft.start();
    }
}