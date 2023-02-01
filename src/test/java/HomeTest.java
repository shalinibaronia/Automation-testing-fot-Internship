import Pages.LoginPage;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        logIn("shalinibaronia@gmail.com", "te$t$tudent");
        Thread.sleep(2000);
        grabASong();

    }

    public void grabASong(){
        LoginPage loginPage = new LoginPage(getDriver());
        WebElement song = driver.findElement(By.xpath("//article[@data-test='song-card']"));
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//li[5]"));

        Actions acts = new Actions(driver);
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

}


