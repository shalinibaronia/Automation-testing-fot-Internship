package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {

    //locators

    By currentPassword = By.cssSelector("#inputProfileCurrentPassword");

    By name = By.cssSelector("#inputProfileName");

    By emailAddress = By.cssSelector("#inputProfileEmail");
    By newPassword = By.cssSelector("#inputProfileNewPassword");
    By saveButton = By.cssSelector("button[class='btn-submit']");
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public ProfilePage fillCurrentPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(currentPassword));
        driver.findElement(currentPassword).sendKeys(password);
        return this;
    }

    public ProfilePage sendName() {
        wait.until(ExpectedConditions.elementToBeClickable(name));
        driver.findElement(name).sendKeys("shalinibaronia");
        return this;
    }

    public ProfilePage sendEmailAddress(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailAddress));
        driver.findElement(emailAddress).clear();
        driver.findElement(emailAddress).sendKeys(email);
        return this;
    }

    public ProfilePage sendNewPassword(String passwordnew) {
        wait.until(ExpectedConditions.elementToBeClickable(newPassword));
        driver.findElement(newPassword).sendKeys(passwordnew);
        return this;
    }

    public ProfilePage clickSaveButton(){
        driver.findElement(saveButton).click();
        return this;
    }

}


