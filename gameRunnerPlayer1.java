import java.util.*;

public class gameRunnerPlayer1 {
    public void run() throws InterruptedException {

        int Port = 800;

        //Initialize Player and Board
        Player player = new Player("Eyad");
        player.display("" + player.getName() + "'s Game");

        //How Many Ships Do We Want In The Game
        int shipAmountRule = 17;

        //List of Existing Ships to Prevent Overwrite
        ArrayList<String> shipList = new ArrayList<>();

        //Start Ship Placing Phase
        while (player.getCount() < shipAmountRule) {

            while (true) {

                System.out.print("");

                if (player.getPressed()) {

                    String shipCoord = player.convertCord(player.getMouseHover());

                    if (!shipList.contains(shipCoord) && !shipCoord.equals("ZZ")) {

                        shipList.add(shipCoord);
                        player.placeShip(shipCoord);
                        player.paintComponent(player.getGraphics());
                        player.g2dShipPlaced(shipCoord);
                        break;
                    }
                }
            }
        }



        //Start Game Phase
        Thread.sleep(100);
        System.out.println("DONE PLACING SHIPS; TIME TO PLAY" + "\n");


        while (player.getCount() > 0) {

            //Receive Attack Coordinate And Check If It Hits
            serverSide ss1 = new serverSide();
            String receivedClick = "";

            while (receivedClick.length() < 1) {

                try {
                    receivedClick += ss1.receiveString(Port);
                } catch (Exception ignored) {}
            }
            Port++;



            //Effect the two boards depending on HIT or MISS
            if (player.hitCheck(receivedClick).equals("HIT")) {

                player.g2dShipDamage(receivedClick);
                player.dropCount();
                new clientSide("localhost", Port, "HIT");
            }
            else {
                new clientSide("localhost", Port, "MISS");
            }
            Port++;



            //Send Attack Coordinate
            String attackCoord = "";

            while (true) {

                System.out.print("");

                if (player.getPressed()) {

                    attackCoord += player.convertCord(player.getMouseHover());

                    new clientSide("localhost", Port, attackCoord);
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
                    test += ss2.receiveString(Port);
                } catch (Exception ignored) {
                }
                hitOrMiss += test;
            }

            if (hitOrMiss.equals("HIT")) {
                player.g2dHit(attackCoord);
            } else {
                player.g2dMiss(attackCoord);
            }
            Port++;
        }
        System.out.println("YOU LOSE");
    }

    public static void main(String[] args) throws InterruptedException {

        new gameRunnerPlayer1().run();
    }
}