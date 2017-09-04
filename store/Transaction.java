package store;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Transaction {

  private String storeName; 

  public Transaction ( ) {   
  }
      //calculate change
      public double calculateChange(double total, double paid)
      {
        total = total - paid;
        return total;
      }

      //calculate the extended prices
      public double calculateExtendedPrice(double price, int quantity)
      {
        double total = price * quantity;
        return total; 
      }
      
      //calculate the total prices
      public double calculateTotalPrice(double total, double price){
        total = total + price;
        return total;
      }
}