import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyJUnit {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void Setup() {
        System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--headed");
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void getTitle() {
        driver.get("https://demoqa.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("ToolsQA"));
        System.out.println(title);
    }

    @Test
    public void checkIfImageExists(){
        driver.get("https://demoqa.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement imgElement = wait.until(ExpectedConditions.elementToBeClickable(By.className("banner-image")));
        boolean status = imgElement.isDisplayed();
        Assert.assertTrue(status);
        if (status ==true){
            System.out.println("Image Found");
        }
        else {
            System.out.println("Image Not Found");
        }
    }
}
