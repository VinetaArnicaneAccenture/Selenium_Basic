package selenium.sample;
//
//  @author = Vineta Arnicane
//
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class Sample9Task {
    WebDriver driver;
    private static WebDriverWait wait;

    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        wait = (WebDriverWait) new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class);

        driver.get("https://kristinek.github.io/site/examples/loading_color");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void loadGreenSleep() throws Exception {
//         TODO:
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"

//         * 1) click on start loading green button
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();

//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButton.isDisplayed());
        WebElement loadingText = driver.findElement(By.xpath("//*[@id=\"loading_green\"]"));
        assertEquals("Loading green...",loadingText.getText());

//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        Thread.sleep(5000);
        assertFalse(greenButton.isDisplayed());
        assertFalse(loadingText.isDisplayed());

        Thread.sleep(5000);
        WebElement loadedText = driver.findElement(By.xpath("//*[text()=' Loaded']"));
        assertEquals("Green Loaded",loadedText.getText());
        assertTrue(loadedText.isDisplayed());
    }

    @Test
    public void loadGreenImplicit() throws Exception {
//         TODO:
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

//        * 1) click on start loading green button
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();

//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButton.isDisplayed());
        WebElement loadingText = driver.findElement(By.id("loading_green"));
        assertTrue(loadingText.isDisplayed());

//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
        WebElement greenFinish = driver.findElement(By.id("finish_green"));
        assertFalse(greenButton.isDisplayed());
        assertFalse(loadingText.isDisplayed());
        assertTrue(greenFinish.isDisplayed());

    }

    @Test
    public void loadGreenExplicitWait() throws Exception {
//         TODO:
//         * 1) click on start loading green button
//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"

        //        * 1) click on start loading green button
        WebElement greenButton = driver.findElement(By.id("start_green"));
        greenButton.click();

//         * 2) check that button does not appear,
//         * but loading text is seen instead   "Loading green..."
        assertFalse(greenButton.isDisplayed());
        WebElement loadingText = driver.findElement(By.xpath("//*[@id=\"loading_green\"]"));
        assertEquals("Loading green...",loadingText.getText());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=' Loaded']")));

//         * 3) check that both button
//         * and loading text is not seen,
//         * success is seen instead "Green Loaded"
 //       Thread.sleep(5000);
        assertFalse(greenButton.isDisplayed());
        assertFalse(loadingText.isDisplayed());

 //       Thread.sleep(5000);
        WebElement loadedText = driver.findElement(By.xpath("//*[text()=' Loaded']"));
        assertEquals("Green Loaded",loadedText.getText());
        assertTrue(loadedText.isDisplayed());
    }


    @Test
    public void loadGreenAndBlueBonus() {
        /* TODO:
         * 0) wait until button to load green and blue appears
         * 1) click on start loading green and blue button
         * 2) check that button does not appear, but loading text is seen instead for green
         * 3) check that button does not appear, but loading text is seen instead for green and blue
         * 4) check that button and loading green does not appear,
         * 		but loading text is seen instead for blue and success for green is seen
         * 5) check that both button and loading text is not seen, success is seen instead
         */
/*
//                 * 0) wait until button to load green and blue appears
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='start_green_and_blue']")));

//                * 1) click on start loading green and blue button
        WebElement loadGreenAndBlueButton = driver.findElement(By.xpath("//*[@id='start_green_and_blue']"));
        assertTrue(loadGreenAndBlueButton.isDisplayed());

        loadGreenAndBlueButton.click();

//         * 2) check that button does not appear, but loading text is seen instead for green
        assertFalse(loadGreenAndBlueButton.isDisplayed());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loading_green_without_blue']")));
        WebElement loadGreenWithoutBlueText = driver.findElement(By.id("loading_green_without_blue"));
        assertTrue(loadGreenWithoutBlueText.isDisplayed());

//                * 3) check that button does not appear, but loading text is seen instead for green and blue
        assertFalse(loadGreenAndBlueButton.isDisplayed());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loading_green_with_blue']")));
        WebElement loadGreenWithBlueText = driver.findElement(By.xpath("//*[@id=\"loading_green_with_blue\"]"));
        assertTrue(loadGreenWithBlueText.isDisplayed());

//                * 4) check that button and loading green does not appear,
        assertFalse(loadGreenAndBlueButton.isDisplayed());
        assertFalse(loadGreenWithoutBlueText.isDisplayed());

//         * 		but loading text is seen instead for blue and success for green is seen

//                * 5) check that both button and loading text is not seen, success is seen instead
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='finish_green_and_blue']")));
        WebElement greenAmdBlueLoadedText = driver.findElement(By.xpath("//*[@id=\"finish_green_and_blue\"]"));
        assertTrue(greenAmdBlueLoadedText.isDisplayed());

     //   start_green_and_blue
     //           loading_green_without_blue
     //   loading_green_with_blue
     //           loading_blue_without_green
     //   finish_green_and_blue

        */
    }


}