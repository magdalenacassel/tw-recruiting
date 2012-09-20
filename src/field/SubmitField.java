package field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitField implements Field{
    private final WebDriver driver;
    private final String className;

    public SubmitField(WebDriver driver, String className) {
        this.driver = driver;
        this.className = className;
    }

    @Override
    public void enter() {
        driver.findElement(By.className(className)).click();
    }
}
