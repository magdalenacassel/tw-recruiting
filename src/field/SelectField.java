package field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

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
      try {
          select.deselectAll();
      } catch (UnsupportedOperationException uoe) {
          //We don't care.
      }

    for (String text : texts) {
      select.selectByValue(text);
    }
  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectField that = (SelectField) o;

        if (!Arrays.equals(texts, that.texts)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(texts);
    }
}
