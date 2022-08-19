package tests;


import Utils.ScreenshotUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;



import static org.junit.Assert.assertEquals;

public class HomePageTest {

   private WebDriver driver;



    @Before
    public void AcessarSite() {
        System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
    }

    @After
    public void FecharBrowser() {
        driver.quit();
    }

    @Test
    public void ValidaTituloDaPagina() {
        String textElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/h1")).getText();
        assertEquals("Automation Demo Site", textElement);
       }

    @Test
    public void ValidaLayoutDaPagina() throws IOException {
        ScreenshotUtils.CapturaScreenshot(driver, "Layout.jpg");
       }

    @Test
    public void ClicaEmAlertDepoisFecharOAlerta() throws InterruptedException {
         driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
         driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/button")).click();
         Thread.sleep(1500);
         driver.switchTo().alert().accept();
         Thread.sleep(1500);
        }
    }



