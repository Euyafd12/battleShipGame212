import java.util.ArrayList;

public class gameRunner {

    public static void main(String[] args) {

        Player eyad = new Player("eyad");

        eyad.display("eyad's game");
        eyad.paintComponent(eyad.getGraphics());

        //Player leo = new Player("leo");
        //leo.display("leo's game");

        ArrayList<String> list = new ArrayList<>();

        //Place all ships

        while (eyad.getCount() < 17) {

            while (true) {

                String a = eyad.coordinateClick();

                //This needs to be here some reason
                System.out.print("");

                if (a != null && !a.equals("ZZ") && !list.contains(a)) {

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

    }

}