public class gameBoard {
    private char[][] board;

    public gameBoard() {

        board = new char[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '0';
            }
        }
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
