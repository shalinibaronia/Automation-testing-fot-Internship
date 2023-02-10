package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public ProfilePage fillCurrentPassword() {
        driver.findElement(currentPassword).sendKeys("te$t$tudent");
        return this;
    }

    public ProfilePage sendName() {
        driver.findElement(name).sendKeys("shalinibaronia");
        return this;
    }

    public ProfilePage sendEmailAddress() {

        driver.findElement(emailAddress).clear();
        driver.findElement(emailAddress).sendKeys("testingit@gmail.com");
        return this;
    }

    public ProfilePage sendNewPassword() {
        driver.findElement(newPassword).sendKeys("password");
        return this;
    }

    public ProfilePage clickSaveButton(){
        driver.findElement(saveButton).click();
        return this;
    }

}


