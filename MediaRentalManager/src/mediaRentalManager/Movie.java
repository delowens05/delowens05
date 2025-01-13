package mediaRentalManager;

import java.util.ArrayList;

public class Movie implements Media{
	private String title;
	private int numCopies;
	private String rating;

	public Movie(String title, int numCopies, String rating) {
		this.title= title;
		this.numCopies=numCopies;
		this.rating=rating;
		
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getNumCopies() {
		return this.numCopies;
	}

	public String getRating() {
		return this.rating;
	}
	
	public void setRating(String rating) {
		this.rating= rating;
	}
	

	@Override
	public int compareTo(Media media) {
		if(this.title.equals(media.getTitle())) {
			return 0;
		}else {
			return this.title.compareTo(media.getTitle());
		}
	}
	
	public void setNumCopiesDown() {
		this.numCopies=numCopies-1;
	}
	
	public void setNumCopiesUp() {
		this.numCopies=numCopies+1;
	}
	
	public String toString() {
		String finalString= "";
		finalString= this.getTitle() + "," + this.getNumCopies()+ "," + this.getRating();
		return finalString;
	}
	
	

}
