package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsListPage extends BasePage{

    public static final String TABLE_XPATH = "//table";
    public static final String NAME_FIELD_XPATH = TABLE_XPATH + "//a[contains(@title, '%s %s')]";
    public static final String PHONE_BY_CONTACT_NAME_XPATH = NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'forceOutputPhone')]";
    public static final String ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH = NAME_FIELD_XPATH + "/ancestor::tbody//span[contains(@class, 'uiOutputText')]";

    public ContactsListPage(WebDriver driver) {
        super(driver);
    }

    public ContactsListPage openPage(String url) {
        waiters.waitForPageLoaded();
        driver.get(url);
        return this;
    }

    public String getExistContactName(String contactFirstName,String contactLastName) {
        return driver.findElement(By.xpath(String.format(NAME_FIELD_XPATH, contactFirstName,contactLastName))).getText();
    }

    public String getExistPhoneNumberByContactName(String contactFirstName,String contactLastName) {
        return driver.findElement(By.xpath(String.format(PHONE_BY_CONTACT_NAME_XPATH, contactFirstName,contactLastName))).getText();

    }

    public String getExistAccountOwnerByContactName(String contactFirstName,String contactLastName) {
        return driver.findElement(By.xpath(String.format(ACCOUNT_OWNER_BY_ACCOUNT_NAME_XPATH, contactFirstName,contactLastName))).getText();
    }

    public AccountPage clickOnContactName(String contactFirstName,String contactLastName) {
        driver.findElement(By.xpath(String.format(NAME_FIELD_XPATH, contactFirstName,contactLastName))).click();
        return new AccountPage(driver);
    }
}
