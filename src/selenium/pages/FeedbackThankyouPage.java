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


public class FeedbackThankyouPage {

    @FindBy(how = How.CSS, using = "h2#message")
    private WebElement message;

    @FindBy(how = How.CSS, using = "div.w3-green")
    private WebElement messageBox;

    public void checkMessage(String txt) {
        assertEquals(txt, message.getText());
    }

    public void checkMessageboxColors() {
        assertEquals("rgba(76, 175, 80, 1)", messageBox.getCssValue("background-color"));
        assertEquals("rgba(255, 255, 255, 1)", messageBox.getCssValue("color"));

    }

}
