package navigation;

import form.Form;
import org.openqa.selenium.WebDriver;

import java.util.LinkedHashMap;

public class JobWebsite {
    WebDriver driver;
    private LinkedHashMap<String, Form> urlToForm;

    public JobWebsite(WebDriver driver, LinkedHashMap<String, Form> urlToForm) {
        this.driver = driver;
        this.urlToForm = urlToForm;
    }

    public void doWebsite() {
        for (String url : urlToForm.keySet()) {
            driver.get(url);
            urlToForm.get(url).fillOut();
        }
    }
}
