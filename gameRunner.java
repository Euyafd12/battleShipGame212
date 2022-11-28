public class gameRunner {

    public static void main(String[] args) {

        Player eyad = new Player("eyad");
        eyad.display();

        while (true) {

            while (true) {

                String a = eyad.coordinateClick();

                //This needs to be here some reason
                System.out.print("");

                if (a != null && !a.equals("ZZ")) {

                    eyad.addShips(a);
                    System.out.println("\n" + eyad.boardOneLine());
                    break;
                }
            }
        }
    }
}
