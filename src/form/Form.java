package form;

import field.Field;

import java.util.ArrayList;
import java.util.Arrays;


public class Form {
    private Field[] fields;

    public Form(Field... fields) {
        this.fields = fields;
    }

    public void fillOut() {
        for (Field field : fields) {
            field.enter();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Form form = (Form) o;

        if (!Arrays.equals(fields, form.fields)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return fields != null ? Arrays.hashCode(fields) : 0;
    }
}
