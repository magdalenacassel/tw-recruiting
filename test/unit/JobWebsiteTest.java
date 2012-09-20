
package unit;

import field.Field;
import navigation.JobWebsite;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;

public class JobWebsiteTest {

    public static final String PASSWORD = "JC10064";
    WebDriver driver;
    JobWebsite jobWebsite;

    //

    @Before
    public void setUp(){
        driver = mock(WebDriver.class);
        jobWebsite = new JobWebsite(driver);
    }

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
