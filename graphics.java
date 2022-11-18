import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Map;

public class graphics extends JPanel implements MouseListener{
    private final Image imageBoard, imageBackground, imageICN;
    private int x, y;

    public graphics() {

        imageBoard = new ImageIcon("boardV3.png").getImage();
        imageBackground = new ImageIcon("world-of-warships.jpg").getImage();
        imageICN = new ImageIcon("icon.png").getImage();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
        System.out.print("X - coordinate: " + x + " & Y - coordinate: " + y + "  -------------------------- ") ;
        repaint();
    }

    public void display() {

        JFrame frame = new JFrame("Battleship");
        frame.setIconImage(imageICN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        addMouseListener(this);


        //Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }


    public void paintComponent(Graphics window) {

        Graphics2D g2d = (Graphics2D) window;


        g2d.drawImage(imageBackground, 0, 0, 1920, 1080, null);
        g2d.drawImage(imageBoard, 900, 50, 900, 900, null);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(50, 75, 350, 900);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(50, 75, 350, 900);

        System.out.println(coordinateClick());

    }

    public String coordinateClick() {

        String ret = "";

        if (x >= 970 && x <= 1870 && y >= 165 && y <= 1065) {

            int baseX = 970;
            int baseY = 165;

            Map<Integer, String> letter = new HashMap<>();

            for (int i = 0; i < 10; i++) {
                letter.put(i + 1, "" + (char) ('A' + i));
            }

            ret += letter.get(((y - baseY) / 90) + 1) + "" + (((x - baseX) / 90) + 1);
            return ret;
        }
        else {
            return "Error";
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
