package actors;

import java.util.Map;
import java.util.Date;

import store.ItemCatalog;
import store.Store;
import store.Item;


public class Manager {

  private String name;
  private Date date;
  private Store store; 

  public Manager (String name) { 
    this.name = name;
  }

  //Manager opens the store with aprameters of store name and date
  public void openStore (String storeName, Date date) {
    this.store = new Store (storeName, date);
    
    System.out.println("\nOpening Store: " + storeName ) ; 
    System.out.println ("-----------------------\n");
  }

  //Manager closes tehs tore
  public void closeStore () { 
    this.store = null; 
  }

  public Store getStore () { return this.store;}
}