import java.io.*;
import java.net.*;
  
public class clientSide {

    private Socket socket = null;
    private String input = null;
    private DataOutputStream out = null;

    public clientSide(String address, int port, String s) {

        try {
  
            socket = new Socket(address, port);
  
            System.out.println("Connected");

            input = s;

            out = new DataOutputStream(
                socket.getOutputStream());
        }

        catch (IOException u) {

            System.out.println(u);
        }

        try {
            out.writeUTF(input);
        }

        catch (IOException u) {

            System.out.println(u);
        }

        try {
  
            out.close();
  
            socket.close();
        }
  
        catch (IOException i) {
  
            System.out.println(i);
        }
    }
}