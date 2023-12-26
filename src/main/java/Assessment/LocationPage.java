package Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LocationPage {

    By zip_field = By.id("q");
    By login_btn = By.id("nav-login-lock");
    By map_box = By.id("gmap");
    By investin_btn = By.xpath("//a[@data-target='Investing']");
    By loans_btn = By.xpath("//a[@data-target='PersonalLoans']");
    By listed_items = listed_items = By.xpath("//ul[@class='map-list']//li");
    By no_branch_found_text = By.cssSelector(".map-list-header-search-term.mt-15");
    WebDriver driver ;


    String text_of_element, hazlet_city = "Hazlet";




    public LocationPage(WebDriver driver){

        this.driver = driver;


    }

    public void send_keys_zip_field(String received_string){


            driver.findElement(zip_field).sendKeys(received_string);
            driver.findElement(zip_field).sendKeys(Keys.ENTER);

    }

    public boolean is_branch_hazlet_present(){

        boolean response = false;
        List<WebElement> search_list = driver.findElements(listed_items);
        String text_of_element, hazlet_city = "Hazlet";
        int long_list = search_list.size();
        if (long_list == 20) System.out.println("long list is 20");

        for (WebElement element : search_list) {
            text_of_element = element.getText();
            System.out.println("------------------------------------------------" + long_list);
            System.out.println(text_of_element);

            response = text_of_element.contains(hazlet_city);
            if (response) {
                System.out.println("hazlet city item found");
                break;
            }
        }// closing FOR

        return response;
    }

    public boolean is_not_branch_message(){
        boolean response = false;
        if(driver.findElement(no_branch_found_text).isDisplayed())
            response = true;

        return response;

    }


    public boolean all_elements_showed(){
        boolean all_elements_showed = true;

        if (!driver.findElement(login_btn).isDisplayed()) all_elements_showed = false;
        if (!driver.findElement(map_box).isDisplayed()) all_elements_showed = false;
        if (!driver.findElement(investin_btn).isDisplayed()) all_elements_showed = false;
        if (!driver.findElement(loans_btn).isDisplayed()) all_elements_showed = false;

        return all_elements_showed;
    }



}
