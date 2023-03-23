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

    // Локаторы кнопок с вопросами
    public static final String[] accordionItem = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};
    //Локаторы текстов "Вопросы о важном
    public static final String[]  openPanel = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

    //Локатор для кнопки вверху экрана
    private static final By buttonOrderOne =
            By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");

    //Локатор для кнопки вверху экрана
    private static final By buttonOrderTwo=
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");


    public void scrollPageToQuestionsAboutImportant(){
        WebElement lastQuestionArrow = driver.findElement(By.id(accordionItem[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastQuestionArrow);
    }

    //Клик по кнопке вопроса
    public void pushQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
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
