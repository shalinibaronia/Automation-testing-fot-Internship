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

    @Test(priority = 0)
    public void updateEmailToNewValidEmail () throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();
        Thread.sleep(2000);
        homePage.getUserAvatar().click();
        Thread.sleep(2000);
        profilePage.fillCurrentPassword("te$t$tudent");
        Thread.sleep(2000);
        profilePage.sendEmailAddress("testingit@gmail.com");
        Thread.sleep(2000);
        profilePage.clickSaveButton();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector(".success.show")).isDisplayed());
        Thread.sleep(2000);
        profilePage.fillCurrentPassword("te$t$tudent");
        profilePage.sendEmailAddress("shalinibaronia@gmail.com");
        Thread.sleep(2000);
        profilePage.clickSaveButton();
    }

//    @Test(priority = 1)
//    public void changeEmailToNewValidEmail () throws InterruptedException {
//
//        LoginPage loginPage = new LoginPage(driver);
//        ProfilePage profilePage = new ProfilePage(driver);
//        HomePage homePage = new HomePage(driver);
//        loginPage.provideEmail("testingit@gmail.com").providePassword("te$t$tudent").clickSubmit();
//        Thread.sleep(5000);
//        homePage.getUserAvatar().click();
//        Thread.sleep(5000);
//        profilePage.fillCurrentPassword("te$t$tudent");
//        Thread.sleep(5000);
//        profilePage.sendEmailAddress("shalinibaronia@gmail.com");
//        Thread.sleep(5000);
//        profilePage.clickSaveButton();
//        Thread.sleep(5000);
//        Assert.assertTrue(driver.findElement(By.cssSelector(".success.show")).isDisplayed());
//    }

    @Test
    public void updateEmailWithoutDomain() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("shalinibaronia@gmail.com").providePassword("te$t$tudent").clickSubmit();
        Thread.sleep(2000);
        homePage.getUserAvatar().click();
        Thread.sleep(2000);
        profilePage.fillCurrentPassword("te$t$tudent");
        Thread.sleep(2000);
        profilePage.sendEmailAddress("shalinibaronia@");
        Thread.sleep(2000);
        profilePage.clickSaveButton();

    }

    @Test
    public void canNotSignInWithOldEmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail("testingit@gmail.com").providePassword("te$t$tudent").clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(),url);



    }



}
