/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;
import javax.swing.*;
import java.awt.event.*;
import store.Transaction;
import java.util.ArrayList;
import store.Transaction;

/*
*@Author Kendrick Kwok 
*/

public class PaymentGUI 
{   
    //Variable declarations
    String paymentType, amountReceived, change1;
    double totalPrice;
    Transaction transaction = new Transaction();
    JComboBox paymentComboBox = new JComboBox();
    JTextField amountPaidBox = new JTextField();
    JLabel ChangeLabel2 = new JLabel();
    
    //Pass in PaymentGUI panel 
    public PaymentGUI(JComboBox jcb, JTextField ap, JLabel label, double total)
    {
        paymentComboBox = jcb;
        amountPaidBox = ap;
        ChangeLabel2 = label;
        totalPrice = total;
    }
    
    //Set the payment for the payment combobox
    public void setPayment()
    {
        paymentType = paymentComboBox.getSelectedItem().toString();
    }
    
    //If paid with Credit, change the GUI. If other, calculate the change.
    public void setPaid()
    {
        if (paymentComboBox.getSelectedItem().toString() == "CREDIT")
        { 
            amountReceived = amountPaidBox.getText();
        }
        
            else 
            {
                amountReceived = amountPaidBox.getText();
                double amountDoubleReceived = Double.parseDouble(amountReceived);
                double change = transaction.calculateChange(amountDoubleReceived, totalPrice);
                change1 = String.format("%.2f", change);
                ChangeLabel2.setText(change1);
            }
    }
    
    //Get the payment type
    public String getPayment()
    {
       return paymentType;
    }
    
    //Get the total amount
    public String getPaid()
    {
        return change1;
    }
    
    //Get the amount received
    public String getAmountPaid()
    {
        return amountReceived;
    }
}
