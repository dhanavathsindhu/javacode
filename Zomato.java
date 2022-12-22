package com.example.frontend.demo.frontend.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Zomatotable")
public class Zomato {
@Column	
private String restaurantName;
@Column
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int  restaurantId;
@Column
private int  rating;
@Column
private int averageCost;
public int getAverageCost() {
	return averageCost;
}
public void setAverageCost(int averageCost) {
	this.averageCost = averageCost;
}
public String getRestaurantName() {
	return restaurantName;
}
public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}
public int getRestaurantId() {
	return restaurantId;
}
public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}

}