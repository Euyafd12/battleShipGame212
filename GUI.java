import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class GUI extends JPanel implements MouseListener {
    private int x, y;
    public int baseX, baseY;
    public boolean pressed;
    private final Image imageBackground, imageBoard, imageBoardCoords, imageICN, imageBOOM, imageNOTBOOM;
    public final Map<Integer, String> letter;
    public final Map<String, Integer> reverse;
    private final ArrayList<String> hits, misses, ships;
    private Graphics2D g2d;

    public GUI() {

        g2d = null;

        hits = new ArrayList<>();
        misses = new ArrayList<>();
        ships = new ArrayList<>();

        baseX = 977;
        baseY = 155;

        letter = new HashMap<>();
        reverse = new HashMap<>();

        for (int i = 0; i < 10; i++) {

            letter.put(i + 1, "" + (char) ('A' + i));
            reverse.put(letter.get(i+1), i+1);
        }

        imageBoardCoords = new ImageIcon("coordinates.png").getImage();
        imageBoard = new ImageIcon("grid.png").getImage();
        imageBackground = new ImageIcon("background.jpg").getImage();
        imageICN = new ImageIcon("windowIcon.png").getImage();
        imageBOOM = new ImageIcon("boom.jpg").getImage();
        imageNOTBOOM = new ImageIcon("notBoom.jpg").getImage();

    }

    public String giveMeXY() {

        return "" + x + "    " + y;
    }
    public void display(String s) {

        JFrame frame = new JFrame(s);
        frame.setIconImage(imageICN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        addMouseListener(this);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setResizable(false);
    }


    public void prepGUI() {

        g2d.drawImage(imageBackground, 0, 0, 1920, 1080, null);
        g2d.drawImage(imageBoard, 970, 125, 850, 850, null);
        g2d.drawImage(imageBoardCoords, 900, 50, 925, 925, null);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(50, 75, 350, 900);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 75, 350, 900);


        //Font font = new Font("Futura", Font.BOLD, 27);
        //g2d.setFont(font);

        //g2d.drawString("Welcome to BattleShip!", 75, 125);
        //g2d.drawString("Welcome to BattleShip!", 75, 125);

        //g2d.drawString("-----------------------------------", 70, 150);

        //font = new Font("Futura", Font.BOLD, 24);
        //g2d.setFont(font);
        ///g2d.drawString("Placing ships: ", 75, 200);

        /*
        font = new Font("Futura", Font.BOLD, 22);
        g2d.setFont(font);
        g2d.drawString("1) Carrier [5 Length]", 85, 240);
        g2d.drawString("2) Battleship [4 Length]", 85, 280);
        g2d.drawString("3) Cruiser [3 Length]", 85, 320);
        g2d.drawString("4) Submarine [3 Length]", 85, 360);
        g2d.drawString("5) Destroyer [2 Length]", 85, 400);

         */


    }


    public void paintComponent(Graphics window) {

        g2d = (Graphics2D) window;
        prepGUI();


        //Use this if all else fails

        /*
        if (!coordinateClick().equals("ZZ")) {
            Explosion(coordinateClick());
        }
        */

    }


    public String coordinateClick() {

        if (x >= baseX && x <= 1828 && y >= baseY && y <= 1005) {

            return letter.get(((y - baseY) / 85) + 1) + "" + (((x - baseX) / 85) + 1);
        }
        else {
            return "ZZ";
        }
    }


    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    public String mouseHoveronthing() {

        return "" + MouseInfo.getPointerInfo().getLocation().x + " " + MouseInfo.getPointerInfo().getLocation().y;
    }

    public void mouseClicked(MouseEvent e) {

        x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        y = (int) MouseInfo.getPointerInfo().getLocation().getY();
        repaint();
    }


    public void placeShips(String a) {

        if (!a.equals("Out of Bounds")) {

            ships.add(a);
        }

        for (String ship : ships) {

            int C1 = Integer.parseInt(ship.substring(1)) - 1;
            int C2 = reverse.get(ship.substring(0, 1)) - 1;

            g2d.fillRect(973 + (C1 * 85), 128 + (C2 * 85), 82, 82);

        }

        audio("BOOP.wav");
    }


    public void Explosion(String a) {

        if (!a.equals("Out of Bounds")) {

            //This seems dumb I should probably remove it
            hits.add(a);

            for (int i = 0; i < ships.size(); i++) {
                if (a.equals(ships.get(i))) {
                    ships.remove(i);
                    break;
                }
            }
        }
        for (String hit : hits) {

            int C1 = Integer.parseInt(hit.substring(1)) - 1;
            int C2 = reverse.get(hit.substring(0, 1)) - 1;

            g2d.drawImage(imageBOOM, 973 + (C1 * 85), 128 + (C2 * 85), 82, 82, null);
        }
        audio("explosionBOOM.wav");
    }


    public void Misses(String a) {

        if (!a.equals("Out of Bounds")) {

            misses.add(a);
        }
        for (String miss : misses) {

            int C1 = Integer.parseInt(miss.substring(1)) - 1;
            int C2 = reverse.get(miss.substring(0, 1)) - 1;

            g2d.drawImage(imageNOTBOOM, 973 + (C1 * 85), 128 + (C2 * 85), 82, 82, null);;
        }
        audio("waterSplash.wav");
    }


    public void audio(String a) {

        try {
            AudioInputStream system = AudioSystem.getAudioInputStream(new File(a));
            Clip sound = AudioSystem.getClip();
            sound.open(system);
            sound.start();
        }
        catch (Exception ignore) {}
    }


    public static void main(String[] args) {

        new GUI().display("Battleshipgame");
    }

    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
