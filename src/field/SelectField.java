package field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;

public class SelectField implements Field {

    private final WebDriver driver;
    private final String id;
    private String[] texts;
    private Select select = null;

    public void setSelect(Select select) {
        if (select == null) {
            this.select = new Select(driver.findElement(By.id(id)));
        } else {
            this.select = select;
        }
    }

    public SelectField(WebDriver driver, String id, String... texts) {
        this.driver = driver;
        this.id = id;
        this.texts = texts;
    }

    @Override
    public void enter() {
        setSelect(select);
        if (select.isMultiple()) select.deselectAll();
        for (String text : texts) {
            select.selectByVisibleText(text);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectField that = (SelectField) o;

        if (!Arrays.equals(texts, that.texts)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(texts);
    }
}
