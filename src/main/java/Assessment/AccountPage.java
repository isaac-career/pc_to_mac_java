package Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver ;
    boolean account_selector;
    By get_started_btn = By.id("better-btn-02");
    By find_branch_btn = By.xpath("//div//a[contains(text(),'Find a branch')]");
    By open_accnt_btn = By.xpath("//div[@class='div2']//p//a");
        By select_btn = By.xpath("//h3[contains(text(),'Santander Select® Checking')]");
    By simply_btn = By.xpath("//h3[contains(text(),'Simply Right® Checking')]");
    By essential_btn = By.xpath ("//h3[contains(text(),'Santander® Essential Checking')]");
        String url_expected = "https://secureopen.santanderbank.com/apps/servlet/SmartForm.html?formCode=sbnadao&product=SimplyRightChecking";


    public AccountPage(WebDriver driver){

        this.driver = driver;


    }

    public void click_start_btn(){

        driver.findElement(get_started_btn).click();
    }

    public void click_find_branch_btn(){

        driver.findElement(find_branch_btn).click();
    }

    public void click_account_button(){

        driver.findElement(open_accnt_btn).click();
    }

    public boolean compare_url(){
        String page_url = driver.getCurrentUrl();

        return page_url.contains(url_expected);

    }

    public boolean all_elements_showed(){
        boolean all_elements_showed = true;

        if (!driver.findElement(select_btn).isDisplayed()) all_elements_showed = false;
        if (!driver.findElement(essential_btn).isDisplayed()) all_elements_showed = false;
        if (!driver.findElement(simply_btn).isDisplayed()) all_elements_showed = false;

        return all_elements_showed;
    }



}
