package YandexScooterPageTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class DriverForTest {
    protected WebDriver driver;

    private final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void startUp() {
       // System.setProperty("webdriver.gecko.driver", "C://YandexPraktikum//WebDriver//bin//geckodriver.exe");
      //  driver = new FirefoxDriver();
      //  String url = "https://qa-scooter.praktikum-services.ru/";
     //   driver.get(URL);
      //  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   // }
   // {
        System.setProperty("webdriver.chrome.driver", "C://YandexPraktikum//WebDriver//bin//chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }





    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}