public class gameRunner {

    public static void main(String[] args) {
        //We code seperate from code base
        //We move
        //Eyad
        //OKKKK
        //leoooooo
        Player player1 = new Player("Leo");
        Player player2 = new Player("Eyad");
        gameBoard board = new gameBoard();
        System.out.println(player1.printName());
        System.out.println(player1.boardOneLine());
        System.out.println(player2.printName());
        player2.changeCoordinate(3,3);
        System.out.println(player2.boardOneLine());


    }
}
