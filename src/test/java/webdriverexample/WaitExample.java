package webdriverexample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitExample {
    WebDriver driver;

    @Before
    public void InitTest () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver86");
        this.driver = new ChromeDriver();
        this.driver.get("http://testmaster.vn/admin");
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait, chờ load trong 5 giây

    }

    @Test
    public void TryToLogin () {
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[type = email]"));
        WebElement txtPassWord = this.driver.findElement(By.cssSelector("input[type = password]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("div.credential button"));

        txtUserName.sendKeys("abcd@gmail.com");
        txtPassWord.sendKeys("123456");
        btnLogin.click();

        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        //explicit wait , chờ 1 điều kiện nào đó xảy ra rồi mới chạy tiếp

        WebElement lbMesage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert b")));
        System.out.println(this.driver.findElement(By.cssSelector("div.body-message>b")).getText());
        Assert.assertEquals("Tên đăng nhập hoặc Mật khẩu không đúng.", lbMesage.getText());

    }
}
