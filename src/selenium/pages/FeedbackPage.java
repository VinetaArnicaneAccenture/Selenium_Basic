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

public class FeedbackPage extends GenericSamplePage {
    @FindBy(how = How.ID, using = "fb_name")
    private WebElement nameInput;

    @FindBy(how = How.ID, using = "fb_age")
    private WebElement ageInput;

    @FindBy(how = How.CSS, using = "textarea.w3-input")
    private WebElement commentText;

    @FindBy(how = How.CSS, using = "form > div > input.w3-check")
    private List<WebElement> languageCheckboxes;
    @FindBy(how = How.CSS, using = "input[value=\"English\"]")
    private WebElement englishCheckbox;
    @FindBy(how = How.CSS, using = "input[value=\"French\"]")
    private WebElement frenchCheckbox;
    @FindBy(how = How.CSS, using = "input[value=\"Spanish\"]")
    private WebElement spanishCheckbox;
    @FindBy(how = How.CSS, using = "input[value=\"Chinese\"]")
    private WebElement chineseCheckbox;

    @FindBy(how = How.CSS, using = "form > div > input.w3-radio")
    private List<WebElement> genreRadiobuttons;
    @FindBy(how = How.CSS, using = "input[value=\"male\"]")
    private WebElement maleRadiobutton;
    @FindBy(how = How.CSS, using = "input[value=\"female\"]")
    private WebElement femaleRadiobutton;
    @FindBy(how = How.CSS, using = "input.w3-radio:nth-of-type(3)")
    private WebElement dontknowRadiobutton;


    @FindBy(how = How.ID, using = "like_us")
    private WebElement toLikesDropdown;

    @FindBy(how = How.CSS, using = "textarea.w3-input")
    private WebElement commentInput;

    @FindBy(how = How.CSS, using = "button.w3-btn-block ")
    private WebElement sendButton;

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void checkName(String name) {
        assertEquals(name, nameInput.getAttribute("value") );
    }

    public void enterAge(String age) {
        ageInput.clear();
        ageInput.sendKeys(age);
    }

    public void checkAge(String age) {
        assertEquals(age, ageInput.getAttribute("value") );
    }

    public void selectAllLanguages() {
        for (WebElement checkBox : languageCheckboxes) {
            if (!checkBox.isSelected()) {
                checkBox.click();
            }
        }
    }

    public void unselectAllLanguages() {
        for (WebElement checkBox : languageCheckboxes) {
            if (checkBox.isSelected()) {
                checkBox.click();
            }
        }
    }

    public void checkIfSelectedAllLanguages() {
        for (WebElement checkBox : languageCheckboxes) {
            assertTrue(checkBox.isSelected());
        }
    }

    public void checkIfUnselectedAllLanguages() {
        for (WebElement checkBox : languageCheckboxes) {
            assertFalse(checkBox.isSelected());
        }
    }

    public void selectLanguage(String languageText) {

        WebElement option = englishCheckbox;
        switch (languageText) {
            case "English":
                option = englishCheckbox;
                break;
            case "French":
                option = frenchCheckbox;
                break;
            case "Spanish":
                option = spanishCheckbox;
                break;
            case "Chinese":
                option = chineseCheckbox;
                break;

            default:
                System.out.println("No such language: " + languageText);
        }
        if (!option.isSelected()) {
            option.click();
        }

    }

    public void unselectLanguage(String languageText) {

        WebElement option = englishCheckbox;
        switch (languageText) {
            case "English":
                option = englishCheckbox;
                break;
            case "French":
                option = frenchCheckbox;
                break;
            case "Spanish":
                option = spanishCheckbox;
                break;
            case "Chinese":
                option = chineseCheckbox;
                break;

            default:
                System.out.println("No such language: " + languageText);
        }
        if (!option.isSelected()) {
            return;
        }
        option.click();

    }

    public void setdefaultGenre() {
        dontknowRadiobutton.click();
    }

    public void setGenre(String genre) {

        WebElement rButton = dontknowRadiobutton;
        switch (genre) {
            case "male":
                rButton = maleRadiobutton;
                break;
            case "female":
                rButton = femaleRadiobutton;
                break;
            case "Don't know (Disabled)":
                rButton = dontknowRadiobutton;
                break;
            default:
                System.out.println("No such genre: " + genre);
        }
        rButton.click();
    }

    public void checkGenre(String genre) {

        WebElement rButton = dontknowRadiobutton;
        switch (genre) {
            case "male":
                rButton = maleRadiobutton;
                break;
            case "female":
                rButton = femaleRadiobutton;
                break;
            case "Don't know (Disabled)":
                rButton = dontknowRadiobutton;
                break;
            default:
                System.out.println("No such genre: " + genre);
        }
        assertTrue(rButton.isSelected());
    }



    public void checkDefaultGenreSelected() {
        assertFalse(maleRadiobutton.isSelected());
        assertFalse(femaleRadiobutton.isSelected());
        assertTrue(dontknowRadiobutton.isSelected());
    }


    public void selectLikesByText(String optionText) {
        Select likesDropdown = new Select(toLikesDropdown);
        likesDropdown.selectByVisibleText(optionText);
    }

    public void selectLikesByIndex(int index) {
        Select likesDropdown = new Select(toLikesDropdown);
        likesDropdown.selectByIndex(index);
    }

    public void checkLikesDefaultOptionSelected() {
        Select likesDropdown = new Select(toLikesDropdown);
        assertEquals("Choose your option", likesDropdown.getFirstSelectedOption().getText());
    }

    public void checkLikesOptionSelected(String optionTxt) {
        Select likesDropdown = new Select(toLikesDropdown);
        assertEquals(optionTxt, likesDropdown.getFirstSelectedOption().getText());
    }

    public void enterComment(String comment) {
        commentInput.clear();
        commentInput.sendKeys(comment);
    }

    public void checkComment(String comment) {
        assertEquals(comment, commentInput.getAttribute("value"));
    }


    public void clickSend() {
        sendButton.click();
    }

    public void checkSendButtonIsBlueAndWhite() {
        assertEquals("rgba(33, 150, 243, 1)", sendButton.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", sendButton.getCssValue("color"));
    }

}

