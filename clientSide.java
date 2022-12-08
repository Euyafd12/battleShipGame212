import java.io.*;
import java.net.*;
  
public class clientSide {
  
    // initialize socket and input output streams
    private Socket socket = null;

    private String input = "";
    private DataOutputStream out = null;
  
    // constructor to put ip address and port
    public clientSide(String address, int port, String s) throws IOException {

            // establish a connection05516752ae5f9200b5cf7c6e

        try {
  
            socket = new Socket(address, port);
  
            System.out.println("Connected");
  
            // takes input from terminal
            input = s;
  
            // sends output to the socket
            out = new DataOutputStream(
                socket.getOutputStream());
        }
  
        catch (UnknownHostException u) {
  
            System.out.println(u);
        }
  
        catch (IOException i) {
  

            //System.out.println(i);
        }
  
        // string to read message from input
        out.writeUTF(input);
  
        // keep reading until "End" is input

  
        // close the connection
        try {
  

  

            out.close();
  
            socket.close();
        }
  
        catch (IOException i) {
  
            System.out.println(i);
        }
    }

}