package sysImplementation;

public class Utilities {
	
	
	/**
	 This method take in a integer array, then takes every 
	 element in the array and makes in 
	 into a string separated by a separtor.
	 * @param array
	 * @param separator
	 * @return
	 */

	public static String getArrayString​(int[] array, char separator) {

		String finalString = "";

		if (array == null) {  //Throws exception if array is null.
			throw new IllegalArgumentException();
		} else if (array.length == 0) {
			return "";    //returns an empty string if the array has no elements
		} else {
		//Takes each element out the array and adds it to a string variable

			for (int i = 0; i < array.length; i++) { 
				if (i == array.length - 1) {
					finalString += array[i];
				} else {
					finalString += array[i] + "" + separator;
				}
			}

		}

		return finalString;
	}
	
	
	/**
	 * This method returns how many intergers in the array are between a lower and upper limit.
	 * @param array
	 * @param lowerLimit
	 * @param upperLimit
	 * @return
	 */

	public static int getInstances(int[] array, int lowerLimit, int upperLimit) {

		int count = 0;
		if (array == null) {  //Throws an exception if null
			throw new IllegalArgumentException();
		} else {
			
			//Increases count if interger in the array is between upper and lower
			for (int i = 0; i < array.length; i++) {   
				if (array[i] >= lowerLimit && array[i] <= upperLimit) { 
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * This method creates new interger array with
	 * all the intergers that are in between the upper and lower limit.
	 * @param array
	 * @param lowerLimit
	 * @param upperLimit
	 * @return
	 */
	public static int[] filter(int[] array, int lowerLimit, int upperLimit) {
		int count = 0;
		if (array == null || lowerLimit > upperLimit) {
			throw new IllegalArgumentException(); //Throws exception if conditions apply.
		} else {
			 //Counts how many items in the array are bewteen the limits.
			count = Utilities.getInstances(array, lowerLimit, upperLimit); 
		}
		//Sets the array equal to the amount 0f intergers that are bettwen the limtis
		int[] newArray = new int[count];  
		int icount = 0;
		//Places intergers into the array if conditond are met.
		for (int i = 0; i < array.length; i++) { 
			if (array[i] >= lowerLimit && array[i] <= upperLimit) {
				newArray[icount] = array[i];
				icount++;
			}
		}

		return newArray;

	}
	
	/**
	 This method rotates the integers in the array left 
	 or right by a speficic amount of spaces depending 
	 on if the parameter is true or false. The array
	 has to have more than 1 element.
	 * @param array
	 * @param leftRotation
	 * @param positions
	 */
	public static void rotate​(int[] array, boolean leftRotation, int positions) {
	
		
		if (array == null) {    //Throws exception is null.
			throw new IllegalArgumentException();
		} else {

			if (leftRotation == true) {

				if (array.length >= 2) {  //Checks if array has more than 1 element
					//Makes a new array of the array rotated left.
						forRotateLeft(array, positions);
					}

			} else {
				if(array.length>=2) {
					//Makes a new array of the array rotated right.
					forRotateRight(array, positions);
	
			
		}
		
			}
		}


}
	
	/**
	 * This method takes in a StringBuffer array, sees if the StringBuffer
	 * is longer than the given length, and makes a new StringBuffer array 
	 * with all the StringBuffers that are longer than the given length.
	 * @param array
	 * @param length
	 * @return
	 */
public static StringBuffer[] getArrayStringsLongerThan( StringBuffer [] array, int length) {
	if(array == null) {
		throw new IllegalArgumentException(); //Throws exception if null
	}
	
	//Finds how many elements in the array are longer than length
		int count=0;
		for(int i=0; i<array.length; i++) {
			if(array[i].length()>length && array[i]!=null) {
				count++;
			}
		}
		
	//If no elements are longer than lengh, then an empty StringBuffer array is returned
	if(count==0) {
		StringBuffer[] empty= new StringBuffer[count];
		return empty;
	}else {
		//Places all elements in a new array that are longer than length
	StringBuffer [] copyBuffer= new StringBuffer [count];
	int incrament=0;
		for(int i=0; i<array.length; i++) {
			if(array[i].length()>length) {
				copyBuffer[incrament]= new StringBuffer(array[i]);
				incrament++;
			}
		}
	
	return copyBuffer;
}

}
	/** 
	 * This method takes in an array and rotates it right a certain number of positions
	 * @param array
	 * @param positions
	 * @return
	 */
	
	private static void forRotateLeft( int [] array, int positions) {
	
		//New array is created
	int []rotateRight= new int[array.length];
	
	//Checks to see if position is greater than the array length 
	if(positions>array.length) {
		positions= positions%array.length;
	}
	
	//Sets the elements on the right of the position
		for(int i= 0; i<positions; i++) {
			rotateRight[(array.length-positions)+i]=array[i];
		}
	//Sets the elements on the left of the position
		for(int r= 0; r<array.length-positions; r++) {
			rotateRight[r]= array[positions+r];
		}
		
		for(int i= 0; i< array.length; i++) {
			array[i]=rotateRight[i];
		}
	}
	
	/** 
	 * This method takes in an array and rotates it right a certain number of positions
	 * @param array
	 * @param positions
	 * @return
	 */
	private static void forRotateRight( int [] array, int positions) {
		//New array is created
	int []rotateLeft= new int[array.length];
	
	//Checks to see if positions is greater than the array length 
	if(positions>array.length) {
		positions= positions%array.length;
	}
	//Sets the elements on the left of the position
		for(int i= positions; i<array.length; i++) {
			rotateLeft[i]=array[i-positions];
		}
		//Sets the elements on the right of the position
		for(int r= 0; r<positions; r++) {
			rotateLeft[r]= array[(array.length-positions)+r];
		}
		
		for(int i= 0; i< array.length; i++) {
			array[i]=rotateLeft[i];
		
		
		}
		
	}
	


}
