package store;

import java.util.*;
import java.util.Map;
import java.util.LinkedHashMap;
import java.io.FileNotFoundException;
import java.io.IOException;

import store.Item;

// this class reads from the server and parses it to an array list
public class ItemCatalog  {

  private Map<Integer, Item > itemCatalog ; 
  ArrayList<Item> UPCList = new ArrayList<Item>();
  
  public ItemCatalog () { 
    itemCatalog = new LinkedHashMap<Integer, Item>();    
  }

  public void parseLine (String nextLine) throws NullPointerException { 
    // [0] = upc , [1] = description, [2] = price
    //Splits the Line on 3 or more spaces
    String[] splitLine = nextLine.split("\\s\\s\\s+|\\t");
    int upc = Integer.parseInt(splitLine[0]);
    
    Item newItem = new Item (upc, splitLine[1], Double.parseDouble(splitLine[2]));
    itemCatalog.put(upc, newItem); 
    addUPCList(newItem);
  }
  
  public void parseProduct (String nextLine) throws NullPointerException { 
      
    String[] splitLine = nextLine.split(" ");
    int upc = Integer.parseInt(splitLine[0]);
    
    Item newItem = new Item (upc, splitLine[1], Double.parseDouble(splitLine[2]));
    itemCatalog.put(upc, newItem); 
    addUPCList(newItem);
  }

  public void addUPCList(Item upc){
      UPCList.add(upc);      
  }
  
  public ArrayList returnUPCList(){
      return UPCList;
  }
}