package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        driver.findElement(submitButton).click();
        return this;
    }

    public LoginPage login(){
        provideEmail("shalinibaronia@gmail.com");
        providePassword("te$t$tudent");
        clickSubmit();
        return this;
    }



}