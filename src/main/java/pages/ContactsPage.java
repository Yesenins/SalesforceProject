package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {
    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@field-label='%s']//slot/*[@slot='outputField']";

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValueByNameContacts(String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }
}
