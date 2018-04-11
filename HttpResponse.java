import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HttpResponse {

  HttpRequest req;
  String response;
  String root = "/home/philip/Desktop/cps706/hisCinema-NEW";
  File f;
  public HttpResponse(HttpRequest request){
    req = request;
    System.out.println("EQUALS? " + req.filename.equals("/"));
    if(req.filename.equals("/")){
      f = new File(root + "/index.html");
    }else{
      f = new File(root + req.filename);
    }
    try {
      FileInputStream fis = new FileInputStream(f);
      response += "HTTP/1.1 200 \r\n";
      response += "Server: Our Java Server/1.0 \r\n";
      response += "Connection: close \r\n";
      response += "Content-Length: " + f.length() + "\r\n";
      response += "\r\n";
      int s;
      while ((s = fis.read()) != -1 ) {
        response += (char) s;
      }
      fis.close();
      String responseHeader = "";
    }catch(FileNotFoundException e){
      System.out.println("COULDNT FIND FILE: " + req.filename);
      System.out.println("    (is your root variable set correctly?)");
      try{
        File file404 = new File(root + "/404.html");
        FileInputStream file404is = new FileInputStream(file404);
        response += "HTTP/1.1 200 \r\n";
        response += "Server: Our Java Server/1.0 \r\n";
        response += "Connection: close \r\n";
        response += "Content-Length: " + file404.length() + "\r\n";
        response += "\r\n";
        int s;
        while ((s = file404is.read()) != -1 ) {
          response += (char) s;
        }
        file404is.close();
        String responseHeader = "";
      }catch(FileNotFoundException e1){
        //Ignore
      }catch(Exception e2){
        //Ignore
      }
    }catch(Exception e){
      System.out.println("Something went wrong: " + e);
      try{
        File file500 = new File(root + "/500.html");
        FileInputStream file500is = new FileInputStream(file500);
        response += "HTTP/1.1 500 \r\n";
        response += "Server: Our Java Server/1.0 \r\n";
        response += "Connection: close \r\n";
        response += "Content-Length: " + file500.length() + "\r\n";
        response += "\r\n";
        int s;
        while ((s = file500is.read()) != -1 ) {
          response += (char) s;
        }
        file500is.close();
        String responseHeader = "";
      }catch(FileNotFoundException e1){
        //Ignore
      }catch(Exception e2){
        //Ignore
      }
    }
  }

}
