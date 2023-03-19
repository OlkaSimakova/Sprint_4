package YandexScooterPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static YandexScooterPage.FormForOrder.cookeButton;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Elements & locators

    private static final String url = "https://qa-scooter.praktikum-services.ru/";
    private static final By accordionItem =
            By.xpath(".//div[@data-accordion-component='AccordionItem']");
    private static final By openPanel =
            By.xpath(".//div[@data-accordion-component='AccordionItemPanel']");
    private static final By buttonOrderOne =
            By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    private static final By buttonOrderTwo=
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    // actions
    public MainPage open() {
        driver.get(url);
        return this;
    }


    public MainPage clickDropDown_checkTextAfterClick(String[] expectedTextAfterDropdown) {
        List<WebElement> webElements =
                driver.findElements(accordionItem);
        for (int i = 0; i < webElements.size(); i++) {
            WebElement button = webElements.get(i);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
            button.click();
            new WebDriverWait(driver, 5).until(ExpectedConditions
                    .elementToBeClickable(button.findElement(openPanel)));
            String actualTextAfterDropdown = button.findElement(openPanel).getText();
            Assert.assertEquals(expectedTextAfterDropdown[i], actualTextAfterDropdown);
        }
        return this;
    }

    public MainPage scooterButtonOrderOne(){
        driver.findElement(buttonOrderOne).click();
        return this;
    }
    public MainPage scooterButtonOrderTwo(){
        driver.findElement(buttonOrderTwo).click();
        return this;
    }

    public MainPage checkCookeIsDisplayed(){
        if (driver.findElement(cookeButton).isDisplayed()){
            driver.findElement(cookeButton).click();
        }
        return this;
    }

}
