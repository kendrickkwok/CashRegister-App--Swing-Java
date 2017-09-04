package store;

import java.util.List;
import java.util.Date;


public class Store  {

  //For right now, i will have a single Post 
  //private Post post;
  private String name;
  private Date date;

  //Assign store name and date
  public Store (String name, Date date) {
    this.name = name; 
    this.date = date; 
  }

  public String getName() { return this.name;}
  public Date getDate() {return this.date; }

}