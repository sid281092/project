import org.pdfbox.cos.COSDocument;
import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDDocumentInformation;
import org.pdfbox.util.PDFTextStripper;
import java.io.FileInputStream;


public class PdfRead {
	
	String path;
	PDFParser parser;
	String parsedText;
	PDFTextStripper pdfStripper;
	PDDocument pdDoc;
	COSDocument cosDoc;
	PDDocumentInformation pdDocInfo;
 
// PDFTextParser Constructor
	public PdfRead(String p) {	path=p;	}
// Extract text from PDF Document
	String[] pdftoText() {
 
 
		try {
			parser = new PDFParser(new FileInputStream(path));
		} catch (Exception e) {
			System.out.println("Unable to open PDF Parser.");
			return null;
		}
 
		try {
			parser.parse();
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
		} catch (Exception e) {
			System.out.println("An exception occured in parsing the PDF Document.");
			e.printStackTrace();
			try {
				if (cosDoc != null) cosDoc.close();
				if (pdDoc != null) pdDoc.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
			return null;
		}
		
		return parsedText.split("\\.");
	}
 
}