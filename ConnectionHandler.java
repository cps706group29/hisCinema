import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;


public class ConnectionHandler extends Thread{
  
  Socket s;
  PrintWriter pw;
  BufferedReader br;
  
  public ConnectionHandler(Socket s) throws Exception {
    this.s = s;
    br = new  BufferedReader(new InputStreamReader(s.getInputStream()));
    pw = new PrintWriter(s.getOutputStream());
  }
  
  @Override
  public void run(){
    
    try{
      String reqS = "";
      
      while(br.ready() || reqS.length() == 0){
        reqS += (char) br.read();
      }
      
      System.out.println(reqS);
      HttpRequest req = new HttpRequest(reqS);
      
      HttpResponse res = new HttpResponse(req);
      
      pw.write(res.response.toCharArray());
      
      pw.close();
      br.close();
      s.close();
      
      
      
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
}