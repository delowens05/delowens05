package tests;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import photomanager.Photo;
import photomanager.PhotoManager;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests  {

	@Test
	public void addPhotoTest1() {
		PhotoManager photoManager= new PhotoManager();
		System.out.println(photoManager.addPhoto
				("umcp/college1.jpg", 300, 400, "10/18/2020-17:10"));
		System.out.println(photoManager.addPhoto
				(null, 300, 400, null));
	}

	@Test
	public void addCommentsTest1() {
		PhotoManager photoManager= new PhotoManager();
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		System.out.println(photoManager.addComment("umcp/college1.jpg", "I love this photo"));
		System.out.println(photoManager.addComment(null, null));
		System.out.println(photoManager.addComment("umcp/college1.jpg", ""));
		
	}
	
	@Test
	public void getCommentsTest1() {
		PhotoManager photoManager= new PhotoManager();
		Photo photo1= new Photo("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addComment("umcp/college1.jpg", "I love this photo");
		System.out.println(photoManager.getComments("umcp/college1.jpg"));
	}
	
	@Test
	public void loadPhotosTest1() {
		PhotoManager photoManager= new PhotoManager();
		Photo photo1= new Photo("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		String filename= "photoInfoToLoad.txt"; 
		String filename1= null;
		                                                     
		System.out.println(photoManager.loadPhotos(filename));
		System.out.println(photoManager.loadPhotos(filename1));
		
	}
	
	@Test
	public void findPhotoTest1() {
		PhotoManager photoManager= new PhotoManager();
		Photo photo1= new Photo("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		System.out.println(photoManager.findPhoto("umcp/college1.jpg"));
		System.out.println(photoManager.findPhoto(null));
	}
	
	@Test
	public void removePhotoTest1() {
		PhotoManager photoManager= new PhotoManager();
		Photo photo1= new Photo("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college2.jpg", 500, 300, "10/20/2020-18:10");
		System.out.println(photoManager.removePhoto(null));
		System.out.println(photoManager.removePhoto("umcp/college2.jpg"));
	}
	
	@Test
	public void sortAllPhotosTest1() {
		PhotoManager photoManager= new PhotoManager();
		Photo photo1= new Photo("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		photoManager.addPhoto("umcp/college2.jpg", 500, 300, "10/20/2020-18:10");
		photoManager.sortPhotosByDate();
		String date= photoManager+ "";
		System.out.println(date);
		
	}
	
	@Test
	public void toStringPhotoManagerTest1() {
		PhotoManager photoManager= new PhotoManager();
		Photo photo1= new Photo("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		photoManager.addPhoto("umcp/college2.jpg", 500, 300, "10/20/2020-18:10");
		System.out.println(photoManager.toString());
	}
	
	@Test
	public void removeAllPhotosTest1() {
		PhotoManager photoManager= new PhotoManager();
		Photo photo1= new Photo("umcp/college1.jpg", 300, 400, "10/18/2020-17:10");
		photoManager.addPhoto("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		photoManager.addPhoto("umcp/college2.jpg", 500, 300, "10/20/2020-18:10");
		photoManager.removeAllPhotos();
		String after= photoManager+ "";
		System.out.print(after);
	}
	
	@Test
	public void toStringPhotoTest1() {
		Photo photo2= new Photo("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		System.out.println(photo2.toString());
	}
	
	@Test
	public void getMethodsForPhotoClassTest1() {
		Photo photo2= new Photo("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		System.out.println(photo2.getPhotoSource());
		System.out.println(photo2.getWidth());
		System.out.println(photo2.getDate());
		System.out.println(photo2.getHeight());
	}
	
	@Test
	public void addCommmentForPhotoClass() {
		Photo photo2= new Photo("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		photo2.addComments("Best day ever");
		System.out.println(photo2.getComments());
	}
	
	@Test
	public void copyPhotoTest1() {
		Photo photo2= new Photo("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		photo2.addComments("Best day ever");
		Photo photo3= new Photo(photo2);
		photo3.addComments("loved the sun");
		String copy= photo3.toString() + ", " + photo3.getComments();
		System.out.println(copy);
	}
	
	@Test
	public void comparePhotoTest1() {
		Photo photo2= new Photo("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		Photo photo3= new Photo("umcp/college1.jpg", 500, 400, "10/13/2020-19:14");
		Photo photo4= new Photo("umcp/college1.jpg", 300, 400, "10/21/2020-17:10");
		System.out.println(photo2.compareTo(photo4));
		System.out.println(photo2.compareTo(photo3));
		System.out.println(photo3.compareTo(photo2));
	}
	
	
	
	
	
	
	
	
	
	
	

}