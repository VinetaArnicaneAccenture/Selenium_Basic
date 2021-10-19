package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

public class Sample5Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get("https://kristinek.github.io/site/examples/alerts_popups");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void goToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
//        switch to alert
//        click ok
//        switch to second alert
//        verify alert text
//        click ok on second alert
//        verify that the correct page is opened
        String resultURL = "https://kristinek.github.io/site/examples/alerted_page" ;  // page where user is directed after the second alert

//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();    //w3-blue

//        switch to alert
        Alert alert = driver.switchTo().alert();

//        click ok
        alert.accept();
        Thread.sleep(2000);

//        switch to second alert
        Alert alertSecond = driver.switchTo().alert();
        Thread.sleep(2000);


//        verify alert text
        assertEquals("Booooooooo!", alertSecond.getText());

//        click ok on second alert
        alertSecond.accept();

//        verify that the correct page is opened
        assertTrue(driver.getCurrentUrl().equals(resultURL));

    }

    @Test
    public void doNotGoToAlertedPageViaButton() throws Exception {
//         TODO:
//        click on "To go to alerted page press Ok. Or stay here" button
//        switch to alert
//        click cancel
//        verify the text on page


//        click on "To go to alerted page press Ok. Or stay here" button
        driver.findElement(By.className("w3-blue")).click();    //w3-btn w3-round-xlarge w3-ripple w3-blue

//        switch to alert
        Alert alert = driver.switchTo().alert();

//        click cancel
        alert.dismiss();

//        verify the text on page
        assertEquals("So you desided to say? Good!", driver.findElement(By.id("textForAlerts")).getText());


    }
}
