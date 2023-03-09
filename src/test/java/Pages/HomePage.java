package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    private By userAvatarIcon = By.cssSelector("img.avatar");
    By searchBar = By.cssSelector("input[placeholder='Press F to search']");
    By favouriteList = By.cssSelector("a[href='#!/favorites']");

    By plusSignNewPlaylist = By.cssSelector("i[title='Create a new playlist']");
    By newPlaylist = By.cssSelector("li[data-testid='playlist-context-menu-create-simple']");
    By successShowPopup = By.xpath(" //div[@class='success show']");
    By albumspagebutton = By.xpath("//a[normalize-space()='Albums']");
     By albumCover = By.cssSelector("article[class='item full']");
    By emptyNewPlaylisttextField = By.cssSelector("div:nth-child(2) nav.side.side-nav.showing:nth-child(1) section:nth-child(2) form.create:nth-child(2) > input:nth-child(1)");
     //By shuffleIcon = By.cssSelector("article[class='item full'] a[class='shuffle-album']");
    By allSongsLink = By.xpath("//a[normalize-space()='All Songs']");
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public WebElement getUserAvatar(){
        return wait.until(ExpectedConditions.elementToBeClickable(userAvatarIcon));
    }

    public WebElement getSearchBar(){
        return findElement(searchBar);
    }

    public WebElement getFavoriteList(){
        return wait.until(ExpectedConditions.elementToBeClickable(favouriteList));

    }
    public WebElement getNewPlaylistByPlusSign(){
        return wait.until(ExpectedConditions.elementToBeClickable(plusSignNewPlaylist));
    }

    public WebElement getCreateNewPlaylistButton(){
        return wait.until(ExpectedConditions.elementToBeClickable(newPlaylist));
    }

    public WebElement getEmptyFieldForNewPlaylist() {
        return wait.until(ExpectedConditions.elementToBeClickable(emptyNewPlaylisttextField));


    }
    public WebElement getPopUpSuccessShow() {
        return wait.until(ExpectedConditions.elementToBeClickable(successShowPopup));
    }

    public WebElement getAlbumCoverAvailable(){
        return wait.until(ExpectedConditions.elementToBeClickable(albumCover));
    }

    public WebElement getAlbumPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(albumspagebutton));
    }

    public WebElement getAllSongsPage(){
        return wait.until(ExpectedConditions.elementToBeClickable(allSongsLink));
    }


}
