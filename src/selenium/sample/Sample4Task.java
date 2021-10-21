package selenium.sample;
//
//  @author = Vineta Arnicane
//

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/site/examples/actions";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        // declaration above:
        driver = new ChromeDriver();
        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//         TODO:
//        enter a number under "Number"
//        check that button is not clickable "Clear Result"
//        check that text is not displayed
//        click on "Result" button
//        check that text is displayed
//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
//        check that the button "Clear Result" is clickable now
//        click on "Clear Result"
//        check that the text is still (""), but it is not displayed

        WebElement numberInput = driver.findElement(By.id("number"));         //Input field Number
        WebElement clearResultButton = driver.findElement(By.id("clear_result_button_number"));   // Result button
        WebElement resultButton = driver.findElement(By.id("result_button_number"));        // Clear Result button
        WebElement resultText = driver.findElement(By.id("result_number"));   //Result text

        String sendKeyOne = "99";

//        enter a number under "Number"
        numberInput.clear();   // clear the field before to enter new value (it has default value)
        numberInput.sendKeys(sendKeyOne);

//        check that button is not clickable "Clear Result"
        assertFalse(clearResultButton.isEnabled()); // "Clear Result" button is NOT enabled (clickable)

//        check that text is not displayed
        assertFalse(resultText.isDisplayed());

//        click on "Result" button
        resultButton.click(); // clicking on "Result" button

//        check that text is displayed
        assertTrue(resultText.isDisplayed());

//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        assertEquals("You entered number: " + "\"" + sendKeyOne + "\"", resultText.getText());

//        check that the button "Clear Result" is clickable now
        assertTrue(clearResultButton.isEnabled()); // "Clear Result" button is enabled (clickable)

//        click on "Clear Result"
        clearResultButton.click(); // clicking on "Clear Result" button

//        check that the text is still (""), but it is not displayed
        assertEquals("", resultText.getText()); // checking that text is empty
        assertFalse(resultText.isDisplayed());        // checking that text is not displayed

    }

    @Test
    public void clickOnLink() throws Exception {
//         TODO:
//        check current url is base_url
//        click on "This is a link to Homepage"
//        check that current url is not base_url
//        verify that current url is homepage

//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());

//        click on "This is a link to Homepage"
        driver.findElement(By.id("homepage_link")).click();

//        check that current url is not base_url
        assertFalse(driver.getCurrentUrl().equals(base_url));

//        verify that current url is homepage
        assertEquals("This is a home page", driver.findElement(By.id("h1")).getText());
        assertEquals("https://kristinek.github.io/site/", driver.getCurrentUrl());


    }
}
