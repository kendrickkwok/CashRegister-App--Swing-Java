package test;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.ArrayList; 
import java.io.FileNotFoundException;
import java.io.IOException;
import actors.Manager;
import store.ItemCatalog;
import java.util.logging.Level;
import java.util.logging.Logger;
import store.Transaction;
import Post.PostTerminal;
import store.Item;
import java.util.Date;

// This class contains the main method for the POST system 

public class Startup {

  
  private final static String MANAGER_NAME = "Levine";
  private final static String TRANSACTION_FILE = "resources/transactions.txt";


  public static void main (String args[]) throws FileNotFoundException, IOException{

   String storeName;
        
    try{
    Manager manager  =  new Manager(MANAGER_NAME);
    //Open store generates a new Store object in manager, the constructor 
    //uses 3 parameters, Store name, Store Address, and the path to products.txt
    
    URL urlproduct = new URL("http://localhost:8080/storeServer/webresources/com.storeentity.product");
            HttpURLConnection getConnproduct = (HttpURLConnection) urlproduct.openConnection();
            getConnproduct.setRequestMethod("GET");
            getConnproduct.setRequestProperty("Accept", "application/xml");
    
    if (getConnproduct.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + getConnproduct.getResponseCode());
            }
    
    BufferedReader br = new BufferedReader(new InputStreamReader(
                    (getConnproduct.getInputStream())));
    System.out.println("Connected to server...");
    String output, msg = "";
    while ((output = br.readLine()) != null) {
                msg += output;
                System.out.println(output);
            }
    System.out.println("--------------------------\n\n");
    
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(new ByteArrayInputStream(msg.getBytes()));
            NodeList productsNodes = doc.getElementsByTagName("product");
    String upc;
    String price,name;
    //PrintWriter out = new PrintWriter("resources/products.txt");
    //FileOutputStream out = new FileOutputStream("resources/products.txt");
    //float price;
    ItemCatalog pc = new ItemCatalog();
    
    for (int i = 0; i < productsNodes.getLength(); i++) {
                Node productsNodetree = productsNodes.item(i);
                Element productsNodeTreeElement = (Element) productsNodetree;
                upc = productsNodeTreeElement.getElementsByTagName("upc").item(0).getTextContent();
                name = productsNodeTreeElement.getElementsByTagName("name").item(0).getTextContent();
                price = productsNodeTreeElement.getElementsByTagName("price").item(0).getTextContent();
                //out.println(upc + "  " + name + "  " + price);
                
                pc.parseProduct(upc + " " + name + " " + price);
     }

    //Create the date
    Date date = new Date();
    date.toString();
    //Manager opens the store at a specific date 
    manager.openStore("Safeway", date);
    //Return the items from server, store name, and the date
    ArrayList<Item> UPCList = pc.returnUPCList();
    storeName = manager.getStore().getName();
    date = manager.getStore().getDate();
    //Initiate the post terminal with the upcList
    PostTerminal gui = new PostTerminal(UPCList, storeName, date);
    gui.setVisible(true);

  }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException ex) {
          Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
      } catch (ParserConfigurationException ex) {
          Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
      }

  }
  
}