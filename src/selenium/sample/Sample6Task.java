package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample6Task {
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
        driver.get("https://kristinek.github.io/site/examples/locators");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void findElementByXPath() throws Exception {
//         TODO:
//        2 ways to find text: "Heading 2 text":
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 2"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "Test Text 4"
//        1-2 ways to find text: "Test Text 5"
//        1-2 ways to find text: "This is also a button"

        System.out.println("Find element by using xPath:");

//        2 ways to find text: "Heading 2 text":
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Heading 2 text' by id: " +
                driver.findElement(By.xpath("//*[@id='heading_2']")).getText() + "'");
        System.out.println("\t 'Heading 2 text' by contains: " +
                        driver.findElement(By.xpath("//*[contains(text(), 'Heading 2 text')]")).getText() + "'");

//        1-2 ways to find text: "Test Text 1"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 1' 1st way: " +
                driver.findElement(By.xpath("//*[@id='test1']/p[1]")).getText() + "'");
        System.out.println("\t 'Test Text 1' 2nd way: " +
                driver.findElement(By.xpath("//*[text()='Test Text 1']")).getText() + "'");


//        1-2 ways to find text: "Test Text 2"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 2' 1st way: " +
                driver.findElement(By.xpath("//*[@id='test1']/p[2]")).getText() + "'");
        System.out.println("\t 'Test Text 2' 2nd way: " +
                driver.findElement(By.xpath("//*[text()='Test Text 2']")).getText() + "'");


//        1-2 ways to find text: "Test Text 3"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 3' 1st way: " +
                driver.findElement(By.xpath("//*[@id='test3']/p[1]")).getText() + "'");
        System.out.println("\t 'Test Text 3' 2nd way: " +
                driver.findElement(By.xpath("//*[text()='Test Text 3']")).getText() + "'");

//        1-2 ways to find text: "Test Text 4"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 4' 1st way: " +
                driver.findElement(By.xpath("//*[@id='test3']/p[2]")).getText() + "'");
        System.out.println("\t 'Test Text 4' 2nd way: " +
                driver.findElement(By.xpath("//*[text()='Test Text 4']")).getText() + "'");


//        1-2 ways to find text: "Test Text 5"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 5' 1st way: " +
                driver.findElement(By.xpath("//*[@id='test2']/p[1]")).getText() + "'");
        System.out.println("\t 'Test Text 5' 2nd way: " +
                driver.findElement(By.xpath("//*[@id='test2']/p[contains(@class, 'Test')]")).getText() + "'");

//        1-2 ways to find text: "Test Text 6"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 6' 1st way: " +
                driver.findElement(By.xpath("//*[@id='test2']/p[2]")).getText() + "'");
        System.out.println("\t 'Test Text 6' 2nd way: " +
                driver.findElement(By.xpath("//*[@id='test2']/p[contains(@class, 'test')]")).getText() + "'");

//        1-2 ways to find text: "This is also a button"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'This is also a button' 1st way: " +
                driver.findElement(By.xpath("//*[@value='This is also a button']")).getAttribute("value") + "'");
        System.out.println("\t 'This is also a button' 2nd way: " +
                driver.findElement(By.xpath("//*[@name='randomButton2']")).getAttribute("value") + "'");

    }

    @Test
    public void findElementByCssName() throws Exception {
//         TODO:
//        1-2 ways to find text: "Heading 2 text"
//        1-2 ways to find text: "Test Text 1"
//        1-2 ways to find text: "Test Text 3"
//        1-2 ways to find text: "This is also a button"

        System.out.println("Find element by id using CSS:");

//        1-2 ways to find text: "Heading 2 text"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Heading 2 text' 1st way: " +
                driver.findElement(By.cssSelector("#heading_2")).getText() + "'");
        System.out.println("\t 'Heading 2 text' 2nd way: : " +
                driver.findElement(By.cssSelector("h2:nth-of-type(2)")).getText() + "'");

//        1-2 ways to find text: "Test Text 1"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 1' 1st way: " +
            driver.findElement(By.cssSelector("div#test1 p:first-child")).getText() + "'");
        System.out.println("\t 'Test Text 1' 2nd way: " +
              driver.findElement(By.cssSelector("div#test1 p.test")).getText() + "'");

//        1-2 ways to find text: "Test Text 2"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 2' 1st way: " +
                driver.findElement(By.cssSelector("div#test1 p:first-child + p")).getText() + "'");
        System.out.println("\t 'Test Text 2' 2nd way: " +
                driver.findElement(By.cssSelector("div#test1 p.twoTest")).getText() + "'");

//        1-2 ways to find text: "Test Text 3"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'Test Text 3' 1st way: " +
                driver.findElement(By.cssSelector("div#test3 p:first-child")).getText() + "'");
        System.out.println("\t 'Test Text 2' 2nd way: " +
                driver.findElement(By.cssSelector("div#test3 p:nth-child(1)")).getText() + "'");

//        1-2 ways to find text: "This is also a button"
        System.out.println("\n------------------------\n");
        System.out.println("\t 'This is also a button' 1st way: " +
                driver.findElement(By.cssSelector("input[name=\"randomButton2\"]")).getAttribute("value") + "'");

        System.out.println("\t 'This is also a button' 2nd way: " +
                driver.findElement(By.cssSelector("input#buttonID")).getAttribute("value") + "'");



    }
}
