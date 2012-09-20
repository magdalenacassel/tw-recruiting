package unit;

import form.Form;
import navigation.JobWebsite;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JobWebsiteTest {
    public static final String PASSWORD = "foobar";

    @Test
    public void shouldNavigateToLoginPageAndLogin(){
        String url = "google.com";
        WebDriver driver = mock(WebDriver.class);
        LinkedHashMap<String,Form> loginUrlAndForm = mock(LinkedHashMap.class);
        Form form = mock(Form.class);
        when(loginUrlAndForm.get(url)).thenReturn(form);
        Set<String> urls = new HashSet<>();
        urls.add(url);
        when(loginUrlAndForm.keySet()).thenReturn(urls);
        JobWebsite jobWebsite = new JobWebsite(driver,loginUrlAndForm);
        jobWebsite.doWebsite();
        verify(driver).get(url);
        verify(form).fillOut();
    }
}
