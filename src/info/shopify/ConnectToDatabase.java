package info.shopify;


import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectToDatabase {
	public static void main(String[] args) {
	ArrayList<itemList> itemlist = new ArrayList<itemList>();	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 String url = "jdbc:mysql://localhost:3306/shop";
		 Connection con = DriverManager.getConnection(url, "root", "storm");
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery("select * from item");
		 while(rs.next()) {
			 itemList il= new itemList();
			 il.setitemId(rs.getInt("item_id"));
			 il.setitemName(rs.getString("item_name"));
			 il.setitemPrice(rs.getString("item_price"));
			 il.setitemQuantity(rs.getString("item_quantity"));
			 itemlist.add(il);
		 }
	 // System.out.println(itemlist.size());
	  System.out.println(itemlist.get(1).getitemId()+"\t"+itemlist.get(1).getitemName()+"\t"+itemlist.get(1).getitemPrice()+"\t"+itemlist.get(1).getitemQuantity());
	  System.out.println(itemlist.get(2).getitemId()+"\t"+itemlist.get(2).getitemName()+"\t"+itemlist.get(2).getitemPrice()+"\t"+itemlist.get(2).getitemQuantity());
	  System.out.println(itemlist.get(3).getitemId()+"\t"+itemlist.get(3).getitemName()+"\t"+itemlist.get(3).getitemPrice()+"\t"+itemlist.get(3).getitemQuantity());
	  System.out.println(itemlist.get(4).getitemId()+"\t"+itemlist.get(4).getitemName()+"\t"+itemlist.get(4).getitemPrice()+"\t"+itemlist.get(4).getitemQuantity());
	
	  String insert = "INSERT INTO ITEM "+ "VALUES (106, 'Fan', '250', '110')";
	  st.executeUpdate(insert);
	  System.out.println("Inserted records into the table...");
	  
	
	}
	
	
	
	catch(Exception e) {
		System.err.println("Exception");
        System.err.println(e.getMessage());
	}
	}
}