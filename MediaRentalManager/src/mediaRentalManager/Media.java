package mediaRentalManager;

import java.util.ArrayList;

public interface Media extends Comparable<Media> {

	
	public String getTitle();
	public int compareTo(Media media);
	public void setNumCopiesDown();
	public void setNumCopiesUp();
	public int getNumCopies();
	public String toString();
		
	
	

}
