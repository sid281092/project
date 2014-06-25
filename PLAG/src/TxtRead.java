import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TxtRead extends FileTypeRead {
	
	
	private 
	String path;
	String wholeTxtFile = "";
	String[] sentencesArray ;
	
	public TxtRead(String location) {path = location;} // constructor
	
	public String[] Read(){
	BufferedReader br = null;
	 
	try {

		String sCurrentLine;

		br = new BufferedReader(new FileReader(path));

		while ((sCurrentLine = br.readLine()) != null) {
			
			wholeTxtFile += sCurrentLine;
		}
		//System.out.println(wholeTxtFile);
		
		sentencesArray = wholeTxtFile.split("\\.");
		
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		try {
			if (br != null)br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
		return sentencesArray;
	}
	
	

}
