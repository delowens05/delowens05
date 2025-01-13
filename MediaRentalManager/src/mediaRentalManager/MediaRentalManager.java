package mediaRentalManager;

import java.util.ArrayList;
import java.util.Collections;



public class MediaRentalManager implements MediaRentalManagerInt{
	
	private ArrayList <Customer> customer;
	private ArrayList <Media> media;
	private int limit;

	public MediaRentalManager() {
		
		this.customer= new ArrayList <Customer> ();
		this.media = new ArrayList <Media> ();
		this.limit=2;
	}
	
	
	public void addCustomer(String name, String address, String plan) {
		customer.add(new Customer(name, address, plan));
		
		
	}



	public void addMovie(String title, int copiesAvailable, String rating) {
		media.add(new Movie (title, copiesAvailable, rating));
		
	}


	
	public void addAlbum(String title, int copiesAvailable, String artist, String songs) {
		this.media.add(new Album (title, copiesAvailable, artist, songs));
		
	}



	public void setLimitedPlanLimit(int value) {
		this.limit=value;
		
	}


	public String getAllCustomersInfo() {
		
		String customerInfo= "***** Customers' Information *****" + "\n" ;
		Collections.sort(customer);
		for(int i=0; i<customer.size();i++) {
			Customer temp = customer.get(i);
			customerInfo+="Name: "+ temp.getName() + ", Address: " + 
					temp.getAddress()+ ", Plan: "+ temp.getPlan() + "\n"
					+ "Rented:" + " [" + temp.toString(temp.getRented())+ "]" + "\n" 
					+ "Queue:" + " [" +temp.toString(temp.getQueue())+ "]"+ "\n";
		}
		

		return customerInfo;
	}



	public String getAllMediaInfo() {
		String mediaInfo= "***** Media Information *****";
		Collections.sort(media);
		for(int i=0; i<media.size();i++) {
			if(media.get(i) instanceof Movie) {
				Movie temp= (Movie) media.get(i);
				mediaInfo+="\n"+ "Title: "+ temp.getTitle() + ", Copies Available: " + 
						temp.getNumCopies()+ ", Rating: "+ temp.getRating() ;
			}else {
				Album temp= (Album) media.get(i);
			mediaInfo+= "\n"+ "Title: "+ temp.getTitle() + ", Copies Available: " + 
					temp.getNumCopies()+ ", Artist: "+ temp.getArtist() + "," + "Songs: " + temp.getSongs();
			}
		}
		return mediaInfo;	
	}



	public boolean addToQueue(String customerName, String mediaTitle) {
		for(int i=0; i<customer.size(); i++) {
			if(customer.get(i).getName().equals(customerName)) {
				ArrayList <String> queue= customer.get(i).getQueue();
				for(String string: queue) {
					if(string.equals(mediaTitle)) {
						return false;
					}
				}
				customer.get(i).getQueue().add(mediaTitle);
				return true;
				
	
			}
		}
		return false;
	}



	public boolean removeFromQueue(String customerName, String mediaTitle) {
		for(int i=0; i<customer.size(); i++) {
			if(customer.get(i).getName().equals(customerName)) {
				ArrayList <String> queue= customer.get(i).getQueue();
				for(String string: queue) {
					if(string.equals(mediaTitle)) {
						customer.get(i).getQueue().remove(mediaTitle);
						return true;
					}
				}
				
				
	
			}
		}
		return false;
	}



	public String processRequests() {
		Collections.sort(customer);
		String finalOrder = "";
		for (int i = 0; i < customer.size(); i++) {
			
			if (customer.get(i).getPlan().equals("LIMITED")) {
				Customer temp = customer.get(i);
				for (Media media : media) {
					for (int j = 0; j < temp.getQueue().size(); j++) {
						if (media.getTitle().equals(temp.getQueue().get(j)) && media.getNumCopies() > 0) {
								if (temp.getRented().size() < this.limit) {
									temp.getRented().add(temp.getQueue().get(j));
									media.setNumCopiesDown();
									
									finalOrder += "Sending " + media.getTitle() + 
											" to " + temp.getName() + " " + "\n";
									
							}

						}
						
					}
					
					
				}
				
			} else {
				Customer temp = customer.get(i);
				for (int k = 0; k < temp.getQueue().size(); k++) {
					for (Media media : media) {
						if (media.getTitle().equals(temp.getQueue().get(k))) {
							if (media.getNumCopies() > 0) {
								if(!temp.getRented().contains(temp.getQueue().get(k))) {
									temp.getRented().add(temp.getQueue().get(k));
									media.setNumCopiesDown();
									finalOrder += "Sending " + media.getTitle() + " to " + temp.getName() + "\n";
								}
								
							}
						}
					}
				}
			}
			
			Customer temp2 = customer.get(i);
			for(int j = 0; j < temp2.getRented().size();j++) {
				temp2.getQueue().remove(temp2.getRented().get(j));
			}

		}

		return finalOrder;
	}


	public boolean returnMedia(String customerName, String mediaTitle) {
		for(int i=0; i<customer.size(); i++) {
			if(customer.get(i).getName().equals(customerName)) {
				ArrayList <String> rented= customer.get(i).getRented();
				for(int j=0; j<rented.size(); i++) {
					if(rented.get(j).equals(mediaTitle)) {
						customer.get(i).getRented().remove(j);
						for(int k=0; k<media.size(); k++){
							if(media.get(k).getTitle().equals(mediaTitle)) {
								media.get(k).setNumCopiesUp();
							}
						}
						return true;
					}
				}
				
				
	
			}
		}
		
		return false;
	}


	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> mediaList = new ArrayList<String>();
		if (title == null && rating == null && artist == null && songs == null) {
			for (Media media : media) {
				if (media instanceof Movie) {
					Movie movie = (Movie) media;
					mediaList.add(movie.getTitle());
				} else {
					Album album = (Album) media;
					mediaList.add(album.getTitle());
				}

			}

		} else {
			for (Media media : media) {
				if (media instanceof Movie) {

					Movie movie = (Movie) media;
					if (movie.getRating() == null || movie.getRating().equals(rating)) {
						if (artist == null && songs == null && title == null) {
							mediaList.add(movie.getTitle());
						}
					}
				}
				
				if(media instanceof Album) {
					Album album = (Album) media;
					if(album.getArtist()== null ||album.getArtist().equals(artist) || songs == null ||
							album.getSongs().indexOf(songs) != -1) {
						if(rating==null && title==null) {
							mediaList.add(album.getTitle());
						}
					}
				}
				
				

				if (media.getTitle().equals(title)) {
					mediaList.add(media.getTitle());
				}

			}

		}
		Collections.sort(mediaList);
		return mediaList;
	}
}
