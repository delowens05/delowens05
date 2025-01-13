package mediaRentalManager;


public class Album implements Media{
	private String title;
	private int numCopies;
	private String artist;
	private String songs;

	public Album( String title, int numCopies, String artist, String songs) {
	
		this.title=title;
		this.numCopies=numCopies;
		this.artist=artist;
		this.songs=songs;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getNumCopies() {
		return this.numCopies;
	}

	public String getArtist() {
		return this.artist;
	}
	
	public String getSongs(){
		return this.songs;
	}
	

	

	@Override
	public int compareTo(Media media) {
		if(this.title.equals(media.getTitle())) {
			return 0;
		}else {
			return this.title.compareTo(media.getTitle());
		}
	}
	
	public void setNumCopies() {
		this.numCopies=numCopies+1;
	}

	@Override
	public void setNumCopiesDown() {
		this.numCopies=numCopies-1;		
	}

	@Override
	public void setNumCopiesUp() {
		this.numCopies+=1;
		
	}
	
	public String toString() {
		String finalString= "";
		finalString= this.getTitle() + "," + this.getNumCopies()+ "," + this.getArtist()+ "," + this.getSongs();
		return finalString;
	}

	
	
}
