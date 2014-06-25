import java.net.URL;
import java.net.*;
import java.io.*;




public class getUrl {
	
	public void getUrlData()throws Exception{
	String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
	String query = "java tutorial";
	String charset = "UTF-8";

	
    URL url = new URL("https://www.google.pl/?gfe_rd=cr&ei=hp-pU-fKAuqG8QehxoD4AQ&gws_rd=ssl#q=car");
    String host = url.getHost();
    String read = url.toString();

 
    System.out.println(host);
    System.out.println(read);
	}
}
