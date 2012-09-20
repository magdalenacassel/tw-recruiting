import field.Field;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileParser implements FormParser {
    private WebDriver driver;

    private Vector<Form> forms;
    public static final String fileName = "data.csv";

    public FileParser(WebDriver driver){
        this.driver = driver;
        forms = new Vector<Form>();
        //go();
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
        FieldParser parser = new LineParser(driver);

        while(fileScanner.hasNext()){
            String line = fileScanner.next();
            if (!line.contains("url")){
                Field field = parser.parse(line);
                currentFields.add(field);
            } else {
                forms.add(new Form(currentURL,currentFields));
                currentURL = line.substring(4);
                currentFields = new ArrayList<Field>();
            }
        }

        forms.add(new Form(currentURL,currentFields));
    }

    @Override
    public Vector<Form> getForms() {
         return forms;
    }
}
