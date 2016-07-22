import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
 
public class GraberHTML {
  
  public static void Connect() throws Exception{
    URL url = new URL("http://besta.live/?kanal=Kurdistan24TV");
    URLConnection spoof = url.openConnection();
    
    
    spoof.setRequestProperty( "User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64)" );
    BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
    String strLine = null;
    
    String x;
    StringBuffer buffer = new StringBuffer();
    while ((strLine = in.readLine()) != null){
      buffer.append(strLine);
    }
    x = buffer.toString();
    
    String t = x.substring(x.indexOf("http://62.210.100.139:1935/kurdistan24tv/smil:kurdistan24.smil/playlist.m3u8?"),x.indexOf("='", x.indexOf("http://62.210.100.139:1935/kurdistan24tv/smil:kurdistan24.smil/playlist.m3u8?")));
    //System.out.println(t+"=");
    
    
    try(  PrintWriter out = new PrintWriter( "stream.m3u8" )  ){
      out.println( t+"=" );
    }
    
  }
  
  public static void main(String[] args){
    
    try{
      //Calling the Connect method
      Connect();
    }catch(Exception e){
      
    }
  }
}