package webdriverexample;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitExercise {
    WebDriver driver;

    @Before
    public void InitTest () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver86");
        this.driver = new ChromeDriver();
        this.driver.get("https://www.fido.ca/");
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void LoginWithBlankUserNamePassword () {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
//        WebElement btnSignin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.-login>span.m-navLink__caption")));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement btnSignin = this.driver.findElement(By.cssSelector("a.-login>span.m-navLink__caption"));
        btnSignin.click();

//        WebElement titleLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.modal-title")));
//        System.out.println(titleLogin.getText());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[id=username]"));
//        this.driver.switchTo().activeElement().findElement(By.cssSelector("div.flex-item>button.primary-button")).click();
//        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[id=password]"));
        this.driver.findElement(By.cssSelector("div.signin button.primary-button")).click();
//        System.out.println(btnLogin.getText());
//        btnLogin.click();

    }
}
