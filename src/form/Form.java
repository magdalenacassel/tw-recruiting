package form;

import field.Field;

import java.util.ArrayList;


public class Form {
    private String url;
    private ArrayList<Field> fields;

    public Form(String url, ArrayList<Field> fields) {
        this.url = url;
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Form form = (Form) o;

        if (fields != null ? !fields.equals(form.fields) : form.fields != null) return false;
        if (url != null ? !url.equals(form.url) : form.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        return result;
    }
}
