import java.io.IOException;

public class clientHandler {


    public static void main(String[] args) throws IOException {

        String str = "bird";
        clientSide cs = new clientSide("10.117.50.201", 888, str);

    }
}
