import java.util.*;

public class gameRunnerEyad {

    public static void main(String[] args) throws InterruptedException {

        Player eyad = new Player("eyad");

        eyad.display("eyad's game");
        eyad.paintComponent(eyad.getGraphics());

        ArrayList<String> list = new ArrayList<>();

        //Place all ships

        while (eyad.getCount() < 3) {

            while (true) {

                String a = eyad.coordinateClick();

                //This needs to be here some reason
                System.out.print("");

                if (a != null && !a.equals("ZZ") && !list.contains(a)) {

                    System.out.println(a);
                    list.add(a);
                    eyad.dontLie(a);
                    eyad.paintComponent(eyad.getGraphics());
                    eyad.placeShips(a);

                    System.out.println(eyad.getCount());
                    System.out.println("\n" + eyad.boardOneLine());
                    break;
                }
            }
        }


        //Sending first move

        serverSide ss = new serverSide();

        String c = "";

        while (c.length() < 1) {

            String test = "";
            try {
                test += ss.doTheThing(888);
            }
            catch (Exception ignored) {

            }
            c += test;
        }

        System.out.println(eyad.hitCheck(c));
        System.out.println(eyad.boardOneLine());
        System.out.println(c);

        Thread.sleep(4000);
        while (true) {

            String b = eyad.coordinateClick();

            //This needs to be here some reason
            System.out.print("");

            if (b != null && !b.equals("ZZ")) {

                //leo.paintComponent(leo.getGraphics());
                System.out.println(eyad.mouseHoveronthing());


                //clientSide cs = new clientSide("localhost", 888, b);
                clientSide cs = new clientSide("10.117.50.201", 888, eyad.convertCord(eyad.mouseHoveronthing()));
                break;
              }
       }


    }
}