import by.itacademy.andreyponomarev.web.OnlinerPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OnlinerHomeExersiceTest {
    WebDriver driver;

    @Before
    public void initObject() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(OnlinerPage.LOGIN_URL);
    }
    @Test
    public void testEmptyLoginAndСompletedPassword(){
        WebElement clickBtnEnter = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER));
        clickBtnEnter.click();
        WebElement clickBtnEnterFormLogin = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER_FORM_LOGIN));
        clickBtnEnterFormLogin.click();
        WebElement inputPassword = driver.findElement(By.xpath(OnlinerPage.INPUT_PASSWORD));
        inputPassword.sendKeys("kol63zei");
        WebElement clickBtnEnterLoginPage = driver.findElement(By.xpath(OnlinerPage.CLICK_BTN_ENTER_LOGIN_PAGE));
        clickBtnEnterLoginPage.click();
        WebElement checkLabelLogoPage = driver.findElement(By.xpath(OnlinerPage.CHECK_TEXT_LOGIN));
        Assert.assertEquals("Укажите ник или e-mail", checkLabelLogoPage.getText());

    }
    @After
    public void endTest() {

        driver.quit();
    }
}
