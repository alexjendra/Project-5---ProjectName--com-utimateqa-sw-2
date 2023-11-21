package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    //Declaring base URL
    String baseUrl = "https://courses.ultimateqa.com/ ";
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on sign in tab
        driver.findElement(By.xpath("//a [@href = '/users/sign_in']")).click();
        //verify the text 'Welcome Back'
        String expectedMessage = "Welcome Back!";
        String actualMessage = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Welcome Back", expectedMessage, actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the sign in tab
        driver.findElement(By.xpath("//a [@href = '/users/sign_in']"));
        //Enter the Invalid Username
        driver.findElement(By.id("user[email]")).sendKeys("khush05@gmail.com");
        //enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("khush056");
        //click on login button
        driver.findElement(By.xpath("//button [@type = 'submit']")).click();
        String expectedMessage = "Invalid email or password.";
        String actualMessage = driver.findElement(By.xpath("//li [@class = 'form-error__list-item']")).getText();
        Assert.assertEquals("Invalid email or password", expectedMessage, actualMessage);
    }
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }



}
