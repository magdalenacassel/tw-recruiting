import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Field {
    private WebDriver webDriver;
    private String id;

    public Field(WebDriver webDriver, String id) {
        this.webDriver = webDriver;
        this.id = id;
    }

    private WebElement getById(String name) {
        return webDriver.findElement(By.id(name));
    }

    public void enterText(String text) {
        WebElement element = getById(id);
        element.sendKeys(text);
    }

    public void selectFromMultipleOptions(String text, Select options) {
        options.selectByValue(text);
    }

    public void selectMultiOption(Select select, String... texts) {
        select.deselectAll();
        for (String text: texts){
            select.selectByValue(text);
        }
    }
}
