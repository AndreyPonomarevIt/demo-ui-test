import by.itacademy.andreyponomarev.web.OnlinerPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnlinerTest {
    WebDriver driver;

    @Before
    public void initObject() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(OnlinerPage.LOGIN_URL);
    }

    @Test
    public void testOpenOnliner() {
        WebElement COPIRIGHT_ELEMENT = driver.findElement(By.xpath(OnlinerPage.COPIRIGHT_ELEMENT));
        Assert.assertEquals("© 2001—2023 Onlíner", COPIRIGHT_ELEMENT.getText());
    }

    @Test
    public void testOpenOnlinerLoginForm() {
        WebElement CLICK_BTN_ВХОД = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER));
        CLICK_BTN_ВХОД.click();
        WebElement CHECK_TEXT_BTN_ВХОД = driver.findElement(By.xpath(OnlinerPage.CHECK_TEXT_BTN_ENTER));
        Assert.assertEquals("Вход", CHECK_TEXT_BTN_ВХОД.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        WebElement CLICK_BTN_ВХОД = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER));
        CLICK_BTN_ВХОД.click();
        WebElement CLICK_BTN_ВОЙТИ_FORM_LOGIN = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER_FORM_LOGIN));
        CLICK_BTN_ВОЙТИ_FORM_LOGIN.click();

        WebElement CHECK_TEXT_LOGIN = driver.findElement(By.xpath(OnlinerPage.CHECK_TEXT_LOGIN));
        Assert.assertEquals("Укажите ник или e-mail", CHECK_TEXT_LOGIN.getText());
        WebElement CHECK_TEXT_PASSWORD = driver.findElement(By.xpath(OnlinerPage.CHECK_TEXT_PASSWORD));
        Assert.assertEquals("Укажите пароль", CHECK_TEXT_PASSWORD.getText());
    }

    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebElement CLICK_BTN_ВХОД = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER));
        CLICK_BTN_ВХОД.click();
        WebElement CLICK_BTN_ВОЙТИ_FORM_LOGIN = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER_FORM_LOGIN));
        CLICK_BTN_ВОЙТИ_FORM_LOGIN.click();
        WebElement INPUT_LOGIN = driver.findElement(By.xpath(OnlinerPage.INPUT_LOGIN));
        INPUT_LOGIN.sendKeys("Droner7777777@gmail.com");
        WebElement CLICK_BTN_ВХОД_LOGIN_PAGE = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER_LOGIN_PAGE));
        CLICK_BTN_ВОЙТИ_FORM_LOGIN.click();
        WebElement CHECK_LOGO_LOGIN_PAGE = driver.findElement(By.xpath(OnlinerPage.CHECK_LOGO_LOGIN_PAGE));
        Assert.assertEquals("Укажите пароль", CHECK_LOGO_LOGIN_PAGE.getText());
    }

    @After
    public void endTest() {

        driver.quit();
    }
}
