import java.io.File;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException{
		
	/*	-----------------------	Local Reference Database	-----------------------------*/
		String directoryPath = "D:/studia/others/java/plagiarism/Database/";	//database folder
		readDatabase read = new readDatabase();
		File[] fileList = read.getFiles(directoryPath);
	/*	-----------------------------------------------------------------------------------*/			

		/*-----------------------	Tested File	--------------------------------------------*/
		String testFilePath = "C:/Users/Damian/Desktop/test.txt";	// test file location
		String[] testArray = null;
		
		if(testFilePath.endsWith(".txt")){	// if this is a "text" file			
			TxtRead TXT = new TxtRead(testFilePath);
			testArray = TXT.Read();
		}
		/*-----------------------	Tested File	---------------------------------------------*/

		
		for(int i = 0; i < fileList.length; i++)
		{	
			String[] refArray=null;
			int count = 0;	
			String fileName = fileList[i].getName();		// name of the file
			LevenshteinDistance distance = new LevenshteinDistance();
			
			/*-------------------------------------------------------------------------------*/			
			if(fileName.endsWith(".txt")){					// if this is a "text" file			
				TxtRead TXT = new TxtRead(directoryPath + fileName);
				refArray = TXT.Read();
				System.out.println(testFilePath + "	comparision with	"+directoryPath + fileName);
				for(int m = 0; m<testArray.length; m++)
				{	
					for(int n = 0; n<refArray.length; n++)
					{
						if(distance.similarity(refArray[n], testArray[m]) > 0.45)
							{
							System.out.println("Sentence:	"+testArray[m] +"\n");
							System.out.println("Is similar to:	"+refArray[n] +"\n");
							count++;
							}
					}
					
			
				}		
					Calculate calc = new Calculate(count,testArray.length );
					calc.displayResult();
			}
			
			else if(fileName.endsWith(".pdf")){			// if this is a "PDF" file
				PdfRead PDF  = new PdfRead(directoryPath + fileName);
				refArray = PDF.pdftoText();
				
				for(int m = 0; m<testArray.length; m++)
				{	
					for(int n = 0; n<refArray.length; n++)
					{
						if(distance.similarity(refArray[n], testArray[m]) > 0.3)
						{
						System.out.println("Sentence:	"+testArray[m] +"\n");
						System.out.println("Is similar to:	"+refArray[n] +"\n");
						count++;
						}
					}
				}	
					Calculate calc = new Calculate(count,testArray.length );
					calc.displayResult();
			}
			
			else if(fileName.endsWith(".doc")){		// if this is a "document" file
				DocRead DOC = new DocRead(directoryPath + fileName);
				DOC.Read();
				for(int m = 0; m<testArray.length; m++)
				{	
					for(int n = 0; n<refArray.length; n++)
					{
						if(distance.similarity(refArray[n], testArray[m]) > 0.3)
						{
						System.out.println("Sentence:	"+testArray[m] +"\n");
						System.out.println("Is similar to:	"+refArray[n] +"\n");
						count++;
						}
					}
				}
					Calculate calc = new Calculate(count,testArray.length );
					calc.displayResult();
				
			}
			
			else{										// if this if another type of file
				System.out.println(fileList[i] + " cannot be served. \n" +
				"Available file types: \'.txt\',\'.PDF\',\'.docx\'. \n");
				}
			
			
			}
		
		}

}
		
	


