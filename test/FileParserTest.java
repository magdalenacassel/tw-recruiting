import org.junit.Test;

import field.Field;
import field.TextField;
import field.SelectField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FileParserTest {

    @Test
    public void shouldReturnSingleStringToFieldsPair() {
        WebDriver driver = mock(WebDriver.class);
        WebElement mockElement = mock(WebElement.class);
        when(mockElement.getTagName()).thenReturn("select");
        when(driver.findElement(any(By.class))).thenReturn(mockElement);


        FormParser formParser = new FileParser(driver);
        String input = "url,url\ntext,id,content\ntext,id,content\nurl,url2\nselect,id,value";
        Scanner scanner = new Scanner(input);

        formParser.doParse(scanner);
        Vector<Form> actual = formParser.getForms();

        Vector<Form> expected = new Vector<Form>();
        ArrayList<Field> fields = new ArrayList<Field>();
        fields.add(new TextField(driver, "id", "content"));
        fields.add(new TextField(driver, "id", "content"));

        ArrayList<Field> fields2 = new ArrayList<Field>();
        fields2.add(new SelectField(driver, "id", "value"));

        expected.add(new Form("url", fields));
        expected.add(new Form("url2", fields2));

        assertEquals(expected, actual);
    }

}
