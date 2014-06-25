import java.io.File;
import java.io.*;


public class readDatabase {
	
	private 
	String fileList = null;
	
	public 
	File[] getFiles(String location){
		
		File directory = new File(location);
		File[] listOfFiles = directory.listFiles();
	 
		return listOfFiles; 
	}
}