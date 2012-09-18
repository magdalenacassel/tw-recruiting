import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FieldTest {
    private WebElement webElement;
    private WebDriver webDriver;

    @Before
    public void setUp() throws Exception {
        webDriver = mock(WebDriver.class);
        webElement = mock(WebElement.class);
        when(webDriver.findElement(any(By.class))).thenReturn(webElement);
    }

    @Test
    public void shouldEnterTextInTextInput() {
        Field field = new Field(webDriver, "name");
        field.enterText("text");
        verify(webElement).sendKeys("text");
    }

    @Test
    public void shouldClickOnAppropriateCheckbox() {
        Field field = new Field(webDriver, "position");
        Select select = mock(Select.class);
        field.selectFromMultipleOptions("Full Time", select);
        verify(select).selectByValue("Full Time");
    }

    @Test
    public void shouldSelectAllAppropriateCheckboxes() {
        Field field = new Field(webDriver, "receipt");
        Select select = mock(Select.class);
        field.selectMultiOption(select, "E-mail","Other");
        verify(select).deselectAll();
        verify(select).selectByValue("E-mail");
        verify(select).selectByValue("Other");
    }
}
