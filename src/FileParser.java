import field.Field;

import form.Form;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileParser  {
    private WebDriver driver;

    private LinkedHashMap<String, Form> forms;
    public static final String fileName = "data.csv";

    public FileParser(WebDriver driver){
        this.driver = driver;
        forms = new LinkedHashMap<String,Form>();
    }

    private void go() {
        File file = new File(fileName);
        Scanner fileScanner = null;
        try{
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        doParse(fileScanner);
    }

    public void doParse(Scanner fileScanner) {
        String currentURL = fileScanner.next().substring(4);
        ArrayList<Field> currentFields = new ArrayList<Field>();
        LineParser parser = new LineParser(driver);

        while(fileScanner.hasNext()){
            String line = fileScanner.next();
            if (!line.contains("url")){
                Field field = parser.parse(line);
                currentFields.add(field);
            } else {
                forms.put(currentURL, new Form(currentFields.toArray(new Field[]{})));
                currentURL = line.substring(4);
                currentFields = new ArrayList<Field>();
            }
        }

        forms.put(currentURL,new Form(currentFields.toArray(new Field[]{})));
    }

    public LinkedHashMap<String,Form> getForms() {
         return forms;
    }
}
