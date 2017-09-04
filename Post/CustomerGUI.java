/*
 * Kendrick Joseph Kwok 
 */
package Post;
import javax.swing.*;
import java.awt.event.*;


public class CustomerGUI {

    //Create customer name string to return 
    public String customerName;
    public JTextField customerTextField;
    
    //Passes a customer textfield 
    public CustomerGUI(JTextField jt)
    {
        customerTextField = jt;    
    }

    //Returns a customer text field
    public String getCustomerTextField()
    {
        customerName = customerTextField.getText();
        return customerName;
    }
}

