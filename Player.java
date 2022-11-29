public class Player extends GUI {

    private final String name;
    private char[][] board;
    private int count;

    public Player(String s) {

       name = s;
       count = 0;

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
                ret += j != 9 ? board[i][j] + "," : board[i][j] + "|";
            }
        }

        return ret;
    }

    public String printName() {

        return name;

    }

    public void hits() {

        count--;
    }

    public void addShips(String coord) {

        if (count == 0) {
            if (!coord.equals("ZZ")) {
                board[reverse.get(coord.substring(0, 1)) - 1][Integer.parseInt(coord.substring(1)) - 1] = 'S';
            }
        }



    }


}
