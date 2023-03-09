package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlbumPage extends BasePage {

    public AlbumPage(WebDriver givenDriver) {
        super(givenDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }


}
