package photomanager;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The PhotoManager class keeps track of Photos by using an ArrayList of Photo
 * references. The class relies heavily on ArrayList methods. At least you will
 * be using the following ArrayList methods: add, get, remove, clear. Check the
 * Java API ArrayList entry for information about each of these methods.
 *
 * @author UMCP CS Department
 *
 */
public class PhotoManager {
	private ArrayList<Photo> allPhotos;

	/**
	 * Assigns to the allPhotos instance variable an ArrayList of Photos.
	 */
	public PhotoManager() {
		allPhotos = new ArrayList<>();
	}

	/**
	 * Creates a Photo based on the provided parameters and adds the photo to the
	 * allPhotos ArrayList. The photo will be added if it does not already exist in
	 * the ArrayList (hint: use the findPhoto method). The method must handle
	 * (try/catch block) any exception thrown by creating a Photo (remember that a
	 * Photo constructor can throw an IllegalArgumentException). If an exception is
	 * thrown by the Photo constructor, the photo will not be added; in addition the
	 * message "addPhoto: Invalid arguments" will be printed to standard error (that
	 * means using System.err.println (notice the err)) and false will be returned.
	 * If a photo is added the method will return true.
	 *
	 * @param photoSource Photo's url or filename.
	 * @param width       Photo's width in pixels.
	 * @param height      Photo's height in pixels.
	 * @param date        Date the photo was taken.
	 * @return true if photo added; false otherwise.
	 */
	public boolean addPhoto(String photoSource, int width, int height, String date) {
		/**Creates a new photo with params, checks if the 
		 photo may be added to the album based in conditions, 
		 if not it catches the error. */
		try {
			Photo photo1 = new Photo(photoSource, width, height, date + "\n");
			//Checks if photo is already in the album.
			if (findPhoto(photo1.getPhotoSource()) != -1) {
				return false;
			} else {
				//adds photo to album.
				allPhotos.add(photo1);
				return true;
			}

		} catch (IllegalArgumentException e) {
			//Prints the statement below if photo could not be added.
			System.err.println("addPhoto: Invaild arguement");
			return false;
		}

	}

	/**
	 * Returns a string where each Photo is printed on a line by itself.
	 *
	 * @return String with information about all photos.
	 */
	@Override
	public String toString() {

		String twoString = "";
		//Gets all the photos in the album and their params and makes them a string.
		for (Photo element : allPhotos) {
			twoString += element.getPhotoSource() + ",";
			twoString += element.getWidth() + ",";
			twoString += element.getHeight() + ",";
			twoString += element.getDate();
		}
		return twoString;
	}

	/**
	 * Returns the index in the ArrayList associated with the Photo that has a
	 * photoSource corresponding to the parameter. The method will return -1 if no
	 * photo is found or if the parameter is null.
	 *
	 * @param photoSource Photo's photoSource.
	 * @return Index in the array or -1 (photo not found).
	 */
	public int findPhoto(String photoSource) {
		//Checks if photo is null.
		if (photoSource == null) {
			return -1;
		}
		for (int i = 0; i < allPhotos.size(); i++) {
			//Checks to see if the photo source of the object 
			//is the same as the param photo source.
			if (allPhotos.get(i).getPhotoSource().equals(photoSource)) {
				/**Returns index of the photo that matches the params
				photo source */
				return i;
			}
		}
		//Returns if the photo source is not the same
		return -1;
	}

	/**
	 * Adds the specified comment to the photo with the specified photoSource (if
	 * such photo is present in allPhotos). It returns true if the comments are
	 * added and false if the photo could not be found, or if the parameters are
	 * invalid. A parameter is invalid if it is null or if the newComment string is
	 * blank (according to the String method isBlank()).
	 *
	 * @param photoSource PhotoSource of photo we would like to add the comment.
	 * @param newComment  Comment to add.
	 * @return true if comment added; false otherwise.
	 */
	public boolean addComment(String photoSource, String newComment) {
		boolean answer1 = false;
		boolean answer2 = false;
		//Checks if conditions are true, if so, returns false.
		if (photoSource == null || newComment == null || newComment.isBlank()) {
			return false;
		} else {
			for (Photo element : allPhotos) {
				//Checks to see if param photoSource is 
				//equal to the objects photo source.
				if (element.getPhotoSource().equals(photoSource)) {
					element.addComments(newComment);
					answer1 = true;
				} else {
					answer1 = false;
				}
			}

		}
		//If answer1 was turned into true.
		if (answer1) {
			return true;
		//If answer1 was not turned into true.
		} else {
			return answer2;
		}
	}

