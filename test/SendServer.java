/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;
import javax.swing.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


//import store.Item;
//import store.LineItem;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
/**
 *
 * @author Joseph
 */
public class SendServer {
    /*
try{
        URL urlSale = new URL("http://localhost:8080/newstoreserver/webresources/com.newstoreentity.sales");
            HttpURLConnection postConnSale = (HttpURLConnection) urlSale.openConnection();
            postConnSale.setDoOutput(true);
            postConnSale.setRequestMethod("POST");
            postConnSale.setRequestProperty("Content-Type", "application/xml");
             System.out.println(invoiceBuild.toString());

            String newSaleString = 
                           "<sales> \n"
                    + "           <change>" + change1 +"</change> \n"
                    + "           <customerName>" + customerName +"</customerName> \n"
                    +"               <id>2</id> \n"
                    +"               <paymentmethod>" + paymentType +"</paymentmethod> \n"
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

            postConnSale.disconnect();
            
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(PostTerminal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PostTerminal.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    JOptionPane.showMessageDialog(null, "Sales record successfuly sent to the server!");
    
    //***** Show a message that the server cannot be stored locally 
    //JOptionPane.showMessageDialog(null, "Sorry! Server is down. Invoice will be stored locally");

     try(
            FileWriter fw = new FileWriter("receipt.txt", true);
            BufferedWriter bufferedwriter = new BufferedWriter(fw);
            PrintWriter output = new PrintWriter(bufferedwriter)
          )
          {
            output.println(invoiceBuild);
          }  
        catch( IOException e ){
        // File writing/opening failed at some stage.
        }
*/
}
