import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTests extends BaseTest {

    @Test
    public void deleteSearchWithDeleteKey () {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys("Reactor");
        homePage.getSearchBar().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

    }
}
