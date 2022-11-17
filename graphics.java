import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class graphics implements EventListener {

    private static JPanel panel;
    private static JFrame frame;
    private int baseX, baseY;
    //400 x and 200 y
    public graphics() {

        frame = new JFrame("This is not going to work");
        panel = new JPanel();
        Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
        baseX = monitor.width;
        baseY = monitor.height;

        frame.setSize(baseX, baseY);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        int x = MouseInfo.getPointerInfo().getLocation().x;
        int y = MouseInfo.getPointerInfo().getLocation().y;

        JLabel label = new JLabel("Pointing at x - " + x + " & at y - " + y);
        panel.add(label);

        try {

            while (true) {

                System.out.println("hello");
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



    public static void main(String[] args) {

        graphics g = new graphics();
    }
}
