package Assessment;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Cases_010 {
    WebDriver driver;
    By find_branch_btn;
    By zip_field;

    By login_btn = By.id("nav-login-lock");
    By map_box = By.id("gmap");
    By banking_btn = By.xpath("//a[@data-target='Banking']");
    HomePage homePage; LocationPage locationPage;


    @BeforeClass
    public void init() throws InterruptedException {

        zip_field = By.id("q");



        System.setProperty("webdriver.gecko.driver"
                , "C:\\Users\\jorge\\Documents\\courses\\Selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        homePage = new HomePage(driver);
        locationPage = new LocationPage(driver);


        driver.get("https://www.santanderbank.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }

    @Test
    public void All_element_presents() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(3000);
        // scroll down
        homePage.click_find_branch_btn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        Thread.sleep(3000);


        Assert.assertTrue(locationPage.all_elements_showed());

    }

    @Test
    public void search_branch() throws InterruptedException {

        Thread.sleep(3000);
        WebElement logo_home = driver.findElement(By.xpath("//*[@id='rnav-l01']/div[1]/a"));
        System.out.println(logo_home.getText()+"logo element -----------------------------------------");
        //Actions actions = new Actions(driver);
        //actions.moveToElement(logo_home).perform();
        System.out.println(logo_home.getText() + "hover text ???????????????????????");

        Thread.sleep(1000);
        locationPage.send_keys_zip_field ("07733");
        Thread.sleep(3000);

        Assert.assertTrue(locationPage.is_branch_hazlet_present());

//        List<WebElement> search_list = driver.findElements(listed_items);
//        String text_of_element, hazlet_city = "Hazlet";
//        int long_list = search_list.size();
//        if (long_list == 20) System.out.println("long list is 20");
//
//
//        for (WebElement element : search_list) {
//            text_of_element = element.getText();
//            System.out.println("------------------------------------------------" + long_list);
//            System.out.println(element.getText());
//
//            boolean hazlet_found = text_of_element.contains(hazlet_city);
//            if (hazlet_found) {
//                System.out.println("hazlet city item found");
//                break;
//            }
//
//
//        }// closing FOR

    }// closing function

//
//    @Test
//    public void negative_search_branch() throws InterruptedException {
//
//        Thread.sleep(1000);
//        locationPage.send_keys_zip_field("");
//        Thread.sleep(1000);
//        locationPage.send_keys_zip_field("00000");
//        Thread.sleep(10000);
//
//        Assert.assertTrue(locationPage.is_not_branch_message());
//    }


        @AfterClass
        public void closing () throws InterruptedException {
            Thread.sleep(1000);
            //driver.close();
            driver.quit();



    } //closes start function

}
