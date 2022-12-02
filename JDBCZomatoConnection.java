package com.edubridge.com.edubridge.Zomato;
import java.sql.*;
import java.util.Scanner;


public class JDBCZomatoConnection {


	static final Scanner obj = new Scanner(System.in);
	public static void createRestaurantName(Connection connection ,Zomato obj) throws SQLException {

		PreparedStatement pstmt = connection.prepareStatement("insert into zomato values(?,?,?,?,?,?)");

		pstmt.setString(1, obj.getrestaurantName());
		pstmt.setInt(2, obj.getrestaurantId());
		pstmt.setString(3, obj.getdeliveryMode());
		pstmt.setInt(4, obj.getaveragePrice());
		pstmt.setInt(5, obj.getrating());
		pstmt.setString(6, obj.getlocation());
		int records = pstmt.executeUpdate();
		System.out.println(records + " record inserted succesfully");

	}	
	private  static void updateRestaurantName(Connection connection)throws SQLException {
		System.out.println("enter the id to update ");
		int val=obj.nextInt();
		System.out.println("enter the updated averagePrice ");
		int value=obj.nextInt();
		System.out.println("enter the updated ratings ");
		int value1=obj.nextInt();
		PreparedStatement pstmt = connection.prepareStatement("update Zomato set averagePrice=? where restaurantId=?");
		pstmt.setInt(1, value1);
		pstmt.setInt(1, value);
		pstmt.setInt(2, val);
		
		int records=pstmt.executeUpdate();
		System.out.println(records + "record updated succesfully");
	}

	private static void deleteRestaurantName(Connection connection)throws SQLException {

		System.out.println("enter the restaurantId to delete restaurant from the table");
		int value1=obj.nextInt();
		PreparedStatement pstmt=connection.prepareStatement("delete from zomato where restaurantId=? ");
		pstmt.setInt(1, value1);

		int records=pstmt.executeUpdate();
		System.out.println(records + " record deleted succesfully");
	}
	private static void ViewRestaurantDetails(Connection connection) throws SQLException {
		
		System.out.println("enter the restaurantId to read details from the table");
		int value2=obj.nextInt();
		String sql=" select * from zomato where restaurantId=?";
		PreparedStatement pstmt=connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt.setInt(1, value2);

		ResultSet rs=pstmt.executeQuery();
		if(rs.next()==false)
		{
			System.out.println("There is no such record in this database");
		}
		else
		{
			//rs.previous();
			System.out.println(rs.getString(1)+rs.getInt(2)+rs.getString(3)+rs.getInt(4)+rs.getInt(5)+rs.getString(6));
		}
	}

	public static void main(String []args)throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Y1012Jqkhkp");

		System.out.println("ENTER 1 TO ADD RESTAURANT DETAILS");
		System.out.println("ENTER 2 TO UPDATE RESTAURANT DETAILS");
		System.out.println("ENTER 3 TO DELETE RESTAURANT DETAILS");
		System.out.println("ENTER 4 TO VIEW RESTAURANT DETAILS");

		System.out.println("ENTER YOUR CHOICE");

		Scanner obj=new Scanner(System.in);
		byte choice= obj.nextByte();
		switch(choice) {
		case 1:
			Zomato obj1=getRestaurant();
			createRestaurantName(connection,obj1);
			break;

		case 2:
          
			updateRestaurantName(connection);

			break;	

		case 3:
			deleteRestaurantName(connection);
			break;	

		case 4:
            ViewRestaurantDetails(connection);
			break;	


		default:
			System.out.println("ENTER PROPER DETAILS");	
			connection.close();
		}

	}

	private static  Zomato getRestaurant() {
		Zomato restaurant=new Zomato();
		System.out.println("enter a restaurant name");
		restaurant.setrestaurantName(obj.next());

		System.out.println("enter a restaurant Id");
		restaurant.setrestaurantId(obj.nextInt());

		System.out.println("enter a delivery mode");
		restaurant.setdeliveryMode(obj.next());

		System.out.println("enter a average price");
		restaurant.setaveragePrice(obj.nextInt());

		System.out.println("enter a rating");
		restaurant.setrating(obj.nextInt());

		System.out.println("enter a location");
		restaurant.setlocation(obj.next());

		return restaurant;
	}
}








