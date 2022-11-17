import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventListener;

public class graphics extends Canvas implements EventListener {

    private static JPanel panel;
    private static JFrame frame;
    private int baseX, baseY;
    //400 x and 200 y

    /*
    public void paint(Graphics window) {
        super.paint(window);
        window.setColor(Color.BLACK);
        window.fillRect(700, 250, 1000, 1000);
    }
    */


    public graphics() {

        frame = new JFrame("This is not going to work");
        panel = new JPanel();
        Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();


        frame.setSize(monitor.width, monitor.height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;

        JLabel label = new JLabel("Pointing at x - " + x + " & at y - " + y);;
        panel.add(label);

        try {
            BufferedImage image = ImageIO.read(new File("D:\\picture"));
        }
        catch (IOException io) {
            return;
        }

        try {

            while (true) {

                x = MouseInfo.getPointerInfo().getLocation().x;
                y = MouseInfo.getPointerInfo().getLocation().y;

                label.setText("Pointing at x - " + x + " & at y - " + y);

                panel.revalidate();
                panel.repaint();
                Thread.sleep(25);
            }
        }
        catch (Exception ignored) {
            return;
        }
    }




    public String coordinateClick(MouseEvent event) {

        String ret = "";

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;



        return ret;
    }
    public static void main(String[] args) {

        graphics g = new graphics();
    }
}
