//Job: Given some input of some format, returns a mapping from URLs to the data to be entered in them.

import java.util.*;

public interface FormParser {

    public void doParse(Scanner scanner);
    public Vector<Form> getForms();

}
