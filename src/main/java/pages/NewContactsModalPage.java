package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewContactsModalPage extends BasePage{

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    @FindBy(name = "SaveAndNew")
    public WebElement saveAndNewButton;

    @FindBy(name = "CancelEdit")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@data-id='Contact']//*[@role='button']")
    public WebElement dropdown;

    public NewContactsModalPage(WebDriver driver) {
        super(driver);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public NewContactsModalPage openPage(String url) {

        driver.get(url);
        waiters.waitForPageLoaded();
        return this;
    }

    public void createNewContact(Contact contact) {
        new Dropdown(driver, "Salutation").dropdownSelectOption(contact.getSalutation());
        new Input(driver, "First Name").writeTextToInput(contact.getContactFirstName());
        new Input(driver, "Last Name").writeTextToInput(contact.getContactLastName());
        new Input(driver, "Account Name").writeTextToInputDropdown(contact.getContactAccountName());
        new Input(driver, "Description").writeTextToTextarea(contact.getDescription());
        new Input(driver, "Phone").writeTextToInput(contact.getPhone());

        new Button(driver).clickButton(saveButton);
    }
}
