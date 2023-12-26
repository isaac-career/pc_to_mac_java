package Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver ;
    boolean account_selector;
    By get_started_btn = By.id("better-btn-02");
    By find_branch_btn = By.xpath("//div//a[contains(text(),'Find a branch')]");

    By select_btn = By.xpath("//h3[contains(text(),'Santander Select® Checking')]");
    By simply_btn = By.xpath("//h3[contains(text(),'Simply Right® Checking')]");
    By essential_btn = By.xpath ("//h3[contains(text(),'Santander® Essential Checking')]");
        String url_expected = "https://secureopen.santanderbank.com/apps/servlet/SmartForm.html?formCode=sbnadao&product=SimplyRightChecking";


    public HomePage(WebDriver driver){

        this.driver = driver;


    }

    public void click_start_btn(){

        driver.findElement(get_started_btn).click();
    }

    public void click_find_branch_btn(){
        driver.findElement(find_branch_btn).click();
    }





}
