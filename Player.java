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
               board[i][j] = 'o';
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

    public int getCount() {
        return count;
    }

    public String printName() {

        return name;

    }

    public void hits() {

        count--;
    }

    /*
    public void addFiveLength(String coord) {

        if (count == 0) {
            if (!coord.equals("ZZ")) {
                board[reverse.get(coord.substring(0, 1)) - 1][Integer.parseInt(coord.substring(1)) - 1] = 'S';
            }
        }
    }

    public void addFourLength(String coord) {

        if (count == 0) {
            if (!coord.equals("ZZ")) {
                board[reverse.get(coord.substring(0, 1)) - 1][Integer.parseInt(coord.substring(1)) - 1] = 'S';
            }
        }
    }
    */

    public boolean addThreeLength(String coord) {

        if (!coord.equals("ZZ")) {

            int x = reverse.get(coord.substring(0, 1)) - 1;
            int y = Integer.parseInt(coord.substring(1)) - 1;

            if (count == 0) {
                //Inputs coordinate by converting form "A1" format to normal numbers
                 board[x][y] = 'S';
            }

            else {

                //Checks if coord is not in a corner and there is room for ship
                if (x < 9 && x > 0 && y < 9 && y > 0) {

                    if (board[x + 1][y] == 'S' || board[x - 1][y] == 'S' || board[y + 1][x] == 'S' || board[y - 1][x] == 'S') {
                        board[x][y] = 'S';
                    }
                }

                //Handle corner cases
                else {

                    //This seems like a dumb way to write this?

                    if ((x == 0 && y == 0) && (board[x + 1][y] == 'S' || board[x][y + 1] == 'S')) {
                        board[x][y] = 'S';
                    }
                    if ((x == 9 && y == 0) && (board[x - 1][y] == 'S' || board[x][y + 1] == 'S')) {
                        board[x][y] = 'S';
                    }
                    if ((x == 0 && y == 9) && (board[x + 1][y] == 'S' || board[x][y - 1] == 'S')) {
                        board[x][y] = 'S';
                    }
                    if ((x == 9 && y == 9) && (board[x - 1][y] == 'S' || board[x][y - 1] == 'S')) {
                        board[x][y] = 'S';
                    }
                }
            }
            count++;
            return true;
        }
        return false;
    }

    /*
    public void addTwoLength(String coord) {

        if (count == 0) {
            if (!coord.equals("ZZ")) {
                board[reverse.get(coord.substring(0, 1)) - 1][Integer.parseInt(coord.substring(1)) - 1] = 'S';
            }
        }
    }

    */

}
