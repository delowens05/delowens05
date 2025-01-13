package photomanager;

/**
 * The Photo class represents a photo. A photo has a source (url o path to the
 * file), the width and height in pixels, the date the photo was taken and
 * comments the user has added (if any). If you look at the class definition,
 * after "public class Photo" you will see "implements Comparable&lt;Photo&gt;".
 * You can ignore it; it means that the Photo class must implement a method
 * called compareTo that takes a Photo as a parameter and returns an integer.
 * Why we need it? Because it will allow us to sort ArrayList of Photos using
 * the compareTo method that you will define. This description has been written
 * under the influence of a lot of caffeine :)
 *
 * @author UMCP CS Department
 *
 */
public class Photo implements Comparable<Photo> {
	private String photoSource;
	private int width, height;
	private String date;
	private StringBuffer comments;

	/**
	 * Initializes the instance variables with the provided parameter values and
	 * initializes comments with a StringBuffer object. It will throw an
	 * IllegalArgumentException with the message "Constructor: Invalid arguments" if
	 * any string parameter is null or blank, or if the width or height (or both)
	 * are negative or zero. Use the String class isBlank() method to verify whether
	 * a string is blank. You can assume that if a date is provided, it represents a
	 * valid date. You don't need to verify whether photoSource represents a photo
	 * that exists.
	 *
	 * @param photoSource Url or file location.
	 * @param width       Photo's width in pixels.
	 * @param height      Photo's height in pixels.
	 * @param date        Date the photo was taken.
	 * @throws IllegalArgumentException For invalid parameter.
	 */
	public Photo(String photoSource, int width, int height, String date) {

		// Throws an IllegalArgumentExceptiom if the follwoing conditions apply.
		if (photoSource == null || photoSource.isBlank() || width < 0 || height < 0) {
			throw new IllegalArgumentException("Constructor: Invaild arguments");

		} else {
			// refeernces and stores instance variable associated with the Photo class.
			this.photoSource = photoSource;
			this.width = width;
			this.height = height;
			this.date = date;
			comments = new StringBuffer();

		}
	}

	/**
	 * Returns a string with photoSource, width, height and date values separated by
	 * commas. Comments are not part of the string.
	 *
	 * @return String with values separated by commas.
	 */
	@Override
	public String toString() {

		// references instance variables of a photo class and makes them into a string.
		String twoString = photoSource + ',' + width + ',' + height + ',' + date;
		return twoString;
	}

	/**
	 * Get method for photoSource.
	 * 
	 * @return photoSource.
	 */
	public String getPhotoSource() {
		// Returns the reference of the current object's photoSource.
		return this.photoSource;
	}

	/**
	 * Get method for width.
	 * 
	 * @return width.
	 */
	public int getWidth() {
		// Returns the reference of the current object's width.
		return this.width;
	}

	/**
	 * Get method for height.
	 * 
	 * @return height.
	 */
	public int getHeight() {
		// Returns the reference of the current object's height.
		return this.height;
	}

	/**
	 * Get method for date.
	 * 
	 * @return date.
	 */
	public String getDate() {
		// Returns the reference of the current object's date.
		return this.date;
	}

	/**
	 * Appends the newComment parameter to the comments StringBuffer. Comments must
	 * be separated by commas (the last comment should not be followed by a comma).
	 * If the parameter is null or blank (according to the String class isBlank()
	 * method) no comment will be appended, and the IllegalArgumentException with
	 * the message "Invalid comment" will be thrown. The method returns a reference
	 * to the current object.
	 * 
	 * @param newComment Comment to add.
	 * @return Reference to the current object.
	 */
	public Photo addComments(String newComment) {

		// Exception is thrown if the following conditions apply.
		if (newComment == null || newComment.isBlank()) {
			throw new IllegalArgumentException("Invaild comment");
		} else {
			// Checks if the comment string buffer is empty.
			if (this.getComments().length() == 0) {
				this.comments.append(newComment);
				// if empty, not comma will be added in front.
				if (this.getComments().indexOf(newComment) == 
						(this.getComments().length()) - (newComment.length())) {
				} else {
					// if not empty, comma will be added in front.
					this.comments.append(",");
				}
			} else {

				// Checks if the comment will be the last comment added.
				if (this.getComments().indexOf(newComment) == 
						(this.getComments().length()) - (newComment.length())) {
					this.comments.append(",");
					this.comments.append(newComment);
				} else {
					this.comments.append(",");
					this.comments.append(newComment);

				}
			}
		}
		// Returns reference to the currnet object.
		return this;

	}

	/**
	 * Returns a string that corresponds to the comments.
	 *
	 * @return String corresponding to comments.
	 */
	public String getComments() {
		// Returns a string with reference to the current object's comments.
		return "" + this.comments;
	}

	/**
	 * Copy constructor. Modifications to the new object should not affect the
	 * original (parameter) object.
	 *
	 * @param photo To copy.
	 */
	public Photo(Photo photo) {
		// Makes a new photo object that is a copy of another photo object.
		this(photo.getPhotoSource(), photo.getWidth(), photo.getHeight(), photo.getDate());
		// adds comments to the new copy photo object while
		// also adding copies of the old photo object.
		comments = new StringBuffer(photo.getComments());
	}

	/**
	 * This method will compare the date of the current object against the
	 * parameter's object. Use the Utilities.getDate() method that takes a string as
	 * a parameter and returns an integer (of type long) representing the date. We
	 * can represent dates (including time) using integers. The number returned by
	 * Utilities.getDate() represents the number of seconds that have elapsed since
	 * the Unix epoch (00:00:00 UTC on 1 January 1970). Run the main method of the
	 * Utilities.java class to see examples of these integer values.
	 *
	 * The compareTo method will return a negative value if the date of the current
	 * object precedes the date of the parameter, zero if the dates are the same,
	 * and a positive value otherwise. Don't be surprise if the amount of code
	 * required for compareTo method is minimal. Do not using casting to convert a
	 * long to int as this could lead to wrong results.
	 *
	 */
	@Override
	public int compareTo(Photo photo) {
		// checks if the photo data is equal to the parameter object's photo date.
		if (Utilities.getDate(this.getDate()) == Utilities.getDate(photo.getDate())) {
			return 0;
		}
		// checks if the photo data is less than the parameter object's photo date.
		else if (Utilities.getDate(this.getDate()) < Utilities.getDate(photo.getDate())) {
			return -1;
		} else {
			// if the photo data is greater than the parameter object's photo date.
			return 1;
		}
	}

}