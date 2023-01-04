

public class clientHandler {


    public static void main(String[] args) {

        serverSide ss = new serverSide();

        String a = "";

        while (a.length() < 1) {

            String test = "";
            try {
                test += ss.doTheThing(888);
            }
            catch (Exception ignored) {

            }
            a += test;
        }
        System.out.println(a);
    }





}
