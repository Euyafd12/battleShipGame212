public class Player extends gameBoard{

    private String name;
    private char[][] board;

    public Player(){
       //board=super.gameBoard();
        name ="";

    }

    public String boardOneLine() {

        String ret = "";

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (j != 9) {
                    ret += board[i][j] + ", ";
                }
                else {
                    ret += board[i][j];
                }
            }
        }

        return ret;
    }
}
