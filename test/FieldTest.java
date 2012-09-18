import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FieldTest {
  private HtmlUnitDriver driver;
  private WebElement webElement;

  @Before
  public void setUp() throws Exception {
    driver = mock(HtmlUnitDriver.class);
    webElement = mock(WebElement.class);
    when(driver.findElement(any(By.class))).thenReturn(webElement);
  }

  @Test
  public void shouldEnterTextInTextInput() {
    TextField textField = new TextField(driver, "name", "text");
    textField.enter();
    verify(webElement).sendKeys("text");
  }

  @Test
  public void shouldSelectAllAppropriateSelections() {
    Select select = mock(Select.class);
    when(webElement.getTagName()).thenReturn("select");
    SelectField selectField = new SelectField(driver,"receipt","E-mail","Other");
    selectField.setSelect(select);
    selectField.enter();
    verify(select).selectByValue("E-mail");
    verify(select).selectByValue("Other");
  }

  @Test
  public void shouldChangeDateInCalendar() {
    DateField dateField = new DateField(driver, "calendar", "2020-01-01");
    dateField.enter();
    verify(driver).executeScript("document.getElementByID('calendar').setAttribute('value','2020-01-01')");
  }
}
