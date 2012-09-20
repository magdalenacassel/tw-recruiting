package form;

import field.Field;

public class Form {
  public void fillOut(Field... Fields) {
    for (Field field : Fields) {
      field.enter();
    }
  }
}
