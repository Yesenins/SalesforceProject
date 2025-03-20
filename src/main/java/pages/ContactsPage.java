package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {
    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@field-label='%s']//slot/*[@slot='outputField']";
    public static final String CONTACT_OWNER_XPATH = DATA_BY_FIELD_NAME_XPATH + "//*[text() = '%s']";
    public static final String CONTACT_PHONE_XPATH = DATA_BY_FIELD_NAME_XPATH + "//a";
    public static final String ACCOUNT_NAME_XPATH = "//*[@field-label='%s']//*[text()='%s']";

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValueByNameContacts(String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }

    public String getAccountNameInContacts(String label, String name) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_NAME_XPATH, label, name))).getText();
    }

    public String getDescriptionInContacts(String label) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, label))).getText();
    }

    public String getContactOwnerInContacts(String label, String ownerName) {
        return driver.findElement(By.xpath(String.format(CONTACT_OWNER_XPATH, label, ownerName))).getText();
    }

    public String getContactPhoneInContacts(String label) {
        return driver.findElement(By.xpath(String.format(CONTACT_PHONE_XPATH, label))).getText();
    }
}
