import java.util.ArrayList;

public class gameRunnerLeo {

    public static void main(String[] args) throws InterruptedException {

        int Port = 800;
        //Initialize player and board
        Player leo = new Player("leo");
        leo.display("Leo's game");

        //How many ships do we want in the game
        int shipAmountRule = 3;

        //List of existing ships to prevent overwrite
        ArrayList<String> shipList = new ArrayList<>();

        //Place all ships
        while (leo.getCount() < shipAmountRule) {

            while (true) {

                System.out.print("");

                if (leo.getPressed()) {

                    String shipCoord = leo.convertCord(leo.getMouseHover());

                    if (!shipList.contains(shipCoord) && !shipCoord.equals("ZZ")) {

                        shipList.add(shipCoord);
                        leo.placeShip(shipCoord);

                        leo.paintComponent(leo.getGraphics());
                        leo.g2dShipPlaced(shipCoord);
                        break;

                    }
                }
            }
        }

        Thread.sleep(100);
        System.out.println("DONE PLACING SHIPS; TIME TO PLAY" + "\n");

        while (leo.getCount() > 0) {

            //Send Attack Coordinate
            String attackCoord = "";

            while (true) {

                System.out.print("");

                if (leo.getPressed()) {

                    attackCoord += leo.convertCord(leo.getMouseHover());

                    new clientSide("localhost", Port, attackCoord);
                    //new clientSide("10.117.50.202", Port, attackCoord);
                    break;
                }
            }
            Port++;

            //Receive if you hit or missed your attack
            serverSide ss1 = new serverSide();
            String hitOrMiss = "";

            while (hitOrMiss.length() < 1) {

                String test = "";
                try {
                    test += ss1.doTheThing(Port);
                } catch (Exception ignored) {
                }
                hitOrMiss += test;
            }
            //hit
            if (hitOrMiss.equals("HIT")) {
                leo.g2dHit(attackCoord);
            } else {
                leo.g2dMiss(attackCoord);
            }
            Port++;


            //Receive Attack Coordinate and check if it hits
            serverSide ss2 = new serverSide();
            String receivedClick = "";

            while (receivedClick.length() < 1 || receivedClick.equals("ZZ")) {

                if (receivedClick.equals("ZZ")) {
                    receivedClick = "";
                }
                String test = "";
                try {
                    test += ss2.doTheThing(Port);
                } catch (Exception ignored) {

                }
                receivedClick += test;
            }
            Port++;

            //Effect board depending on HIT or MISS
            if (leo.hitCheck(receivedClick).equals("HIT")) {
                leo.g2dShipDamage(receivedClick);
                leo.dropCount();
                new clientSide("localhost", Port, "HIT");
                //new clientSide("10.117.50.201, Port,"HIT");
            } else {
                new clientSide("localhost", Port, "MISS");
                //new clientSide("10.117.50.201, Port,"MISS");
            }
            Port++;
        }
        System.out.println("YOU LOSE");

    }

}
