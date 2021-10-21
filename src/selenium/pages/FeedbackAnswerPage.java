package selenium.pages;
//
//  @author = Vineta Arnicane
//
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import java.util.List;


public class FeedbackAnswerPage extends GenericSamplePage {
    @FindBy(how = How.CSS, using = "span#name")
    private WebElement name;

    @FindBy(how = How.CSS, using = "span#age")
    private WebElement age;

    @FindBy(how = How.CSS, using = "span#language")
    private WebElement language;

    @FindBy(how = How.CSS, using = "span#gender")
    private WebElement genre;

    @FindBy(how = How.CSS, using = "span#option")
    private WebElement like;

    @FindBy(how = How.CSS, using = "span#comment")
    private WebElement comment;

    @FindBy(how = How.CSS, using = "button.w3-green")
    private WebElement yesButton;

    @FindBy(how = How.CSS, using = "button.w3-red")
    private WebElement noButton;

    public void checkName(String txt) {
//        System.out.println("NAME:: ", name.getText());
        assertEquals(txt, name.getText());
    }

    public void checkAge(String txt) {
        assertEquals(txt, age.getText());
    }

    public void checkLanguage(String txt) {
        assertEquals(txt, language.getText());
    }

    public void checkGenre(String txt) {
        assertEquals(txt, genre.getText());
    }

    public void checkLike(String txt) {
        assertEquals(txt, like.getText());
    }

    public void checkComment(String txt) {
        assertEquals(txt, comment.getText());
    }

    public void clickYesButton() {
        yesButton.click();
    }

    public void clickNoButton() {
        noButton.click();
    }

    public void checkYesButtonColors() {
        assertEquals("rgba(76, 175, 80, 1)", yesButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", yesButton.getCssValue("color"));
    }
    public void checkNoButtonColors() {
        assertEquals("rgba(244, 67, 54, 1)", noButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", noButton.getCssValue("color"));
    }

}

