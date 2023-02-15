import by.itacademy.andreyponomarev.web.AmazonPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTest {
    WebDriver driver;
    @Before
    public void initTest() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(AmazonPage.LOGIN_URL);
    }
    @Test
    public void testOpenAmazon(){
        WebElement CHECK_TEXT_LOGO=driver.findElement(By.xpath(AmazonPage.CHECK_TEXT_LOGO));
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates",CHECK_TEXT_LOGO.getText());

    }
    @Test
    public void testOpenAmazonCart(){
        WebElement CLICK_BTN_CART=driver.findElement(By.xpath(AmazonPage.CLICK_BTN_CART));
        CLICK_BTN_CART.click();
        WebElement CHECK_TEXT_LOGO_CART_PAGE=driver.findElement(By.xpath(AmazonPage.CHECK_TEXT_LOGO_CART_PAGE));
        Assert.assertEquals("Your Amazon Cart is empty",CHECK_TEXT_LOGO_CART_PAGE.getText());
    }
    @Test
    public void testOpenAmazonLoginForm() {
        WebElement CLICK_BTN_CART=driver.findElement(By.xpath(AmazonPage.CLICK_BTN_CART));
        CLICK_BTN_CART.click();
        WebElement CLICK_BTN_SING=driver.findElement(By.xpath(AmazonPage.CLICK_BTN_SING));
        CLICK_BTN_SING.click();
        WebElement CHECK_LOGO_SIGN_IN=driver.findElement(By.xpath(AmazonPage.CHECK_LOGO_SIGN_IN));
        Assert.assertEquals("Sign in",CHECK_LOGO_SIGN_IN.getText());
    }
    @Test
    public void testAmazonLoginFormWithEmptyCredentials() {
        WebElement CLICK_BTN_CART=driver.findElement(By.xpath(AmazonPage.CLICK_BTN_CART));
        CLICK_BTN_CART.click();
        WebElement CLICK_BTN_SING=driver.findElement(By.xpath(AmazonPage.CLICK_BTN_SING));
        CLICK_BTN_SING.click();
        WebElement CLICK_BTN_CONTINUE=driver.findElement(By.xpath(AmazonPage.CLICK_BTN_CONTINUE));
        CLICK_BTN_CONTINUE.click();
        WebElement CHECK_LOGO_ENTER_EMAIL=driver.findElement(By.xpath(AmazonPage.CHECK_LOGO_ENTER_EMAIL));
        Assert.assertEquals("Enter your email or mobile phone number", CHECK_LOGO_ENTER_EMAIL.getText());
    }
    @After
    public void endTest() {
        driver.quit();
    }
}
