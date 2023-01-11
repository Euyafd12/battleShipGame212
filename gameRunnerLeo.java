import java.sql.SQLOutput;
import java.util.ArrayList;

public class gameRunnerLeo {

    private static String a;

    public static void main(String[] args) throws InterruptedException {

        Player leo = new Player("leo");

        leo.display("leo's game");
        leo.paintComponent(leo.getGraphics());

        ArrayList<String> list = new ArrayList<>();

        //Place all ships


        //Make Leo's attack on click, not on time
        while (leo.getCount() < 3) {

            if (leo.getCount() == 2) {
                break;
            }

            while (true) {

                a = leo.coordinateClick();
                System.out.println(a);

                if (a != null && !a.equals("ZZ") && !list.contains(a)) {

                    String c = leo.convertCord(leo.mouseHoveronthing());

                    System.out.println(c);
                    list.add(c);
                    leo.dontLie(c);
                    leo.paintComponent(leo.getGraphics());
                    leo.placeShips(c);

                    System.out.println(leo.getCount());
                    System.out.println("\n" + leo.boardOneLine());
                    break;
                }
            }
        }
        System.out.println("DONE");
        while (true) {

            String b = leo.coordinateClick();

            //This needs to be here some reason
            System.out.print("");

            if (b != null && !b.equals("ZZ")) {

                //leo.paintComponent(leo.getGraphics());
                System.out.println(leo.mouseHoveronthing());


                //clientSide cs = new clientSide("localhost", 888, b);
                clientSide cs = new clientSide("10.117.50.202", 888, leo.convertCord(leo.mouseHoveronthing()));
                break;
            }
        }


        serverSide ss = new serverSide();

        String c = "";

        while (c.length() < 1 || c.equals("ZZ")) {

            if (c.equals("ZZ")) {
                c = "";
            }
            String test = "";
            try {
                test += ss.doTheThing(888);
            }
            catch (Exception ignored) {

            }
            c += test;
        }
        System.out.println(c);
        System.out.println(leo.hitCheck(c));
        System.out.println(leo.boardOneLine());




    }

}
