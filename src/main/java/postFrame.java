import javax.swing.*;

import java.awt.*;

import static javax.swing.BorderFactory.createEtchedBorder;

public class postFrame {
    public postFrame(String question) {
        JFrame questionFrame = new JFrame();
        questionFrame.setSize(1300,800);
        questionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        questionFrame.setResizable(false);
        //.getContentPane() fixes 'BoxLayout' can't be shared error
        //questionFrame.setLayout(new BoxLayout(questionFrame.getContentPane(), BoxLayout.Y_AXIS));
        questionFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;



        JPanel questionPanel = new JPanel();
        questionPanel.setBorder(createEtchedBorder());
        //questionPanel.setSize(1000,200);
        questionFrame.add(questionPanel);

        JLabel questionText = new JLabel(question);
        questionFrame.add(questionText);
        JLabel questionDescription = new JLabel("[Description]");
        questionFrame.add(questionDescription);


        JLabel label = new JLabel(question);
        questionFrame.add(label);

        questionFrame.setVisible(true);

    }
}
