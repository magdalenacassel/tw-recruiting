package field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextField implements Field {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextField textField = (TextField) o;

        if (id != null ? !id.equals(textField.id) : textField.id != null) return false;
        if (text != null ? !text.equals(textField.text) : textField.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
