/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import store.Item;
import store.Transaction;
import store.Editor;
import store.Editor;
import store.Item;
import store.Transaction;


/**
 *
 * @author Kendrick Joseph Kwok 
 */
public class ProductGUI {
    
    //Variable Declarations
    JComboBox QuantityComboBox, UPCComboBox;
    String upc, quantity, totalFormat, format;
    ArrayList <Item> upclist;
    Editor ed = new Editor();
    double extendedPrice, totalPrice;
    StringBuilder sb = new StringBuilder();
    StringBuilder invoiceBuild = new StringBuilder();
    
    //Pass in product GUI
    public ProductGUI(JComboBox UPCBox, JComboBox QuantityBox, ArrayList<Item> upcList)
    {
        UPCComboBox = UPCBox;
        QuantityComboBox = QuantityBox;
        upclist = upcList;
    }
    
    //Returns the string to produce a line item for printing on invoice panel.
    public StringBuilder getLineItem()
    {
        //Get the selected item and quantity.
        upc = UPCComboBox.getSelectedItem().toString();
        quantity = QuantityComboBox.getSelectedItem().toString();  
        Transaction transaction = new Transaction();    
         
        //Check every item in the product catalog to find a match
        for(Item item:this.upclist) {
            //If matches, execute the code
            String test = Integer.toString(item.getUpc());
                if(test.equals(upc)){    
                //Appends item desription
                sb.append(item.getDescription());
                //ed = editor, appends and formats the string
                sb.append(ed.addSpaces(50, item.getDescription().length()));
                //Appends quantity description
                sb.append(quantity);
                sb.append(ed.addSpaces(15, quantity.length()));
                //Append quantity price
                sb.append(item.getPrice());
                double priceLength = item.getPrice();
                sb.append(ed.addSpaces2(15,priceLength));
                //Appends extended quantitiy price
                int iQuantity = Integer.parseInt(quantity);
                extendedPrice = transaction.calculateExtendedPrice(item.getPrice(), iQuantity);
                totalPrice = transaction.calculateTotalPrice(totalPrice, extendedPrice);
                //format is for extended prices
                format = String.format("%.2f", extendedPrice);
                sb.append(format);
                invoiceProductAppend(item);
                }    
            }
        return sb;
    }
    
    //Builds the receipt for printing
    public void invoiceProductAppend(Item item)
    {
        //append all the items
        invoiceBuild.append("\n");
        invoiceBuild.append(item.getDescription() + "               ");
        invoiceBuild.append(quantity + "      ");
        invoiceBuild.append(item.getPrice()+ "      ");
        invoiceBuild.append(format);
    }
    
    //Return total price 
    public double returnTotal()
    {
        return totalPrice;
    }
    
    //Return the string for the receipt
    public StringBuilder getInvoiceProduct()
    {
        return invoiceBuild;
    }
}
