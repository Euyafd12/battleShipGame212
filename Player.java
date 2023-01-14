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

    public String convertCord(String a) {

        String[] arr = a.split(" ");

        int x = Integer.parseInt(arr[0]);
        int y = Integer.parseInt(arr[1]);

        if (x >= baseX && x <= 1828 && y >= baseY && y <= 1005) {

            return letter.get(((y - baseY) / 85) + 1) + "" + (((x - baseX) / 85) + 1);
        }
        else {
            return "ZZ";
        }
    }

    public void dropCount() {
        count--;
    }

    public String hitCheck(String coord) {

        int x = reverse.get(coord.substring(0, 1)) - 1;
        int y = Integer.parseInt(coord.substring(1)) - 1;

        if (board[x][y] == 'S') {
            board[x][y] = 'D';
            return "HIT";
        }
        else {
            return "MISS";
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

    public String getName() {

        return name;
    }

    public void placeShip(String coord) {

        int x = reverse.get(coord.substring(0, 1)) - 1;
        int y = Integer.parseInt(coord.substring(1)) - 1;

        board[x][y] = 'S';
        count++;
    }

    public boolean getPressed() {

        return pressed;
    }
}
