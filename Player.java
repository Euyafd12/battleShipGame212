public class Player extends gameBoard{

    private String name;
    private int count;

    public Player(String s){
        //board1=gameBoard.super();
       super();
       name = s;
       count=14;

    }


    public String printName()
    {
        return name;
    }

    public void hits()
    {
        count--;
    }

    public String attackGuess(String coord) {

        return coord;
    }
}
