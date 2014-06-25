import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.POITextExtractor;
import java.io.InputStream;




public class DocRead extends FileTypeRead {
	
	private
	String path;
	String[] docArray;
	
	public DocRead(String location) {path = location;}
	
	public String[] Read(){
		
		try{
		InputStream fis = new FileInputStream(path);
		POITextExtractor extractor;
		
		
		XWPFDocument doc = new XWPFDocument(fis);
	    extractor = new XWPFWordExtractor(doc);
	    String s = extractor.getText();
	    docArray  = s.split("\\.");
	    //System.out.println(s);
		}catch(IOException io){}
	
		return docArray;
	}
	
}
