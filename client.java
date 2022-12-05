import java.io.*;
import java.net.*;

class client {

    //This is for Leo

    public static void main(String[] args) throws Exception {

        Socket s = new Socket("10.117.50.201", 888);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
        String str, str1;

        //https://www.geeksforgeeks.org/socket-programming-in-java/
        //https://www.geeksforgeeks.org/establishing-the-two-way-communication-between-server-and-client-in-java/

        while (!(str = kb.readLine()).equals("exit")) {

            dos.writeBytes(str + "\n");

            str1 = br.readLine();

            System.out.println(str1);
        }

        dos.close();
        br.close();
        kb.close();
        s.close();
    }
}