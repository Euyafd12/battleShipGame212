public class Player extends gameBoard{

    private String name;
    private char[][] board1;

    public Player(){
        board1=gameBoard.super();
        name ="";

    }

    public String boardOneLine() {

        String ret = "";

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (j != 9) {
                    ret += board1[i][j] + ", ";
                }
                else {
                    ret += board1[i][j];
                }
            }
        }

        return ret;
    }
}
