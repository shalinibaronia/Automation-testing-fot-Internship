import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProfileTests extends BaseTest {

    @Test
    public void updateEmailToNewValidEmail () throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Thread.sleep(5000);
        homePage.getUserAvatar().click();
        Thread.sleep(5000);
        profilePage.fillCurrentPassword();
        Thread.sleep(5000);
        profilePage.sendEmailAddress();
        Thread.sleep(5000);
        profilePage.clickSaveButton();
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.cssSelector(".success.show")).isDisplayed());
}}
