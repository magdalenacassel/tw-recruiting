package navigation;

import field.Field;
import field.TextField;
import form.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashMap;

public class JobWebsite {
    WebDriver driver;
    private LinkedHashMap<String, Form> urlToForm;

    public JobWebsite(WebDriver driver, LinkedHashMap<String, Form> urlToForm) {
        this.driver = driver;
        this.urlToForm = urlToForm;
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

    public void doWebsite() {
        for (String url : urlToForm.keySet()) {
            driver.get(url);
            urlToForm.get(url).fillOut();
        }
    }

    public void fillOutForm(String url, Field... fields) {
        driver.get(url);
        for (Field field : fields) {
            field.enter();
        }
    }
}
