package field;

import field.Field;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectField implements Field {
  private String[] texts;
  private Select select;

  public void setSelect(Select select) {
    this.select = select;
  }

  public SelectField(WebDriver driver, String id, String... texts) {
    this.texts = texts;
    select = new Select(driver.findElement(By.id(id)));
  }

  @Override
  public void enter() {
    select.deselectAll();
    for (String text : texts) {
      select.selectByValue(text);
    }
  }
}
