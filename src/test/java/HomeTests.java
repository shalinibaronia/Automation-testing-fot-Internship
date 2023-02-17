import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTests extends BaseTest {
    @BeforeMethod
    public void loginToWebsite(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
    }

    @Test
    public void deleteSearchWithDeleteKey () throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys("Reactor");
        System.out.println(homePage.getSearchBar().getAttribute("value"));
        homePage.getSearchBar().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
        System.out.println(homePage.getSearchBar().getAttribute("value"));
        Assert.assertTrue(homePage.getSearchBar().getAttribute("value").isEmpty());
    }
    @Test
   public void deleteSearchWithXButton () throws InterruptedException {
       HomePage homePage = new HomePage(driver);

      homePage.getSearchBar().click();
       homePage.getSearchBar().sendKeys("Reactor");
        System.out.println(homePage.getSearchBar().getAttribute("value"));
        driver.findElement(By.xpath("//input[@class= 'dirty']")).clear();
        Assert.assertTrue(homePage.getSearchBar().getAttribute("value").isEmpty());

    }

    @Test
    public void searchCaseSensitive() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        homePage.getSearchBar().click();
        homePage.getSearchBar().sendKeys("GRAV");

        String expectedValue = "GRAV";
        WebElement findText = driver.findElement(By.cssSelector("section[class='artists'] a[class='name']"));
        wait.until(ExpectedConditions.elementToBeClickable(findText));
        String actualValue = findText.getText();
        Assert.assertNotEquals(actualValue,expectedValue);
    }
    @Test
    public void searchSongWithTitle() throws InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.getSearchBar().click();
        String keyExpected = "Lobo Loco";
        homePage.getSearchBar().sendKeys(keyExpected);
        Thread.sleep(2000);
        WebElement textTitle = driver.findElement(By.xpath("//section[@class='songs']/ul/article[1]/span[2]/span[1]"));
         String keyActual = textTitle.getText();
         Assert.assertTrue(keyActual.contains("Lobo Loco"));
    }

    @Test
    public void saveSongToFavoriteWithHeart(){
        HomePage homePage = new HomePage(driver);
       homePage.findElement(By.xpath("(//i[@class='fa fa-heart-o'])[1]")).click();
        homePage.getFavoriteList().click();
        WebElement songAdded = driver.findElement(By.cssSelector("div[class='song-list-wrap main-scroll-wrap favorites'] button[title='Unlike Take my Hand (ID 1696) by Lobo Loco']"));
        Assert.assertTrue(songAdded.isDisplayed());


    }
}


