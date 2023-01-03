import java.util.ArrayList;

public class gameRunnerLeo {

    public static void main(String[] args) {

        Player leo = new Player("leo");

        leo.display("leo's game");
        leo.paintComponent(leo.getGraphics());

        ArrayList<String> list = new ArrayList<>();

        //Place all ships

        while (leo.getCount() < 17) {

            while (true) {

                String a = leo.coordinateClick();

                //This needs to be here some reason
                System.out.print("");

                if (a != null && !a.equals("ZZ") && !list.contains(a)) {

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

    }
}
