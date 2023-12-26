package Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

    public class Cases_negative_10 {
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

        Thread.sleep(1000);
        locationPage.send_keys_zip_field ("00000");
        Thread.sleep(3000);

        Assert.assertTrue(locationPage.is_not_branch_message());

    }// closing function



        @AfterClass
        public void closing () throws InterruptedException {
            Thread.sleep(3000);
            //driver.close();
            driver.quit();



    } //closes start function

}
