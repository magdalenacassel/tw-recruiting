import Navigation.NavigateToPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NavigateToPageTest {
  @Test
  public void shouldLogOntoCorrectPage() {
    WebDriver driver = mock(WebDriver.class);
    NavigateToPage navigateToPage = new NavigateToPage(driver);
    navigateToPage.goToPage("www.tw.com");
    verify(driver).get("www.tw.com");
  }
}
