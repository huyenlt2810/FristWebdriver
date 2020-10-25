package webdriverexample;

import org.junit.Assert;
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
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void login () {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        WebElement btnSignin = this.driver.findElement(By.cssSelector("a.-login>span.m-navLink__caption"));
        btnSignin.click();
        this.driver.switchTo().frame(0);
        WebElement titleLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.modal-title")));
    }
    @Test
    public void LoginWithBlankUserNamePassword () {
        login();
        WebElement btnLogin = this.driver.findElement(By.cssSelector("div.signin button.primary-button"));
        btnLogin.click();
        WebElement passWordError = this.driver.findElement(By.cssSelector("div.btn-show-hide-box small"));
        Assert.assertEquals("Please enter your password.", passWordError.getText());

    }
    @Test
    public void checkPasswordIsShow () {
        login();
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[id=password]"));
        WebElement btnShow = this.driver.findElement(By.cssSelector("div.btn-show-hide-box button"));
        txtPassword.sendKeys("12345");
        if (btnShow.getText().equalsIgnoreCase("SHOW")) {
            btnShow.click();
        }
        System.out.printf(txtPassword.getAttribute("type"));
        Assert.assertEquals("text", txtPassword.getAttribute("type"));

    }
    @Test
    public void loginWithIncorrectUserName () {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        login();
        WebElement txtUserName = this.driver.findElement(By.cssSelector("input[id=username]"));
        WebElement txtPassword = this.driver.findElement(By.cssSelector("input[id=password]"));
        WebElement btnLogin = this.driver.findElement(By.cssSelector("div.signin button.primary-button"));
        txtUserName.sendKeys("abcdjgg");
        txtPassword.sendKeys("12345");
        btnLogin.click();
        WebElement loginError = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.font-normal")));
        System.out.printf(loginError.getText());
        String expected = "That username isn't recognized. Please try again.\n" + "\n" + "Need help? Contact us.";
        Assert.assertEquals(expected,loginError.getText());


    }
}