	/**
	 * Returns the comments of the photo associated with the specified photoSource.
	 * The method will return null if no photo exists with the specified
	 * photoSource, or if the parameter is null.
	 *
	 * @param photoSource photo to find comments for.
	 * @return Comments or null.
	 */
	public String getComments(String photoSource) {
		//Checks if photoSource is null.
		if (photoSource == null) {
			return null;
		} else {
			String comment = "";
			for (Photo element : allPhotos) {
				//Checks to see if param photoSource is 
				//equal to the objects photo source.
				if (element.getPhotoSource().equals(photoSource)) {
					comment = element.getComments();
				}
			}
			//If comment is blank return null.
			if (comment.equals("")) {
				return null;
			} else {
				return comment;
			}
		}
	}

	/**
	 * Removes all the photos from allPhotos. This method only takes a single line
	 * of code.
	 */
	public void removeAllPhotos() {
		//Removes all photos from the arraylist allPhotos.
		allPhotos.clear();
	}

	/**
	 * Removes the Photo with the specified photoSource (if it exists). Returns true
	 * if the photo was removed and false if the photo was not found or the
	 * parameter is null. Remember that you can remove elements from an ArrayList
	 * using the ArrayList remove method.
	 *
	 * @param photoSource Photo we would like to remove.
	 * @return true if photo was removed; false otherwise.
	 */
	public boolean removePhoto(String photoSource) {

		boolean answer1 = false;
		boolean answer2 = false;
		//If photo source is null.
		if (photoSource == null) {
			return false;
		} else {
			for (int i = 0; i < allPhotos.size(); i++) {
				//Checks to see if param photoSource is 
				//equal to the objects photo source.
				if (allPhotos.get(i).getPhotoSource().equals(photoSource)) {
					allPhotos.remove(i);
					answer2 = true;
				} else {
					answer1 = false;
				}
			}

		}
		//Checks if answer2 is true.
		if (answer2) {
			return true;
		} else {
			return answer1;
		}
	}

	/**
	 * Loads the photos specified in filename to the allPhotos ArrayList. It adds to
	 * the ArrayList (it does not clear the ArrayList before adding photos). Each
	 * line of the file will have information about a photo. The information will be
	 * the photoSource, followed by the width, height and date. You can assume the
	 * file will have correct information. The following is an examples of a file
	 * entry: <br>
	 * umcp/college1.jpg 300 400 10/18/2020-17:10 <br>
	 * If an error takes place while opening the file (e.g., file does not exist),
	 * an error message (any message is fine) will be printed using
	 * System.err.println. Notice that your code will not crash when a file could
	 * not be opened; in this case the method will print the error message and
	 * return false. The method will return false and perform no processing when the
	 * parameter is null.
	 * 
	 * @param filename Name of file with information about photos.
	 * @return true if the data was loaded and false otherwise.
	 *
	 */
	public boolean loadPhotos(String filename) {
		//Checks if file is null and if so, prints an error statement.
		if (filename == null) {
			System.err.print("invaild file");
			return false;
		}
		//Sees if the file name can be load, if not , it catches the error
		try {
			//Store filename as a file and as a scanner.
			Scanner scanner = new Scanner(new File(filename));
			//Will run scanner until it can read no more lines in the file.
			while (scanner.hasNextLine()) {
				String file = scanner.nextLine();
				//Makes the file into a string array.
				String[] fileArr = file.split(" ");
				//Makes a new Photo with fileArr indexs.
				Photo photoAdd = new Photo(fileArr[0], Integer.parseInt(fileArr[1]), 
						Integer.parseInt(fileArr[2]),fileArr[3] + "\n");
				allPhotos.add(photoAdd);
			}
			scanner.close();
			return true;
			
		} catch (Exception e) {
			//Returns false and prints error message if filename cannot load.
			System.err.print("does not exist");
			return false;
		}

	}

	/**
	 * Sorts the allPhotos by date. This method requires a single line of code.
	 */
	public void sortPhotosByDate() {
		//Sorts photos in allPhotos by date.
		allPhotos.sort(null);
	}

	/**
	 * This method creates an HTML file with all the photos. This method has been
	 * implemented for you and it is not used by any other method.
	 *
	 * @param htmlFilename Web page with photos.
	 */
	public void createHTMLPage(String htmlFilename) {
		String body = "";

		for (Photo photo : allPhotos) {
			body += "<img src=\"" + photo.getPhotoSource() + "\" ";
			body += "width=\"" + photo.getWidth() + "\" ";
			body += "height=\"" + photo.getHeight() + "\" ";
			body += "alt=\"photo image\"><br>\n";
		}

		Utilities.generateHTMLPageWithBody(htmlFilename, body);
	}
}