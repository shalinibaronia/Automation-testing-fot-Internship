

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import java.time.Duration;



public class BaseTest {

  public WebDriver driver = null;

  public WebDriverWait wait = null;

  public Actions action = null;
  public String url = null;

//  @BeforeSuite
//  public static void setupClass(){
//    WebDriverManager.chromedriver().setup();
//  }

  @BeforeMethod
  @Parameters({"BaseUrl"})
  public void launchBrowser(String BaseUrl){
    url = BaseUrl;
    driver = pickBrowser("browser");
    wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    action = new Actions(driver);
    driver.manage().window().maximize();
    driver.get(url);
  }

  @AfterMethod
  public void closeBrowser(){
    driver.quit();
  }

  public WebDriver pickBrowser(String browser){

    switch(browser){
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        return driver = new FirefoxDriver();

        case "MicrosoftEdge":
        WebDriverManager.edgedriver().setup();
        return driver = new EdgeDriver();

      default:
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();



    }
  }

  public void logIn(String email, String password){
    provideEmail(email);
    providePassword(password);
    clickSubmit();
  }

  public void provideEmail(String email){
    WebElement emailField =driver.findElement(By.cssSelector("[type='email']"));
    wait.until(ExpectedConditions.elementToBeClickable(emailField));
    emailField.clear();
    emailField.sendKeys(email);
  }

  private void providePassword(String password) {
    WebElement passwordField =driver.findElement(By.cssSelector("[type='password']"));
    wait.until(ExpectedConditions.elementToBeClickable(passwordField));
    passwordField.sendKeys(password);
  }

  private void clickSubmit() {
    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
    submitButton.click();

  }

  public void clickProfileIcon(){
    WebElement profileIcon = driver.findElement(By.cssSelector("img.avatar"));
    profileIcon.click();
  }





    }
