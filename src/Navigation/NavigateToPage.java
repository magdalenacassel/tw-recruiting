package Navigation;

import org.openqa.selenium.WebDriver;

public class NavigateToPage {
  WebDriver driver;

  public NavigateToPage(WebDriver driver) {
    this.driver = driver;
  }

  public void goToPage(String url) {
    driver.get(url);
  }
}
