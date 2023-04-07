import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.*;

public class clientFrame {

    public clientFrame() {
        //frame
        JFrame frame = new JFrame();
        frame.setSize(1300,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Create posts and Hostname
        JPanel generalPanel = new JPanel();
        generalPanel.setSize(40,40);
        generalPanel.setBorder(createEmptyBorder(30,30,10,10));
        //panel.setLayout(new GridLayout(0,1));

        //label
        JLabel label = new JLabel("Hostname");
        label.setSize(30,30);

        //button
        JButton button = new JButton("Post");
        button.setSize(30,30);

        generalPanel.add(button);
        generalPanel.add(label);
        frame.add(generalPanel, BorderLayout.NORTH);

//Question posts Section

        JPanel postPanel = new JPanel();
        postPanel.setSize(800, 200);
        postPanel.setBorder(createEmptyBorder(500, 30, 0, 10));
        postPanel.setBorder(createEtchedBorder());

        frame.add(postPanel, BorderLayout.CENTER);


        frame.setVisible(true);


    }
}
