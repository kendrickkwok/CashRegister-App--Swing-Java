package Post;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.DefaultListModel;
/**
 *
 * @author Kendrick Joseph Kwok 
 */
public class DateGUI {
    
    JTextField dateTextField = new JTextField();
    
    //Pass in panel date text field 
    public DateGUI(JTextField jtf)
    {
        dateTextField = jtf;
    }
    
    //Set the text field for date 
    public void setTextField(String set)
    {
        dateTextField.setText(set);
    }
}
