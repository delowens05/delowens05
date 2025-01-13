package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import mediaRentalManager.MediaRentalManager;

public class StudentTests {

	@Test
	public void testAddQueue() {
		MediaRentalManager manager = new MediaRentalManager();
		manager.addCustomer("Delancey Owens", "1104 got ln", "LIMITED");
		System.out.println(manager.getAllCustomersInfo());
		manager.addToQueue("Delancey Owens", "Rocky");
		System.out.println(manager.getAllCustomersInfo());
	}
	
	@Test
	public void testsearch() {
		MediaRentalManager manager = new MediaRentalManager();
		manager.addCustomer("Delancey Owens", "1104 got ln", "LIMITED");
		manager.addMovie("Summer", 7, "PG");
		manager.addMovie("Shower", 9, "PG");
		manager.addAlbum("One dance", 8, "Drake", "One dance, Nice for What, Keke");
		ArrayList<String> searchResults=manager.searchMedia("Shower", null, "Drake", null);
		System.out.println(searchResults);
		
	}
	
	@Test
	public void testSetLimit() {
		
		MediaRentalManager manager = new MediaRentalManager();
		manager.setLimitedPlanLimit(1);
		manager.addCustomer("Delancey Owens", "1104 got ln", "LIMITED");
		manager.addMovie("Summer", 7, "PG");
		manager.addAlbum("One dance", 8, "Drake", "One dance, Nice for What, Keke");
		manager.addToQueue("Delancey Owens", "Summer");
		manager.addToQueue("Delancey Owens", "Shower");
		manager.addToQueue("Delancey Owens", "One dance");
		manager.addToQueue("Delancey Owens", "Sunny");
		manager.processRequests();
		System.out.println(manager.getAllCustomersInfo());
		manager.setLimitedPlanLimit(3);
		manager.addMovie("Sunny", 5, "G");
		manager.processRequests();
		System.out.println(manager.getAllCustomersInfo());
		
		
	}

}
