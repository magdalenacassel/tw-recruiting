import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextField implements Field{
  private String id;
  private String text;
  private WebDriver driver;

  public TextField(WebDriver driver, String id, String text) {
    this.driver = driver;
    this.id = id;
    this.text = text;
  }

  public void enter() {
    WebElement element = driver.findElement(By.id(id));
    element.sendKeys(text);
  }
}
