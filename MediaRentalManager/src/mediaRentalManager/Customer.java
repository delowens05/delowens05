package mediaRentalManager;

import java.util.ArrayList;


public class Customer implements Comparable<Customer>{

	private String name;
	private String address;
	private String plan;
	
	private ArrayList<String> queue;
	private ArrayList <String> rented;
	
	public Customer(String name, String address, String plan) {
		this.name=name;
		this.address=address;
		this.plan=plan;
		this.queue= new ArrayList<String> ();
		this.rented= new ArrayList <String>();
		
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public String getPlan() {
		return this.plan;
	}
	
	public ArrayList <String> getQueue() {
		return this.queue;
	}
	
	public ArrayList <String> getRented() {
		return this.rented;
	}
	
	
	
	public void setPlan(String plan) {
		this.plan=plan;
	}
	
	public int compareTo(Customer customer) {
		if(this.name.equals(customer.name)) {
			return 0;
		}else {
			return this.name.compareTo(customer.name);
		}
	}
	
	public String toString(ArrayList<String> list) {
		String endResult="";
		for(int i=0;i<list.size(); i++) {
			if(i==list.size()-1) {
				endResult+= list.get(i);
			}else {
			endResult+= list.get(i) + ", ";
			}
		}
		return endResult;
	}
	
	

}
