package webdriverexample;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLogin {
    WebDriver driver;
    @Test
    public void Test_Login () {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver86");
        this.driver = new ChromeDriver();
        this.driver.get("https://member.lazada.vn/user/login?spm=a2o4n.home.header.d5.1905e182wFMiYc&redirect=https%3A%2F%2Fwww.lazada.vn%2F");
        this.driver.manage().window().maximize();
        String userName = "username";
        String passWord = "password";
        WebElement txtUserName = driver.findElement(By.cssSelector("div.mod-input input[type=\"text\"]"));
        WebElement txtPassword = driver.findElement(By.cssSelector("div.mod-input input[type=\"password\"]"));

        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(passWord);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        txtUserName.clear();
        String userNameError = txtUserName.getAttribute("error");
        String userNameErrorColor = txtUserName.getCssValue("border-color");
        System.out.printf(userNameErrorColor);

        Assert.assertEquals("Thông tin bắt buộc.", userNameError);
        Assert.assertEquals("rgb(244, 67, 54)",userNameErrorColor);
    }
}
