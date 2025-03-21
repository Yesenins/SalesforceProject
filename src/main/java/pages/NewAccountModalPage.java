package pages;

import elements.Button;
import elements.Dropdown;
import elements.Input;
import objects.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAccountModalPage extends BasePage {

    @FindBy(xpath = "//*[@name = 'SaveEdit']")
    public WebElement saveButton;

    @FindBy(name = "SaveAndNew")
    public WebElement saveAndNewButton;

    @FindBy(name = "CancelEdit")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[contains(text(),'Accounts')]/ancestor::li")
    public WebElement accountsButton;

    @FindBy(xpath = "//*[@href=\"/lightning/o/Account/home\"]/following-sibling::one-app-nav-bar-item-dropdown//*[@icon-name=\"utility:chevrondown\"]")
    public WebElement accountOptions;

    @FindBy(xpath = "//*[@href=\"/001/e?sObjectName=Account&save_new_url=%2F001%2Fe&navigationLocation=LIST_VIEW\"]")
    public WebElement newAccountOption;

    private String modalWindowPath = "//*[@class=\"record-layout-container\"]";

    public NewAccountModalPage(WebDriver driver) {
        super(driver);
    }

    public NewAccountModalPage openPage(String url) {
        waiters.waitForPageLoaded();
        driver.get(url);
        return this;
    }

    public void createNewAccount(Account account) {
        new Input(driver, "Account Name").writeTextToInput(account.getAccountName());
        new Input(driver, "Website").writeTextToInput(account.getWebSite());
        new Dropdown(driver, "Type").dropdownSelectOption(account.getType());
        new Input(driver, "Description").writeTextToTextarea(account.getDescription());
        new Input(driver, "Phone").writeTextToInput(account.getPhone());
        new Button(driver).clickButton(saveButton);
    }

    public NewAccountModalPage openNewAccountModalPage() {
        Actions actions = new Actions(driver);
        accountsButton.click();
        waiters.waitForPageLoaded();
        accountOptions.click();
        actions.moveToElement(newAccountOption);
        actions.click();
        actions.perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modalWindowPath)));
        return this;
    }
}
