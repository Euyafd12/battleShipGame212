import java.io.*;
import java.net.*;
  
public class serverSide {

    private Socket socket;
    private ServerSocket server;
    private DataInputStream in;

    public serverSide() {

        socket = null;
        server = null;
        in = null;
    }

    public String receiveString(int port) {

        try {

            server = new ServerSocket(port);
            socket = server.accept();

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            try {
                line = in.readUTF();
            }
            catch (IOException i) {

                System.out.println(i);
            }

            socket.close();

            in.close();

            return line;
        }
        catch (IOException i) {

            System.out.println(i);
        }


        return "ERROR";
    }
}