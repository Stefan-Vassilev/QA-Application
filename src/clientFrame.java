import javax.swing.*;
import java.awt.*;

import static javax.swing.BorderFactory.*;

public class clientFrame {

    JPanel individualPostPanel;
    public clientFrame() {
        //frame
        JFrame frame = new JFrame();
        frame.setSize(1300,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

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
        //Parent panel
        JPanel postPanel = new JPanel();
        frame.add(postPanel, BorderLayout.CENTER);
        postPanel.setSize(1300,654);
        postPanel.setBorder(createEtchedBorder());
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));

        //Individual posts

        individualPostPanel = new JPanel();


        postPanel.add(individualPostPanel);

        individualPostPanel.setSize(1000,120);
        individualPostPanel.setBackground(Color.black);


//        class DisplayPosts extends clientFrame{
//            public DisplayPosts(){
//
//            }
//        }


        //Viewing more posts
        JPanel arrowPanel = new JPanel();
        JButton backButton = new JButton();
            backButton.setText("Previous");
        JButton forwardButton = new JButton();
            forwardButton.setText("Next");
        arrowPanel.add(backButton);
        arrowPanel.add(forwardButton);

        frame.add(arrowPanel, BorderLayout.SOUTH);


        frame.setVisible(true);


    }
}
