/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.DefaultListModel;

/**
 *
 * @author Kendrick Joseh Kwok 
 */

public class InvoiceGUI {
    
    JList invoiceList = new JList();
    JTextField totalPriceField = new JTextField();
    DefaultListModel model = new DefaultListModel();
    StringBuilder sb;
    StringBuilder invoice = new StringBuilder();
    
    //Constructor to pass in Invoice Panel 
    public InvoiceGUI(JList jlist, StringBuilder stringBuilder, DefaultListModel model1, JTextField tf)
    {
        invoiceList = jlist;
        sb = stringBuilder;        
        model = model1;
        totalPriceField = tf;
    }
    
    //Build invoice for the models
    public void buildInvoice()
    {
        invoiceList.setFont(new Font("Courier New",Font.BOLD,14));
        model.addElement(sb);
        invoiceList.setModel(model);
    }
    
    public void setTotal(String set)
    {
        totalPriceField.setText(set);
    }
    
}
