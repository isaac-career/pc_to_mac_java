package org.example;

// Importing required classes
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

// Class
public class Main {
    ChromeDriver driver;
    By search_box = By.xpath("//textarea[@id='APjFqb']");

    public Main (){
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\jorge\\Documents\\courses\\Selenium\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
    }


    public void start_search() throws InterruptedException {
        driver.manage().window().maximize();

        // Launching website
        driver.get("https://www.google.com.mx/");
        Thread.sleep(3000);
        //System.out.println(""+uno);

        driver.findElement(search_box);
        driver.findElement(search_box).sendKeys("pedir cafe en linea");
        driver.findElement(search_box).sendKeys(Keys.RETURN);

       /* WebElement select = driver.findElement(By.xpath("//a[@jsname='UWckNb']"));
        List options = select.findElements(By.tagName(«option»));
        for (WebElement option : options) {
            System.out.println(option.getText())
        }*/
        Thread.sleep(5000);

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "")));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        List <WebElement> myList = driver.findElements(By.xpath("//a[@href='https://www.ubereats.com/mx/near-me/cafe']"));

        for(WebElement element: myList){
            String pageText = element.getText();
            boolean cafeFlor = pageText.contains("Cafe a domicilio cerca de m");
            System.out.println(cafeFlor);
            if(cafeFlor){
                element.click();
                break;
            }
            System.out.println("-------- elemento -----------");
            //if(element.getText().equals(""))
        }

        //WebElement orderButton = driver.findElement(By.cssSelector(".d-md-flex"));
        //orderButton.click();






        Thread.sleep(5000);
        //driver.quit();

    }

    // Main driver method
    public static void main(String[] args) throws InterruptedException {

        Main mm = new Main();
        mm.start_search();

       /* System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\jorge\\Documents\\courses\\Selenium\\chromedriver-win64\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();*/


    }
}
