import java.sql.SQLOutput;
import java.util.ArrayList;

public class gameRunnerLeo {

    private static String a;

    public static void main(String[] args) {

        Player leo = new Player("leo");

        leo.display("leo's game");
        leo.paintComponent(leo.getGraphics());

        ArrayList<String> list = new ArrayList<>();

        //Place all ships

        while (leo.getCount() < 3) {

            while (true) {

                a = leo.coordinateClick();

                //This needs to be here some reason


                if (a != null && !a.equals("ZZ") && !list.contains(a)) {

                    System.out.println(a);
                    list.add(a);
                    leo.dontLie(a);
                    leo.paintComponent(leo.getGraphics());
                    leo.placeShips(a);

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

            if (b != null && !b.equals("ZZ") && !b.equals(a)) {
                leo.paintComponent(leo.getGraphics());
                System.out.println(b);
                clientSide cs = new clientSide("10.117.50.201", 888, b);
                break;
            }
        }




    }

}
