package store;

public class Item {

  private int upc;
  private double price;
  private String description; 

  public Item () {
    this.upc = -1;
    this.price = 0.0;
    this.description = "Undefined Product";
  }

  public Item (int upc, String description, double price) {
    this.upc = upc;
    this.price = price;
    this.description = description;
  }

  public int getUpc() { return this.upc; }

  public double getPrice() { return this.price; }

  public String getDescription () { return this.description; }

  //I am unsure if Mutators are neccessary for Item. 
}