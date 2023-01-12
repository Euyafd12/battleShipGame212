import java.util.*;

public class gameRunnerEyad {


    public static void main(String[] args) throws InterruptedException {

        int Port = 800;
        //Initialize player and board
        Player eyad = new Player("Eyad");
        eyad.display("Eyad's game");

        //How many ships do we want in the game
        int shipAmountRule = 3;

        //List of existing ships to prevent overwrite
        ArrayList<String> shipList = new ArrayList<>();

        //Place all ships
        while (eyad.getCount() < shipAmountRule) {

            while (true) {

                System.out.print("");

                if (eyad.getPressed()) {

                    String shipCoord = eyad.convertCord(eyad.getMouseHover());

                    if (!shipList.contains(shipCoord) && !shipCoord.equals("ZZ")) {

                        shipList.add(shipCoord);
                        eyad.placeShip(shipCoord);

                        eyad.paintComponent(eyad.getGraphics());
                        eyad.g2dShipPlaced(shipCoord);

                        break;

                    }
                }
            }
        }

        Thread.sleep(100);
        System.out.println("DONE PLACING SHIPS; TIME TO PLAY" + "\n");

        while (eyad.getCount() > 0) {

            //Receive Attack Coordinate and check if it hits
            serverSide ss1 = new serverSide();
            String receivedClick = "";

            while (receivedClick.length() < 1) {

                String test = "";
                try {
                    test += ss1.doTheThing(Port);
                } catch (Exception ignored) {

                }
                receivedClick += test;
            }
            Port++;

            //Effect the two boards depending on HIT or MISS
            if (eyad.hitCheck(receivedClick).equals("HIT")) {
                eyad.g2dShipDamage(receivedClick);
                eyad.dropCount();
                new clientSide("localhost", Port, "HIT");
                //new clientSide("10.117.50.201, Port,"HIT");
            } else {
                new clientSide("localhost", Port, "MISS");
                //new clientSide("10.117.50.201", Port,"HIT");
            }
            Port++;


            String attackCoord = "";
            //Send Attack Coordinate
            while (true) {

                System.out.print("");
                if (eyad.getPressed()) {

                    attackCoord += eyad.convertCord(eyad.getMouseHover());

                    new clientSide("localhost", Port, attackCoord);
                    //new clientSide("10.117.50.201", Port, attackCord);
                    break;
                }
            }
            Port++;

            //Receive if you hit or missed your attack
            serverSide ss2 = new serverSide();
            String hitOrMiss = "";

            while (hitOrMiss.length() < 1) {

                String test = "";
                try {
                    test += ss2.doTheThing(Port);
                } catch (Exception ignored) {
                }
                hitOrMiss += test;
            }

            if (hitOrMiss.equals("HIT")) {
                eyad.g2dHit(attackCoord);
            } else {
                eyad.g2dMiss(attackCoord);
            }
            Port++;
        }
        System.out.println("YOU LOSE");

    }
}