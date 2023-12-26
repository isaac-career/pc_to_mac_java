package Assessment;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;



public class Case_015 {
    WebDriver driver;     WebDriverWait wait;      DateTimeFormatter dtf; LocalDateTime now;     HomePage homePage; AccountPage accountPage;


    @BeforeClass
    public void initialize() throws InterruptedException {

            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\jorge\\Documents\\courses\\Selenium\\geckodriver-v0.33.0-win64\\geckodriver.exe");

            driver = new FirefoxDriver();
            dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            now = LocalDateTime.now();
            homePage = new HomePage(driver);
            accountPage = new AccountPage(driver);

            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Thread.sleep(3000);
            driver.get("https://www.santanderbank.com/");
            driver.manage().window().maximize();

    }

    @Test
    public void start_element_checker() throws InterruptedException {


        System.out.println("before wait" + dtf.format(LocalDateTime.now()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
        WebDriver.Timeouts timeouts = driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(1));
        System.out.println("after wait" + dtf.format(LocalDateTime.now()));


        System.out.println("2 before wait" + dtf.format(LocalDateTime.now()));
        Thread.sleep(1000);
        System.out.println("2 after wait" + dtf.format(LocalDateTime.now()));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)", "");

        Thread.sleep(3000);
        homePage.click_start_btn();
        //driver.findElement(get_started_btn).click(); --------------------------------------------
        Thread.sleep(1000);


        js.executeScript("window.scrollBy(0,600)", "");


        Assert.assertTrue(accountPage.all_elements_showed());


    }
    @Test
    public void test_url() throws InterruptedException {

        Thread.sleep(2000);
        accountPage.click_account_button();
        //driver.findElement(open_accnt_btn).click();------------------------------------------

        Thread.sleep(1000);
        Set<String> windows_list = driver.getWindowHandles();
        Iterator<String> iterator = windows_list.iterator();
        driver.switchTo().window(iterator.next());
        driver.switchTo().window(iterator.next());
        Thread.sleep(3000);

        Assert.assertTrue(accountPage.compare_url());


    }

    @AfterClass
    public void closing() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }


}
