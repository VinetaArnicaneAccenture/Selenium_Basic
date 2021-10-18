package selenium.sample;
//
//  @author = Vineta Arnicane
//

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Sample1Task {
    static String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;

    @Test
    public void goToHomepage() throws Exception {
//        TODO:
//         define driver
//         go to https://kristinek.github.io/site/index2.html
//         get URL of current page
//         close browser

//         define driver
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        WebDriver driver = new ChromeDriver();

        System.out.println("");

//         go to https://kristinek.github.io/site/index2.html
        driver.get("https://kristinek.github.io/site/index2.html");

//         get title of page
        System.out.println("Title of window:: "+driver.getTitle());

        //         get URL of current page
        System.out.println("Current URL:: "+driver.getCurrentUrl());

        //Close browser
        driver.quit();

    }
}
