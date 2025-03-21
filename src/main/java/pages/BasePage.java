package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import waiters.Waiters;

public class BasePage {
    WebDriver driver;
    Waiters waiters = new Waiters();

    public BasePage(){
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
