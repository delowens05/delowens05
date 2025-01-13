package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import sysImplementation.Utilities;

public class StudentTests {

	@Test
	public void testGetArrayString() {
		
	int [] array1 = {2, 3, 2};
	int [] array2 = {};
//		array1[0]=2;
//		array1[1]=3;
//		array1[2]=2;
//		array1[3]=3;
//		array1[4]=2;	
	
		String results= Utilities.getArrayString​(array1, ',');
		String expectedResult= "2,3,2";
		
		assertEquals("", Utilities.getArrayString​(array2, ','));
		assertEquals(results, expectedResult);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testGetArrayString1() {
		
		int [] array1 = null;
//		array1[0]=2;
//		array1[1]=3;
//		array1[2]=2;
//		array1[3]=3;
//		array1[4]=2;	
		
		System.out.println(Utilities.getArrayString​(array1, ','));
	}
	
	@Test
	public void testGetInstances() {
		int [] array2 = {2, 3, 2};
		int [] array3 = {};
		int lower=0;
		int high=4;
		
		int results= 3;
		
		assertTrue(results == Utilities.getInstances(array2, lower, high));
		assertTrue(0 ==Utilities.getInstances(array3, lower, high));
	
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInstances1() {
		int [] array2 = null;
		int lower=0;
		int high=1;
		
		
		System.out.println(Utilities.getInstances(array2, lower, high));
		
		
	}
	
	
	@Test
	public void testFilter() {
		int [] array2 = {2, 3, 2, 9, 8, 5};
		int lower=8;
		int high=9;
		
		String results= "9,8";
		
		assertEquals(results, Utilities.getArrayString​(Utilities.filter(array2, lower, high), ','));
	
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testFilter1() {
		int [] array2 = null;
		int lower=8;
		int high=5;
		System.out.println(Utilities.getArrayString​(Utilities.filter(null, lower, high), ','));
	
	}
	
	
	@Test (expected=IllegalArgumentException.class)
	public void testFilter2() {
		int [] array2 = {2, 3, 2, 9, 8, 5};
		int lower=8;
		int high=5;
		
		System.out.println(Utilities.getArrayString​(Utilities.filter(array2, lower, high), ','));
	}
	
	@Test
	public void testRotateRight() {
		int [] array4 = {2,3,2,6};
		int [] array5 = {3,2,6,2};
		boolean decide= false;
		int num = 7;
		
		Utilities.rotate​(array4, decide, num);
		
		assertArrayEquals(array4, array5 );
		
		
	}
	@Test
	public void testRotateLeft() {
		int [] array4 = {6,5,7,8};
		int [] array5 = {7,8,6,5};
		boolean decide= true;
		int num = 2;
	
		Utilities.rotate​(array4, decide, num);
		
		assertArrayEquals(array5, array4 );
		
		
		
		
	}
	
	
	@Test (expected=IllegalArgumentException.class)
	public void testRotate1() {
		int [] array4 = null;
		boolean decide= false;
		int num = 2;
		Utilities.rotate​(null, decide, num);
	}
	
	

	@Test
	public void testStringsLongerThan() {
		
		int num=5;
		StringBuffer [] array3 = new StringBuffer[3];
		StringBuffer [] array4 = new StringBuffer[0];
		StringBuffer [] results= new StringBuffer[0];
		array3[0]= new StringBuffer("high");
		array3[1]= new StringBuffer("loserrrrr");
		array3[2]= new StringBuffer("Delancey");
		
		
		assertEquals("loserrrrr,Delancey",
				bufferToString(Utilities.getArrayStringsLongerThan(array3, num), ','));
		Assert.assertArrayEquals(results, Utilities.getArrayStringsLongerThan(array4, num));
	}

	@Test (expected=IllegalArgumentException.class)
public void testStringsLongerThan1() {
		
		int num=4;
		StringBuffer [] array3 = null;
		
		Utilities.getArrayStringsLongerThan(array3, num);
	
}

	
	private static String bufferToString(StringBuffer[] array, char separator){

		String finalString = "";

		if (array == null) {
			throw new IllegalArgumentException();
		} else if (array.length == 0) {
			return " ";
		} else {
			for (int i = 0; i < array.length; i++) {

				if (i == array.length - 1) {
					finalString+=array[i];
				} else {
					finalString += array[i] + "" + separator;
				}
			}

		}
		
		return finalString;
	}
	
	
	
		
	
	
	

}
