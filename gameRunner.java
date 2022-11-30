import java.util.ArrayList;

public class gameRunner {

    public static void main(String[] args) {

        Player eyad = new Player("eyad");
        eyad.display();

        ArrayList<String> list = new ArrayList<>();

        while(eyad.getCount() < 17) {

            while (true) {

                String a = eyad.coordinateClick();

                //This needs to be here some reason
                System.out.print("");


                if (a != null && !a.equals("ZZ") && !list.contains(a)) {

                    list.add(a);
                    eyad.dontLie(a);
                    eyad.placeShips(a);
                    System.out.println(eyad.getCount());
                    System.out.println("\n" + eyad.boardOneLine());
                    break;

                }
            }
        }

    }

}