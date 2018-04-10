import java.io.*;
import java.net.*;


public class WebServer {
  
  ServerSocket serverSocket;
  
  public static void main(String[] args) throws Exception{
        // Prints "Hello, World" to the terminal window.
        new WebServer().runServer();
    }
  
  public void runServer() throws Exception{
    //Create a welcoming socket at our specific port
    System.out.println("Server is started");
    serverSocket = new ServerSocket(40280);
    
    
    acceptRequests();
  }
  
  private void acceptRequests() throws Exception {
    while(true){
      //wait, on welcoming socket for contanct by client
      Socket s = serverSocket.accept();
      
      ConnectionHandler ch = new ConnectionHandler(s);
      
      ch.start();
      
    }
  }
}