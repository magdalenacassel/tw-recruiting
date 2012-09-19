import field.Field;
import field.ClickField;
import field.DateField;
import field.SelectField;
import field.TextField;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

public class FieldParser {
    private WebDriver driver;
    private final static String delimiter = ",";

    public FieldParser(WebDriver driver) {

        this.driver = driver;
    }

    public Field parse(String line) {
        String[] result = line.split(delimiter);

        switch(result[0]){
            case "text":
                return new TextField(driver, result[1], result[2]);
            case "select":
                String[] texts = Arrays.copyOfRange(result,2,result.length);
                return new SelectField(driver,result[1],texts);
            case "click":
                String[] clickTexts = Arrays.copyOfRange(result,1,result.length);
                return new ClickField(driver, clickTexts);
            case "date":
                return new DateField((JavascriptExecutor)driver,result[1],result[2]);
            default:
                throw new RuntimeException("Bad argument to FieldParser.parse()");
        }
    }
}
