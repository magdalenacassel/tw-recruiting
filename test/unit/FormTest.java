package unit;

import field.DateField;
import field.SelectField;
import field.TextField;
import form.Form;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FormTest {
    @Test
    public void shouldFillOutMultipleFields() {
        TextField name = mock(TextField.class);
        DateField expiration = mock(DateField.class);
        SelectField position = mock(SelectField.class);
        Form form = new Form();
        form.fillOut(name,expiration,position);
        verify(name).enter();
        verify(expiration).enter();
        verify(position).enter();
    }
}


