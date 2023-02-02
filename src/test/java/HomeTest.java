import Pages.LoginPage;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeTest extends BaseTest {

    @Test
    public void addSongToPlaylist(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.logIn();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        grabASong();

    }

    public void grabASong(){
        WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']"));
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[5]"));

        Actions acts = new Actions(getDriver());
        acts.clickAndHold(song)
                .release(playlist)
                .build()
                .perform();

        playlist.click();
//        acts.dragAndDrop(song, playlist).build().perform();

    }
    @Test
    public void playASongTest() {
        LoginPage loginPage = new LoginPage(getDriver());
        logIn("shalinibaronia@gmail.com", "te$t$tudent");
        playSong();
        isSongPlaying();
    }

    public void playSong() {
        WebElement playNextButton = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextButton.click();
        playButton.click();
    }

    public void isSongPlaying() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }

    @Test
    public void DeletePlaylistTest() throws InterruptedException {
        String playlistName = "test playlist";

        LoginPage loginPage = new LoginPage(getDriver());
        logIn("shalinibaronia@gmail.com", "te$t$tudent");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@title='Create a new playlist']"))).click();

        WebElement newPlaylist = driver.findElement(By.xpath("//li[text()='New Playlist']"));
        newPlaylist.click();

        WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
        nameField.clear();
        nameField.sendKeys(playlistName, Keys.ENTER);

        WebElement testPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='"+playlistName+"']")));
        testPlaylist.click();

        WebElement deletePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']")));
        deletePlaylist.click();

        Thread.sleep(2000);
        List<WebElement> playlistNames = driver.findElements(By.xpath("//section[@id='playlists']//li/a"));

        for(WebElement p : playlistNames) {
            String name = p.getText();
            if (name.equals(playlistName)) {
                Assert.assertTrue(false);
            }
        }
    }
}



