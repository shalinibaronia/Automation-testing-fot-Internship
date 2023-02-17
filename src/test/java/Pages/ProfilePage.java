package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        WebElement fillCurrentPassword = driver.findElement(currentPassword);
        wait.until(ExpectedConditions.elementToBeClickable(fillCurrentPassword)).sendKeys(password);
        return this;
    }

    public ProfilePage sendName() {
        WebElement fillCurrentName = driver.findElement(name);
        wait.until(ExpectedConditions.elementToBeClickable(fillCurrentName)).sendKeys("shalinibaronia");
        return this;
    }

    public ProfilePage sendEmailAddress(String email) {
        WebElement fillEmailAddress = driver.findElement(emailAddress);
        fillEmailAddress.clear();
        wait.until(ExpectedConditions.elementToBeClickable(fillEmailAddress)).sendKeys(email);
        //driver.findElement(emailAddress).clear();
       // driver.findElement(emailAddress).sendKeys(email);
        return this;
    }

    public ProfilePage sendNewPassword(String passwordnew) {
        WebElement fillNewPassword = driver.findElement(newPassword);
        wait.until(ExpectedConditions.elementToBeClickable(fillNewPassword)).sendKeys(passwordnew);
        //driver.findElement(newPassword).sendKeys(passwordnew);
        return this;
    }

    public ProfilePage clickSaveButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        return this;
    }

}


