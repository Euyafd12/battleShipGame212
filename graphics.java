import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class graphics implements EventListener {

    private static JPanel panel;
    private static JFrame frame;

    public graphics() {

        frame = new JFrame("This is not going to work");
        //Dimension monitor = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JButton A1 = new JButton("A0");
        JButton B1 = new JButton("B0");
        JButton A2 = new JButton("A1");
        JButton B2 = new JButton("B1");

        panel.add(A1);
        panel.add(B1);
        panel.add(A2);
        panel.add(B2);
        frame.add(panel);

        /*
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        JButton A1 = new JButton("A0");
        */
    }

    public



    public static void main(String[] args) {
        graphics g = new graphics();
    }
}
