package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Coursera_page {

    WebDriver driver;
    By first_Course_link = By.xpath("//div//a[@id='cds-react-aria-3-product-card-title']");
    By resourcesLink = By.xpath("//a[contains(text(),'Refer')]");
    public Coursera_page(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnCourseraLink (){

        driver.findElement(resourcesLink).click();
    }

}
