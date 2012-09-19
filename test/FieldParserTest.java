import field.Field;
import field.ClickField;
import field.DateField;
import field.SelectField;
import field.TextField;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FieldParserTest {

    private WebDriver driver;
    private FieldParser fieldParser;

    @Before
    public void setUp() throws Exception {
        driver = mock(HtmlUnitDriver.class);
        fieldParser = new FieldParser(driver);
    }

    @Test
    public void shouldGetTextFieldObjectFromAppropriateString() {

        String input = "text,username,jconnors@thoughtworks.com";
        Field field = fieldParser.parse(input);

        assertTrue(field instanceof TextField);

        TextField actual = (TextField) field;

        TextField expected = new TextField(driver, "username", "jconnors@thoughtworks.com");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSelectFieldObjectFromAppropriateString() {
        WebElement mockElement = mock(WebElement.class);
        when(mockElement.getTagName()).thenReturn("select");
        when(driver.findElement(any(By.class))).thenReturn(mockElement);


        String input = "select,selectId,text1";

        Field field = fieldParser.parse(input);

        assertTrue(field instanceof SelectField);

        SelectField actual = (SelectField) field;
        SelectField expected = new SelectField(driver, "selectId", "text1");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetClickFieldFromAppropriateString() {

        String input = "click,clickID";

        Field field = fieldParser.parse(input);
        assertTrue(field instanceof ClickField);
    }

    @Test
    public void shouldGetDateFieldFromAppropriateString() {
        String input = "date,dateId,texts";

        Field field = fieldParser.parse(input);
        assertTrue(field instanceof DateField);
    }

}
