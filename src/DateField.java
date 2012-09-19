import org.apache.xpath.operations.String;
import org.openqa.selenium.JavascriptExecutor;

public class DateField implements Field {
  private JavascriptExecutor driver;
  private String id;
  private String texts;

  public DateField(JavascriptExecutor driver, String id, String text) {
    this.driver = driver;
    this.id = id;
    this.texts = text;
  }

  @Override
  public void enter() {
    driver.executeScript("document.getElementByID('" + id + "').setAttribute('value','" + texts + "')");
  }
}
