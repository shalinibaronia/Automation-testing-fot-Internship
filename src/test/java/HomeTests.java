import Pages.AlbumPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Iterator;
import java.util.List;

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

    @Test
    public void saveASongToFavoriteByDragNDrop() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
       WebElement holdASong =  homePage.findElement(By.xpath("(//span[@class='details'])[7]"));
       action.dragAndDrop(holdASong,homePage.getFavoriteList());
        homePage.getFavoriteList().click();
        WebElement songAdded = driver.findElement(By.xpath("//td[normalize-space()='Ketsa - Beautiful']"));
        Assert.assertTrue(songAdded.isDisplayed());
    }

     @Test
     public void deleteASongByDeleteKey(){
        HomePage homePage = new HomePage(driver);
        homePage.getFavoriteList().click();
        homePage.findElement(By.xpath(" //td[normalize-space()='Dark Days']")).click();
        homePage.findElement(By.xpath(" //td[normalize-space()='Dark Days']")).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

    }

    @Test
    public void createANewPlayListWithPlusSign() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        Thread.sleep(2000);
        homePage.getNewPlaylistByPlusSign().click();
        Thread.sleep(2000);
        homePage.getCreateNewPlaylistButton().click();
        homePage.getEmptyFieldForNewPlaylist().sendKeys("Cooool");
        homePage.getEmptyFieldForNewPlaylist().sendKeys((Keys.chord(Keys.ENTER)));
        Assert.assertTrue(homePage.getPopUpSuccessShow().isDisplayed());

    }
    @Test
    public void albumCoverIsPresent() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
         homePage.getAlbumPage().click();
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.4'");
         executor.executeScript("window.scrollBy(0,250)");
        Thread.sleep(7000);

         List <WebElement> cover = driver.findElements(By.cssSelector("section[id = 'albumsWrapper'] div[class='albums main-scroll-wrap as-thumbnails'] article[class='item full']"));System.out.println(cover.size());

        Iterator<WebElement> itr = cover.iterator();
        Thread.sleep(2000);
        while(itr.hasNext()) {
            System.out.println(itr.next().getText());

        }
        System.out.println(cover.size());

    }



    @Test
    public void displayAllSongs() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.getAllSongsPage().click();
        WebElement songCount =driver.findElement(By.xpath("//span[contains(text(),'66 songs')]"));
        System.out.println(songCount.getText());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '1.0'");
        executor.executeScript("window.scrollBy(0,5550)");
        Thread.sleep(2000);

         WebElement Element = driver.findElement(By.xpath("//section[@id='songsWrapper']//button[@title='Shuffle all songs'][normalize-space()='All']"));
         Element.sendKeys(Keys.PAGE_DOWN);

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("tr:nth-child(63) td:nth-child(2)")));
        List <WebElement> totalSongInList = driver.findElements(By.cssSelector("tr[class='song-item'] td[class='time text-secondary']"));
        Iterator<WebElement> itr = totalSongInList.iterator();
        Thread.sleep(2000);
        while(itr.hasNext()) {
            System.out.println(itr.next().getText());

        }

        System.out.println(totalSongInList.size());

    }

    @Test
    public void shuffleIconIsPresent() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.getAlbumPage().click();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '0.4'");
        executor.executeScript("window.scrollBy(0,250)");

        Thread.sleep(2000);
        List<WebElement> shuffleIcon = driver.findElements(By.cssSelector("article[class='item full'] span[class='right'] a[class='shuffle-album']"));
        Iterator<WebElement> itr = shuffleIcon.iterator();
        Thread.sleep(2000);
        while (itr.hasNext()) {
            System.out.println(itr.next().getText());

        }
        System.out.println(shuffleIcon.size());

    }
    @Test
    public void songNumberSame() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.getAlbumPage().click();

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.6'");
        executor.executeScript("window.scrollBy(0,550)");
        Thread.sleep(5000);

        List <WebElement> numberCounts = driver.findElements(By.cssSelector("div[class='albums main-scroll-wrap as-thumbnails'] article[class='item full'] p[class='meta'] span[class='left']"));
//        Iterator<WebElement> itr = numberCount.iterator();
//
//        while (itr.hasNext()) {
//            System.out.println(itr.next().getText());
//            WebElement link = driver.findElement(By.cssSelector("a[class='name']"));
//            link.click();
//            System.out.println(driver.findElement(By.cssSelector("span[data-test='list-meta']")).getText());
//            Thread.sleep(5000);
//
//            driver. navigate(). back();
//
//        }
        for(WebElement numberCount: numberCounts){
            System.out.println(numberCount.getText());
        }

        Thread.sleep(5000);
        System.out.println(numberCounts.size());

    }

    @Test
    public void openScroll() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("document.body.style.zoom = '1.0'");
        executor.executeScript("window.scrollBy(0,5550)");
        Thread.sleep(2000);
       // executor.executeScript("window.scrollBy(0,250)");
        action.sendKeys(Keys.PAGE_DOWN);
    }



}



