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

    public String doTheThing(int port) {

        try {
            server = new ServerSocket(port);

            //System.out.println("Server started");

            //System.out.println("Waiting for a client ...");

            socket = server.accept();

            //System.out.println("Client accepted");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";


            try {
                line = in.readUTF();
            }

            catch (IOException i) {

                System.out.println(i);
            }


            //System.out.println("Closing connection");

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