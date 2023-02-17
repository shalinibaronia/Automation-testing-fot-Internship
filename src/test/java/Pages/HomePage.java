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




}