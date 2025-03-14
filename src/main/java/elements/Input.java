package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Input {

    WebDriver driver;
    String label;
    private static final String INPUT_XPATH = "//*[contains(text(), '%s')]/ancestor::div[contains(@part,'input-text')]//input";
    private static final String TEXTAREA_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@slot, 'inputField')]//textarea";
    private static final String INPUT_DROPDOWN = "//label[contains(text(), '%s')]/following-sibling::div//input";
    private static final String DROPDOWN_TEXT = "//*[text() = '%s']";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void writeTextToInput(String text) {
        driver.findElement(By.xpath(String.format(INPUT_XPATH, label))).sendKeys(text);
    }

    public void writeTextToTextarea(String text) {
        driver.findElement(By.xpath(String.format(TEXTAREA_XPATH, label))).sendKeys(text);
    }

    public void writeTextToInputDropdown(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath(String.format(INPUT_DROPDOWN, label))).sendKeys(text);
        WebElement newContactText = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(DROPDOWN_TEXT, text))));
        newContactText.click();
    }
}
