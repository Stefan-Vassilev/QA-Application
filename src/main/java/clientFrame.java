import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.*;

import static javax.swing.BorderFactory.*;

public class clientFrame {
    SpringApi control = new SpringApi();
     JPanel[] individualPostPanel;
    public clientFrame() {
        //control.getViewable();
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
        individualPostPanel = new JPanel[5];

        String[] calledQuestions = {"What is that", "When", "How", "where", "Whenever"};

        for (int i = 0; i<5; i++){
            individualPostPanel[i] = new JPanel();
            individualPostPanel[i].setSize(1000,120);
            //individualPostPanel[i].setBorder(createEtchedBorder());
            individualPostPanel[i].setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.VERTICAL;


            //Display upvotes
            JLabel upvotes = new JLabel("[Upvote count]");
            c.gridx = 0;
            c.gridy = 0;
            c.weighty = 1;
            c.weightx = 1;
            c.ipadx = 100;
            individualPostPanel[i].add(upvotes, c);


            JLabel answers = new JLabel("[Answers");
            c.gridx = 0;
            c.gridy = 1;
            individualPostPanel[i].add(answers, c);

            JButton question = new JButton(calledQuestions[i]);
            //add identifier for event listener


            c.fill = GridBagConstraints.VERTICAL;
            c.fill = GridBagConstraints.HORIZONTAL;
            c.ipadx = 1000;
            c.ipady = 90;
            c.gridheight = 2;
            c.gridx = 1;
            c.gridy = 0;
            question.setHorizontalTextPosition(JLabel.LEFT);
            individualPostPanel[i].add(question, c);


            question.addActionListener(e -> {
                System.out.println(e);
                //frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

//              Opens seperate window/frame which allows the user to view the question/answers
//              Couldn't call this frame from the new frame so chose to not hide this frame
                //frame.setVisible(false);
                postFrame viewingPosts = new postFrame(question.getText());


            });
            postPanel.add(individualPostPanel[i]);
        }
        //Viewing more posts
        JPanel arrowPanel = new JPanel();
        JButton backButton = new JButton();
            backButton.setText("Back");
        JButton forwardButton = new JButton();
            forwardButton.setText("Next");
        arrowPanel.add(backButton);
        arrowPanel.add(forwardButton);

        frame.add(arrowPanel, BorderLayout.SOUTH);


        frame.setVisible(true);




    }


}
