package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class Task1 {
    WebDriver driver;
    WebElement numberInput;
    WebElement submitButton;
    WebElement resultText;

    @Before
    public void openPage() {

        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
        numberInput = driver.findElement(By.id("numb"));         //Input field
        submitButton = driver.findElement(By.className("w3-btn"));   // Submit button
        resultText = driver.findElement(By.id("ch1_error"));   //Result text

    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void errorOnText() {
//        TODO
//        enter a text instead of a number, check that correct error is seen

        String sendKeyOne = "aa";     // try to input non-number
        numberInput.sendKeys(sendKeyOne);

        submitButton.click(); // clicking on "Result" button

        assertEquals("Please enter a number", resultText.getText());  // checks if text message is correct
    }

    @Test
    public void errorOnNumberTooSmall() {
//        TODO
//        enter number which is too small (below 50), check that correct error is seen

        String sendKeyOne = "40";     // try to input non-number    BUG - 49 works!!
        numberInput.sendKeys(sendKeyOne);

        submitButton.click(); // clicking on "Result" button

        assertEquals("Number is too small", resultText.getText());  // checks if text message is correct
    }

    @Test
    public void errorOnNumberTooBig() {

//        BUG: if I enter number 666 no errors where seen
//        TODO
//        enter number which is too big (above 100), check that correct error is seen

        String sendKeyOne = "110";     // try to input non-number
        numberInput.sendKeys(sendKeyOne);

        submitButton.click(); // clicking on "Result" button

        assertEquals("Number is too big", resultText.getText());  // checks if text message is correct


    }

    @Test
    public void correctSquareRootWithoutRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 2 is square root of 4),
//        then and press submit and check that correct no error is seen and check that square root is calculated correctly

        String sendKeyOne = "81";     // try to input non-number
        String resultString = "9.00";
        numberInput.sendKeys(sendKeyOne);

        submitButton.click(); // clicking on "Result" button

        //        switch to alert
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of " + sendKeyOne + " is "+resultString, alert.getText());  // checks if text of alert is correct
        alert.accept();

        assertEquals("", resultText.getText());  // checks if text message is not here
    }

    @Test
    public void correctSquareRootWithRemainder() {
//        TODO
//        enter a number between 50 and 100 digit in the input (square root of which doesn't have a remainder, e.g. 1.732.. is square root of 3) and press submit,
//        then check that correct no error is seen and check that square root is calculated correctly

        String sendKeyOne = "60";     // try to input non-number
        String resultString = "7.75";

        numberInput.sendKeys(sendKeyOne);
        submitButton.click(); // clicking on "Result" button

        //        switch to alert
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of " + sendKeyOne + " is "+resultString, alert.getText());  // checks if text of alert is correct
        alert.accept();

        assertEquals("", resultText.getText());  // checks if text message is not here

    }
}
