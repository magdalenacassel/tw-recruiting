package field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClickField implements Field {
  private final WebDriver driver;
  private final String[] ids;

  public ClickField(WebDriver driver, String... ids) {
    this.driver = driver;
    this.ids = ids;
  }

  @Override
  public void enter() {
    for (String id : ids) {
      driver.findElement(By.id(id)).click();
    }
  }
}
