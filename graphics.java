import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class graphics extends JPanel implements MouseListener{
    private int x, y, baseX, baseY;
    private Image imageBackground, imageBoard, imageBoardCoords, imageICN, imageBOOM, imageNOTBOOM;
    private final Map<Integer, String> letter;
    private final Map<String, Integer> reverse;
    private final ArrayList<String> hits, misses;

    public graphics() {

        hits = new ArrayList<>();
        misses = new ArrayList<>();


        baseX = 977;
        baseY = 155;


        letter = new HashMap<>();
        reverse = new HashMap<>();


        for (int i = 0; i < 10; i++) {
            letter.put(i + 1, "" + (char) ('A' + i));
            reverse.put(letter.get(i+1), i+1);
        }


        imageBoardCoords = new ImageIcon("Asset 4.png").getImage();
        imageBoard = new ImageIcon("Asset 3.png").getImage();
        imageBackground = new ImageIcon("world-of-warships.jpg").getImage();
        imageICN = new ImageIcon("icon.png").getImage();

        imageBOOM = new ImageIcon("boom.jpg").getImage();
        //imageBOOM = imageBOOM.getScaledInstance(82, 82, Image.SCALE_DEFAULT);

        imageNOTBOOM = new ImageIcon("notboom.jpg").getImage();
        //imageNOTBOOM = imageNOTBOOM.getScaledInstance(82, 82, Image.SCALE_DEFAULT);

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
        repaint();
        System.out.print("X - coordinate: " + x + " & Y - coordinate: " + y + "  -------------------------- ") ;

    }
    public void display() {

        JFrame frame = new JFrame("Battleship");
        frame.setIconImage(imageICN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        addMouseListener(this);

        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }
    
    public void paintComponent(Graphics window) {

        Graphics2D g2d = (Graphics2D) window;

        g2d.drawImage(imageBackground, 0, 0, 1920, 1080, null);
        g2d.drawImage(imageBoard, 970, 125, 850, 850, null);
        g2d.drawImage(imageBoardCoords, 900, 50, 925, 925, null);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(50, 75, 350, 900);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 75, 350, 900);

        System.out.println(coordinateClick());
        //Explosion(coordinateClick(), g2d);
        Misses(coordinateClick(), g2d);

    }

    public void Explosion(String a, Graphics2D g2d) {

        if (!a.equals("Out of Bounds")) {
            hits.add(a);
        }
        for (String hit : hits) {

            int C1 = Integer.parseInt(hit.substring(1)) - 1;
            int C2 = reverse.get(hit.substring(0, 1)) - 1;

            g2d.drawImage(imageBOOM, 973 + (C1 * 85), 128 + (C2 * 85), 82, 82, null);
        }
    }

    public void Misses(String a, Graphics2D g2d) {

        if (!a.equals("Out of Bounds")) {
            misses.add(a);
        }

        for (String miss : misses) {

            int C1 = Integer.parseInt(miss.substring(1)) - 1;
            int C2 = reverse.get(miss.substring(0, 1)) - 1;

            g2d.drawImage(imageNOTBOOM, 973 + (C1 * 85), 128 + (C2 * 85), 82, 82, null);
        }
    }

    public String coordinateClick() {

        String ret = "";

        if (x >= baseX && x <= 1828 && y >= baseY && y <= 1005) {

            ret = letter.get(((y - baseY) / 85) + 1) + "" + (((x - baseX) / 85) + 1);
            return ret;
        }
        else {
            return "Out of Bounds";
        }
    }

    public static void main(String[] args) {
        new graphics().display();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Dead method
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Dead method
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Dead method
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Dead method
    }
}
