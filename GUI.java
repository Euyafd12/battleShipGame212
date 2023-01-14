import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class GUI extends JPanel implements MouseListener {
    public int baseX, baseY;
    public boolean pressed;
    private final Image imageBackground, imageBoardGrid, imageBoardCoords, imageICN, imageAttackHit, imageAttackMiss, imageShipDamage;
    public Map<Integer, String> letter;
    public Map<String, Integer> reverse;
    private final ArrayList<String> g2dListHits, g2dListMisses, g2dListShips, g2dListDamage;
    private Graphics2D g2d;

    public GUI() {

        pressed = false;
        g2d = null;

        g2dListHits = new ArrayList<>();
        g2dListMisses = new ArrayList<>();
        g2dListDamage = new ArrayList<>();
        g2dListShips = new ArrayList<>();

        baseX = 977;
        baseY = 155;

        letter = new HashMap<>();
        reverse = new HashMap<>();

        for (int i = 0; i < 10; i++) {

            letter.put(i + 1, "" + (char) ('A' + i));
            reverse.put(letter.get(i+1), i+1);
        }

        imageBoardCoords = new ImageIcon("coordinates.png").getImage();
        imageBoardGrid = new ImageIcon("grid.png").getImage();
        imageBackground = new ImageIcon("background.jpg").getImage();
        imageICN = new ImageIcon("windowIcon.png").getImage();
        imageAttackHit = new ImageIcon("picAttackHit.png").getImage();
        imageAttackMiss = new ImageIcon("picAttackMiss.png").getImage();
        imageShipDamage = new ImageIcon("picShipDamage.png").getImage();
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

        //Load in Background and Board Features
        g2d.drawImage(imageBackground, 0, 0, 1920, 1080, null);
        g2d.drawImage(imageBoardGrid, 970, 125, 850, 850, null);
        g2d.drawImage(imageBoardCoords, 900, 50, 925, 925, null);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(50, 75, 350, 900);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 75, 350, 900);

        //Text Box Instructions
        Font font = new Font("Futura", Font.BOLD, 27);
        g2d.setFont(font);

        g2d.drawString("Welcome to BattleShip!", 75, 125);
        g2d.drawString("-----------------------------------", 70, 150);

        font = new Font("Futura", Font.BOLD, 24);
        g2d.setFont(font);
        g2d.drawString("How to Play: ", 75, 200);

        font = new Font("Futura", Font.BOLD, 22);
        g2d.setFont(font);
        g2d.drawString("1) Place all your battleships", 85, 240);
        g2d.drawString("2) Take turns with your ", 85, 280);
        g2d.drawString("opponent to attack each other", 85, 320);
        g2d.drawString("3) Completely destroy all of", 85, 360);
        g2d.drawString("your opponent's battleships", 85, 400);

        font = new Font("Futura", Font.BOLD, 24);
        g2d.setFont(font);
        g2d.drawString("Placing ships: ", 75, 550);

        font = new Font("Futura", Font.BOLD, 22);
        g2d.setFont(font);
        g2d.drawString("1) Carrier [5 Length]", 85, 590);
        g2d.drawString("2) Battleship [4 Length]", 85, 630);
        g2d.drawString("3) Cruiser [3 Length]", 85, 670);
        g2d.drawString("4) Submarine [3 Length]", 85, 710);
        g2d.drawString("5) Destroyer [2 Length]", 85, 750);
    }

    public void paintComponent(Graphics window) {

        g2d = (Graphics2D) window;
        prepGUI();
    }

    public String getMouseHover() {

        return "" + MouseInfo.getPointerInfo().getLocation().x + " " + MouseInfo.getPointerInfo().getLocation().y;
    }

    public void mouseClicked(MouseEvent e) {

        pressed = true;

        try {
            Thread.sleep(50);
        } catch (InterruptedException ignored) {}

        pressed = false;
    }

    public void g2dShipPlaced(String a) {

        g2dListShips.add(a);

        for (String ship : g2dListShips) {

            int C1 = Integer.parseInt(ship.substring(1)) - 1;
            int C2 = reverse.get(ship.substring(0, 1)) - 1;

            g2d.setColor(Color.GRAY);
            g2d.fillRect(973 + (C1 * 85), 128 + (C2 * 85), 82, 82);
        }
        audio("soundShipPlace.wav");
    }

    public void g2dShipDamage(String a) {

        g2dListDamage.add(a);

        for (String damage : g2dListDamage) {

            int C1 = Integer.parseInt(damage.substring(1)) - 1;
            int C2 = reverse.get(damage.substring(0, 1)) - 1;

            g2d.drawImage(imageShipDamage, 973 + (C1 * 85), 128 + (C2 * 85), 82, 82, null);
        }
        audio("soundExplosion.wav");
    }

    public void g2dHit(String a) {

        g2dListHits.add(a);

        for (String hit : g2dListHits) {

            int C1 = Integer.parseInt(hit.substring(1)) - 1;
            int C2 = reverse.get(hit.substring(0, 1)) - 1;

            g2d.drawImage(imageAttackHit, 973 + (C1 * 85), 128 + (C2 * 85), 82, 82, null);
        }
        audio("soundExplosion.wav");
    }

    public void g2dMiss(String a) {

        g2dListMisses.add(a);

        for (String miss : g2dListMisses) {

            int C1 = Integer.parseInt(miss.substring(1)) - 1;
            int C2 = reverse.get(miss.substring(0, 1)) - 1;

            g2d.drawImage(imageAttackMiss, 973 + (C1 * 85), 128 + (C2 * 85), 82, 82, null);;
        }
        audio("soundSplash.wav");
    }

    public void audio(String a) {

        try {
            AudioInputStream system = AudioSystem.getAudioInputStream(new File(a));
            Clip sound = AudioSystem.getClip();
            sound.open(system);
            sound.start();
        } catch (Exception ignore) {}
    }

    public static void main(String[] args) {

        new GUI().display("Battleship");
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
