package YandexScooterPageTest;
import YandexScooterPage.Constants;
import YandexScooterPage.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class DropdownListWithQuestions extends DriverForTest {

    public DropdownListWithQuestions(String browserName) {
        super(browserName);
    }

    @Test
    //Проверка выпадающего списка в разделе «Вопросы о важном»"
    public void dropdownListImportantQuestions() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.checkCookeIsDisplayed();
        mainPage.clickDropDown_checkTextAfterClick(Constants.getTextAnswer());
    }
}
