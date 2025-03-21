package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    public static final String DATA_BY_FIELD_NAME_XPATH = "//*[@field-label='%s']//slot/*[@slot='outputField']";
    public static final String PHONE_XPATH = DATA_BY_FIELD_NAME_XPATH + "//a";
    public static final String ACCOUNT_OWNER_XPATH = DATA_BY_FIELD_NAME_XPATH + "//*[text() = '%s']";

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getFieldValueByName(String name) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, name))).getText();
    }

    public String getDescriptionInAccount(String label) {
        return driver.findElement(By.xpath(String.format(DATA_BY_FIELD_NAME_XPATH, label))).getText();
    }

    public String getPhoneInAccount(String label) {
        return driver.findElement(By.xpath(String.format(PHONE_XPATH, label))).getText();
    }

    public String getAccountOwnerInAccount(String label, String ownerName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_OWNER_XPATH, label, ownerName))).getText();
    }
}
