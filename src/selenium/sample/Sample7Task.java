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
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
//         TODO:
//        check that none of the checkboxes are ticked
//        tick  "Option 2"
//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
//        tick  "Option 3"
//        click result
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".w3-check[type='checkbox']"));
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='checkbox']"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        WebElement option3 = driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='checkbox']"));

//        check that none of the checkboxes are ticked
        for (WebElement checkBox : checkBoxes) {
            assertFalse(checkBox.isSelected()); // checkboxes are NOT selected
        }

//        tick  "Option 2"
//        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='checkbox']"));
        option2.click();

//        check that "Option 1" and "Option 3" are not ticked, but "Option 2" is ticked
        assertFalse(option1.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option2.isSelected());

//        tick  "Option 3"
        option3.click();

//        click result
        WebElement resultButton = driver.findElement(By.id("result_button_checkbox"));   // Result button
        resultButton.click(); // clicking on "Result" button

//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        WebElement resultText = driver.findElement(By.id("result_checkbox"));   //Result text
        assertEquals("You selected value(s): Option 2, Option 3",resultText.getText()); // checking that text is empty

    }


    @Test
    public void selectRadioButton() throws Exception {
//         TODO:
//        check that none of the radio are selected
//        select  "Option 3"
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
//        select  "Option 1"
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
//        click result
//        check that 'You selected option: Option 1' text is being displayed

        List<WebElement> radioButtons = driver.findElements(By.cssSelector(".w3-check[type='radio']"));
        WebElement option1 = driver.findElement(By.cssSelector(".w3-check[value='Option 1'][type='radio'"));
        WebElement option2 = driver.findElement(By.cssSelector(".w3-check[value='Option 2'][type='radio'"));
        WebElement option3= driver.findElement(By.cssSelector(".w3-check[value='Option 3'][type='radio'"));

//        check that none of the radio are selected
        for (WebElement radioButton : radioButtons) {
            assertFalse(radioButton.isSelected()); // radio are NOT selected
        }

//        select  "Option 3"
        option3.click();

//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertFalse(option1.isSelected());
        assertFalse(option2.isSelected());
        assertTrue(option3.isSelected());

//        select  "Option 1"
        option1.click();

//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertFalse(option2.isSelected());
        assertFalse(option3.isSelected());
        assertTrue(option1.isSelected());

//        click result
        WebElement resultButton = driver.findElement(By.id("result_button_ratio"));   // Result button
        resultButton.click(); // clicking on "Result" button

//        check that 'You selected option: Option 1' text is being displayed
        WebElement resultText = driver.findElement(By.id("result_radio"));   //Result text
        assertEquals("You selected option: Option 1",resultText.getText()); // checking that text is empty

    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
//        check that selected option is "Option 3"
//        select "Option 2" in Select
//        check that selected option is "Option 2"
//        click result
//        check that 'You selected option: Option 2' text is being displayed

        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));

//        select "Option 3" in Select
        dropdown.selectByValue("value3");

//        check that selected option is "Option 3"
        assertEquals("Option 3", dropdown.getFirstSelectedOption().getText());

//        select "Option 2" in Select
        dropdown.selectByValue("value2");

//        check that selected option is "Option 2"
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

//        click result
//        check that 'You selected option: Option 2' text is being displayed
//        click result
        WebElement resultButton = driver.findElement(By.id("result_button_select"));   // Result button
        resultButton.click(); // clicking on "Result" button

//        check that 'You selected option: Option 1' text is being displayed
        WebElement resultText = driver.findElement(By.id("result_select"));   //Result text
        assertEquals("You selected option: Option 2",resultText.getText()); // checking that text is empty
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//         TODO:
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
//        Calendar cal = Calendar.getInstance();

        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.clear();
        assertEquals("", dateBox.getAttribute("value"));
        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        WebElement calBack = dateWidget.findElement(By.className("ui-datepicker-prev"));
        WebElement calMonth = dateWidget.findElement(By.className("ui-datepicker-month"));
        WebElement calYear = dateWidget.findElement(By.className("ui-datepicker-year"));

        String currMonth="";
        String currYear="";

        while (!((currMonth.equals("July")) && (currYear.equals("2007")))) {

            calBack.click();
            Thread.sleep(100);
            calBack = dateWidget.findElement(By.className("ui-datepicker-prev"));
            calMonth = dateWidget.findElement(By.className("ui-datepicker-month"));
            calYear = dateWidget.findElement(By.className("ui-datepicker-year"));
            currMonth=calMonth.getText();
            currYear=calYear.getText();
        }


        dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        WebElement dateButton = dateWidget.findElement(By.xpath("//a[text()='4']"));
        dateButton.click();

        WebElement resultButton = driver.findElement(By.id("result_button_date"));   // Result button
        resultButton.click(); // clicking on "Result" button
        Thread.sleep(2000);

//        check that 'You selected option: Option 1' text is being displayed
        WebElement resultText = driver.findElement(By.id("result_date"));   //Result text
        assertEquals("You entered date: 07/04/2007",resultText.getText()); // checking that text is empty


    }


    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//         TODO:
//        enter date '2 of May 1959' using text
//        check that correct date is added

//        enter date '2 of May 1959' using text
        WebElement dateBox = driver.findElement(By.id("vfb-8"));
        dateBox.clear();
        assertEquals("", dateBox.getAttribute("value"));
        dateBox.click();
        dateBox.sendKeys("02/05/1959");
        dateBox.sendKeys("keys.ENTER");

// take of calendar
        WebElement dateElem = driver.findElement(By.cssSelector("body > div:nth-child(3) > div:nth-child(3) > div"));
        dateElem.click();

// push result button
        WebElement resultButton = driver.findElement(By.id("result_button_date"));   // Result button
        resultButton.click(); // clicking on "Result" button

//        check that 'You selected option: Option 1' text is being displayed
        WebElement resultText = driver.findElement(By.id("result_date"));   //Result text
        assertEquals("You entered date: 02/05/1959",resultText.getText()); // checking that text is empty

    }
}
