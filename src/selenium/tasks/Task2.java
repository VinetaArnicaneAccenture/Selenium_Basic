package selenium.tasks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pages.FeedbackAnswerPage;
import selenium.pages.FeedbackPage;
import selenium.pages.FeedbackThankyouPage;

import java.io.File;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class Task2 {
    WebDriver driver;
    static FeedbackPage feedbackPage;
    static FeedbackAnswerPage feedbackAnswerPage;
    static FeedbackThankyouPage feedbackThankyouPage;
    @Before
    public void openPage() {
        String libWithDriversLocation = System.getProperty("user.dir") + File.separator + "lib" + File.separator;
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver" + new selenium.ChangeToFileExtension().extension());
        driver = new ChromeDriver();
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
        feedbackPage = PageFactory.initElements(driver, FeedbackPage.class);
        feedbackAnswerPage = PageFactory.initElements(driver, FeedbackAnswerPage.class);
        feedbackThankyouPage = PageFactory.initElements(driver, FeedbackThankyouPage.class);

    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void initialFeedbackPage() throws Exception {
//         TODO:
//         check that all field are empty and no tick are clicked
//         "Don't know" is selected in "Genre"
//         "Choose your option" in "How do you like us?"
//         check that the button send is blue with white letters
       feedbackPage.checkName("");
       feedbackPage.checkAge("");
       feedbackPage.checkIfUnselectedAllLanguages();
       feedbackPage.checkDefaultGenreSelected();
       feedbackPage.checkLikesDefaultOptionSelected();
       feedbackPage.checkComment("");
       feedbackPage.checkSendButtonIsBlueAndWhite();

    }

    @Test
    public void emptyFeedbackPage() throws Exception {
//         TODO:
//         click "Send" without entering any data
//         check fields are empty or null
//         check button colors
//         (green with white letter and red with white letters)

        feedbackPage.clickSend();

        feedbackAnswerPage.checkName("");
        feedbackAnswerPage.checkAge("");
        feedbackAnswerPage.checkLanguage("");
        feedbackAnswerPage.checkGenre("null");
        feedbackAnswerPage.checkLike("null");
        feedbackAnswerPage.checkComment("");
        feedbackAnswerPage.checkYesButtonColors();
        feedbackAnswerPage.checkNoButtonColors();

    }

    @Test
    public void notEmptyFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form, click "Send"
//         check fields are filled correctly
//         check button colors
//         (green with white letter and red with white letters)

        String name="Anna";
        String age = "54";
        String genre = "female";
        String like ="Ok, i guess";
        String comment = "My brief comment";

        feedbackPage.enterName(name);
        feedbackPage.enterAge(age);
        feedbackPage.selectAllLanguages();
        feedbackPage.setGenre(genre);
        feedbackPage.selectLikesByText(like);
        feedbackPage.enterComment(comment);
        feedbackPage.clickSend();

        feedbackAnswerPage.checkName(name);
        feedbackAnswerPage.checkAge(age);
        feedbackAnswerPage.checkLanguage("English,French,Spanish,Chinese");
        feedbackAnswerPage.checkGenre(genre);
        feedbackAnswerPage.checkLike(like);
        feedbackAnswerPage.checkComment(comment);
        feedbackAnswerPage.checkYesButtonColors();
        feedbackAnswerPage.checkNoButtonColors();

    }

    @Test
    public void yesOnWithNameFeedbackPage() throws Exception {
//         TODO:
//         enter only name
//         click "Send"
//         click "Yes"
//         check message text: "Thank you, NAME, for your feedback!"
//         color of text is white with green on the background
        String name="Anna";
        feedbackPage.enterName(name);
        feedbackPage.clickSend();
        driver.findElement(By.cssSelector("button.w3-green")).click();

        feedbackThankyouPage.checkMessage("Thank you, " + name +", for your feedback!");
        feedbackThankyouPage.checkMessageboxColors();

    }

    @Test
    public void yesOnWithoutNameFeedbackPage() throws Exception {
//         TODO:
//         click "Send" (without entering anything
//         click "Yes"
//         check message text: "Thank you for your feedback!"
//         color of text is white with green on the background
        feedbackPage.clickSend();
        driver.findElement(By.cssSelector("button.w3-green")).click();

        feedbackThankyouPage.checkMessage("Thank you for your feedback!");
        feedbackThankyouPage.checkMessageboxColors();

    }

    @Test
    public void noOnFeedbackPage() throws Exception {
//         TODO:
//         fill the whole form
//         click "Send"
//         click "No"
//         check fields are filled correctly
        String name="Anna";
        String age = "54";
        String genre = "female";
        String like ="Ok, i guess";
        String comment = "My brief comment";

        feedbackPage.enterName(name);
        feedbackPage.enterAge(age);
        feedbackPage.selectAllLanguages();
        feedbackPage.setGenre(genre);
        feedbackPage.selectLikesByText(like);
        feedbackPage.enterComment(comment);
        feedbackPage.clickSend();

        driver.findElement(By.cssSelector("button.w3-red")).click();


        feedbackPage.checkName(name);
        feedbackPage.checkAge(age);
        feedbackPage.checkIfSelectedAllLanguages();
        feedbackPage.checkGenre(genre);
        feedbackPage.checkLikesOptionSelected(like);
        feedbackPage.checkComment(comment);

    }
}
