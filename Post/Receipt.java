/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Monal
 */
public class Receipt {

    StringBuilder invoiceBuild = new StringBuilder();
    String storeName, customerName, date, paymentType;
    String totalFormat, amountReceived, amountChange;
    StringBuilder productBuild = new StringBuilder();
    
public void setStoreName(String sn) {this.storeName = sn;}
public void setCustomerName(String customerNm){customerName = customerNm;}
public void setDate(String dt) {date = dt;}
public void setLineItems(StringBuilder ss){productBuild = ss;}
public void setPaymentType(String pt){paymentType = pt;}
public void setTotal(String tot){totalFormat = tot;}
public void setAmountPaid(String tot2){amountReceived = tot2;}
public void setAmountChange(String tot3){amountChange = tot3;}

public void sendtoserver() {
        invoiceBuild.append(storeName);
        invoiceBuild.append("\n");
        invoiceBuild.append(customerName);
        invoiceBuild.append("\n");
        invoiceBuild.append(this.date);
        invoiceBuild.append("\n\n");
        invoiceBuild.append("*****Transactions*****\n");
        invoiceBuild.append("<Description> <Quantitiy> <Price> <Extended Price> \n");       
        invoiceBuild.append(productBuild);
        if (paymentType == "CREDIT")
        {
        //paymentType = paymentComboBox.getSelectedItem().toString();
        invoiceBuild.append("\n\n");
        invoiceBuild.append("*****TOTAL*****\n");
        invoiceBuild.append(totalFormat);
        invoiceBuild.append("\n");
        invoiceBuild.append("*****PAID*****\n");
        invoiceBuild.append(paymentType + " ");
        invoiceBuild.append(amountReceived);
        }
        else 
        {
        invoiceBuild.append("\n\n");
        invoiceBuild.append("*****TOTAL*****\n");
        invoiceBuild.append(totalFormat);
        invoiceBuild.append("\n");
        invoiceBuild.append("*****PAID*****\n");
        invoiceBuild.append(paymentType + " ");
        double amountDoubleReceived = Double.parseDouble(amountReceived);
        invoiceBuild.append(amountReceived + "\n");
        invoiceBuild.append("*****Change***** \n");
        //double change = transaction.calculateChange(amountDoubleReceived, totalPrice);
        //change1 = String.format("%.2f", change);
        //invoiceBuild.append(change1 + "\n");
        invoiceBuild.append(amountChange);
        }
        
        printReceipt();
        
        try{
        URL urlSale = new URL("http://localhost:8080/storeMonal/webresources/com.storemonalentity.sales");
            HttpURLConnection postConnSale = (HttpURLConnection) urlSale.openConnection();
            postConnSale.setDoOutput(true);
            postConnSale.setRequestMethod("POST");
            postConnSale.setRequestProperty("Content-Type", "application/xml");
             //System.out.println(invoiceBuild.toString());



            String newSaleString = 
                           "<sales> \n"
                    + "           <storeName>" + storeName + "</storeName> \n" 
                    + "           <change>" + amountChange +"</change> \n"
                    + "           <customerName>" + customerName +"</customerName> \n"
                    +"               <id>2</id> \n"
                    +"               <lineitems>" +productBuild.toString() +"</lineitems> \n"
                    +"               <paymentmethod>" + paymentType +"</paymentmethod> \n"
                     +"               <id>" + storeName + "</id> \n"
                    +"               <total>" + totalFormat +"</total> \n"
                    + "           <transactionTime>" + this.date +"</transactionTime> \n"
                    + "     </sales> ";

           
            
            
            OutputStream postOutputStream = postConnSale.getOutputStream();
            postOutputStream.write(newSaleString.getBytes());
            postOutputStream.flush();

            if (postConnSale.getResponseCode() >= 400) {
      JOptionPane.showMessageDialog(null, "Sorry! Server is down. Invoice will be stored locally");
                
                throw new RuntimeException("Failed : HTTP error code : "
                        + postConnSale.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (postConnSale.getInputStream())));
            System.out.println("Connected to Server .... \n");
            String output, msg = "";
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

          
String generatedKeys;
            generatedKeys = postConnSale.getResponseMessage();           
            postConnSale.disconnect();
            
            /*
             String[] lines = productBuild.toString().split("\\n");
                for(String s: lines){
                    String newlineitemString = 
                           "<lineitem> \n"
                    + "           <change>" + amountChange +"</change> \n"
                    + "           <customerName>" + customerName +"</customerName> \n"
                    +"             <id>2</id> \n"
                   
                    + "     </lineitel> ";
                }*/
                
                
                
                
                
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(PostTerminal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PostTerminal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        JOptionPane.showMessageDialog(null,"Sales records are updated on server");
        
    }

public void printReceipt(){
    JOptionPane.showMessageDialog(null,invoiceBuild.toString()); 
}

}