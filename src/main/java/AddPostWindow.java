import javax.swing.*;

import java.awt.*;

public class AddPostWindow {
    public AddPostWindow() {
        JFrame addFrame = new JFrame();
        addFrame.setSize(1300,800);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addFrame.setResizable(false);

        JPanel generalPanel = new JPanel();
        generalPanel.setLayout(new BoxLayout(generalPanel, BoxLayout.Y_AXIS));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            addFrame.dispose();
        });
        generalPanel.add(backButton);

        JTextField questionField = new JTextField("Add question");
        generalPanel.add(questionField);

        JTextField descriptionField = new JTextField("Add description (optional)");
        generalPanel.add(descriptionField);

        JButton post = new JButton("Submit");
        generalPanel.add(post);


        addFrame.add(generalPanel);
        addFrame.setVisible(true);
    }
}