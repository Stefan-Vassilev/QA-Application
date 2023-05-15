import javax.swing.*;

import java.awt.*;

import static javax.swing.BorderFactory.createEtchedBorder;

public class postFrame {
    SpringApi man = new SpringApi();
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


        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            questionFrame.dispose();

        });
        questionFrame.add(backButton);

        JPanel questionPanel = new JPanel();
        //createEtchedBorder()
        questionPanel.setBorder(createEtchedBorder());
        questionPanel.setLayout(new GridBagLayout());
        GridBagConstraints questionC = new GridBagConstraints();
        //questionPanel.setSize(1000,200);
        c.gridx = 0;
        c.gridy = 1;
        c.ipadx = 1000;
        //c.ipady = 200;
        c.weighty = 1;
        questionPanel.setBackground(Color.red);
        //questionPanel.setSize(1000,400);
        //questionFrame.add(questionPanel,c);

        //code for the question itself
        questionC.gridx = 1;
        questionC.gridy = 0;
        questionC.ipadx = 200;
        questionC.weightx = 0.5;
        //questionC.weightx = 0;
        //questionC.gridwidth = 2;

        //ATTEMPT AT USING JTEXTAREA
        JTextArea questionTextArea = new JTextArea("Question: Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",100, 100);
        questionTextArea.setFont(new Font("verdana", Font.PLAIN, 20));
        //questionTextArea.setPreferredSize(new Dimension(900,200));
        //questionTextArea.setSize(900, 200);
        questionTextArea.setEditable(false);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);

        //TEST
        JScrollPane questionTextScroll = new JScrollPane(questionTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        questionTextScroll.setSize(new Dimension(400,200));

        questionC.fill = GridBagConstraints.BOTH;
        questionC.weighty = 0.5;

        questionPanel.add(questionTextScroll, questionC);

        //code for any extra description to the question
//        JLabel questionDescription = new JLabel("<html>[Description: fafogasgdfiyagsfiyagsdfiaygsdfipyagsfdiyagsdfpsad gfagsdf sagd8 ftcsd 8sad cfsaidfcosudfgiasydgfpadsiyfgaysgdfiygaisydfgiaysgdfiyagsdfigasidyfg]</html>");
        questionC.gridx = 1;
        questionC.gridy = 1;
        JTextArea descriptionTextArea = new JTextArea("[Description: Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.");
        descriptionTextArea.setSize(800,200);
        descriptionTextArea.setEditable(false);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);

        JScrollPane descriptionTextScroll = new JScrollPane(descriptionTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        questionC.fill = GridBagConstraints.BOTH;
        questionC.weighty = 0.5;

        questionPanel.add(descriptionTextScroll, questionC);

        //code for the vote count
        JLabel voteLabel = new JLabel("               [Vote count]");
        questionC.gridx = 0;
        questionC.gridy = 0;
        questionC.ipadx = 200;
//        questionC.ipady = 50;
        questionC.weightx = 0;
        questionPanel.add(voteLabel, questionC);

        //code for the answer count and whether or not it has a final answre
        JLabel answerCountLabel = new JLabel("               [Answer count]");
        questionC.gridx = 0;
        questionC.gridy = 1;
        questionC.ipadx = 200;
        questionC.ipady = 100;
        questionPanel.add(answerCountLabel, questionC);


        questionFrame.add(questionPanel,c);

//      SETTING UP SCROLLPANE
        JScrollPane answerScrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JPanel answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));
        JPanel individualAnswerPanel;
        JLabel testLabel;
        for(int i = 0; i <= 50; i++){
            answerPanel.add(formatAnswer("username " + i + ":   ", "answer  aosudfao sdhof asgf iasgdfi gasdgfouyasg dfug asugd fuagsduogf ouasgduo gfausgd fuogasudg fugasd uofgasuog dfguoa sduof gasuodg fagsd uofgasuydg                    + i"));
            answerPanel.add(Box.createRigidArea(new Dimension(0,50)));
        }
        answerScrollPane.setViewportView(answerPanel);

        //answerScrollPane.setLayout(new BoxLayout());


//      PANEL VERSION
//        JPanel answerPanel = new JPanel();
//        //answerPanel.setSize(800,200);
        c.gridy = 2;
        //c.ipady = 100;
//
//        JLabel testAnswer = new JLabel("Test answer");
//        answerPanel.add(testAnswer);
//        answerPanel.setBackground(Color.black);
//
        questionFrame.add(answerScrollPane, c);

//      adding answers
        JScrollPane addAnswerScroll = new JScrollPane();
        JPanel addAnswerPanel = new JPanel();
        JTextField usernameInput = new JTextField("Username");
        JTextField answerInput = new JTextField("Answer");
        answerInput.setSize(300, 16);
        JButton finalAdd = new JButton("Add");
        addAnswerPanel.add(usernameInput);
        addAnswerPanel.add(answerInput);
        addAnswerPanel.add(finalAdd);

        addAnswerScroll.setViewportView(addAnswerPanel);

        c.gridy = 3;
        questionFrame.add(addAnswerPanel,c);




        questionFrame.setVisible(true);

    }

    public JPanel formatAnswer(String username, String answer){
        JPanel indAnswerPanel = new JPanel();
        JLabel usernameLabel = new JLabel(username);
        JLabel answerLabel = new JLabel(answer);
        indAnswerPanel.add(usernameLabel);
        indAnswerPanel.add(answerLabel);
        return indAnswerPanel;
    }
}
