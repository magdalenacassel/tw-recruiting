package Navigation;

import field.Field;
import field.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobWebsite {
  WebDriver driver;

  public JobWebsite(WebDriver driver) {
    this.driver = driver;
  }

  public void goToPage(String url) {
    driver.get(url);
  }

    public void login(String url, String username, String password) {
        driver.get(url);
        TextField usernameField = new TextField(driver, "username", username);
        TextField passwordField = new TextField(driver, "password", password);
        WebElement goButton = driver.findElement(By.className("btn_go"));
        usernameField.enter();
        passwordField.enter();
        goButton.click();
    }

    public void fillOutForm(String url, Field... fields) {
        driver.get(url);
        for (Field field : fields) {
            field.enter();
        }
    }
}
