<<<<<<< HEAD
package unit;

import Navigation.JobWebsite;
=======

package unit;

import navigation.JobWebsite;
>>>>>>> 4f697b2790ec5a1e32b9851c3679a9bf4e0a6430
import field.Field;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class JobWebsiteTest {

<<<<<<< HEAD
    public static final String PASSWORD = "JC10064";
    WebDriver driver;
  JobWebsite jobWebsite;

  @Before
  public void setUp(){
      driver = mock(WebDriver.class);
      jobWebsite = new JobWebsite(driver);
  }
=======
    public static final String PASSWORD = "foobar";
    WebDriver driver;
    JobWebsite jobWebsite;

    //

    @Before
    public void setUp(){
        driver = mock(WebDriver.class);
        jobWebsite = new JobWebsite(driver);
    }
>>>>>>> 4f697b2790ec5a1e32b9851c3679a9bf4e0a6430

    @Test
    public void shouldNavigateToLoginPageAndLogin(){
        String username = "jconnors@thoughtworks.com";
        String password = PASSWORD;
        WebElement element = mock(WebElement.class);
        when(driver.findElement(By.id("username"))).thenReturn(element);
        when(driver.findElement(By.id("password"))).thenReturn(element);
        when(driver.findElement(By.className("btn_go"))).thenReturn(element);
        this.jobWebsite.login("https://caltech-csm.symplicity.com/employers/", username, password);
        verify(driver).get("https://caltech-csm.symplicity.com/employers/");
        verify(element).click();
    }

    @Test
    public void shouldGoToFormPageAndFillOutForm() {
        Field field = mock(Field.class);
        jobWebsite.fillOutForm("https://caltech-csm.symplicity.com/employers/index.php?s=jobs&ss=jobs&mode=form&id=&_ksl=1",field,field,field);
        verify(field,times(3)).enter();
        verify(driver).get("https://caltech-csm.symplicity.com/employers/index.php?s=jobs&ss=jobs&mode=form&id=&_ksl=1");
    }


}
