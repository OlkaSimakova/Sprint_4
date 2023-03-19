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

@RunWith(Parameterized.class)
public class DriverForTest {

    public DriverForTest(String browserName) {
        this.browserName = browserName;
    }

    protected WebDriver driver;
    protected String browserName;

    @Before
    public void setUp() {
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C://YandexPraktikum//WebDriver//bin//geckodriver.exe");
            driver = new FirefoxDriver();
            String url = "https://qa-scooter.praktikum-services.ru/";
            driver.get(url);
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browserName);
        }
    }


    @After
    public void tearDown() {
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> browsers() {
        return Arrays.asList(new Object[][]{
                {"chrome"},
                {"firefox"}
        });
    }
}