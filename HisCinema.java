import java.io.*;
import java.net.*;

public class HisCinema {
  // Change the WebServer TCP port accordingly
  public static final int HIS_CINEMA_PORT = 40280;

  ServerSocket serverSocket;

  public static void main(String[] args) throws Exception{
    new HisCinema().runServer();
  }

  public void runServer() throws Exception{
    //Create a welcoming socket at our specific port
    System.out.println("Server is started");
    serverSocket = new ServerSocket(HIS_CINEMA_PORT);
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
