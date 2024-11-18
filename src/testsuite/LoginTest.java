package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {


    String baseUrl = "https://the-internet.herokuapp.com/login";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){

        //Enter “tomsmith” for the username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” for the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//i [@class = 'fa fa-2x fa-sign-in']")).click();
        //Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2")).getText();
        Assert.assertEquals("Secure Area", expectedText, actualText);
        //Click on the ‘Logout’ button
        driver.findElement(By.xpath("//i [@class = 'icon-2x icon-signout']")).click();
        //Verify the text ‘You logged out of the secure area!’
        String expectedMessage = " You logged out of the secure area!";
        String actualMessage = driver.findElement(By.id("flash")).getText().trim().split("\n")[0];
        Assert.assertEquals(" You logged out of the secure area!", expectedMessage, actualMessage);



    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” for the username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” for the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//i [@class = 'fa fa-2x fa-sign-in']")).click();
        //Verify the error message “Your username is invalid!”
        String expectedErrorMessage = " Your username is invalid!";
        String actualErrorMessage = driver.findElement(By.id("flash")).getText().trim().split("\n")[0];
        Assert.assertEquals("Username invalid message",expectedErrorMessage, actualErrorMessage);
    }



    @Test
public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” for the username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” for the password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        //Click on the ‘Login’ button
        driver.findElement(By.xpath("//i [@class = 'fa fa-2x fa-sign-in']")).click();
        //Verify the error message “Your password is invalid!”
        String expectedErrorMessage = "Your password is invalid!";
        String actualErrorMessage = driver.findElement(By.id("flash")).getText().trim().split("\n")[0];
        Assert.assertEquals("Invalid message",expectedErrorMessage, actualErrorMessage);

}
    @After
    public void tearDown(){
        //closeBrowser();

    }
}
