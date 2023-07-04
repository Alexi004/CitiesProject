package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow {

    JLabel instructionLabel = new JLabel("Введіть, будь ласка, назву міста:");
    JTextField userInputField = new JTextField(15);
    JButton button = new JButton("Зробити хід");
    JLabel computerResponseLabelText = new JLabel("Відповідь комп'ютера:");
    JLabel computerResponseLabel = new JLabel(" ");
    JFrame frameGame = new JFrame("Міста");

    private final int heightFrame = 500;
    private final int widthFrame = 400;

    public int getHeightFrame() {
        return heightFrame;
    }

    public int getWidthFrame() {
        return widthFrame;
    }

    public void createGameWindow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setSize(getWidthFrame(), getHeightFrame());

        int x = (screenSize.width - frameGame.getWidth()) / 2;
        int y = (screenSize.height - frameGame.getHeight()) / 2;

        GridBagLayout gridBagLayout = new GridBagLayout();

        JPanel panel = new JPanel();
        panel.setLayout(gridBagLayout);

        instructionLabel.setPreferredSize(new Dimension(300, 40));
        userInputField.setPreferredSize(new Dimension(150, 30));
        button.setPreferredSize(new Dimension(210, 30));
        computerResponseLabelText.setPreferredSize(new Dimension(300, 40));
        computerResponseLabel.setPreferredSize(new Dimension(300, 20));

        Font font = new Font("Arial", Font.BOLD, 17);
        instructionLabel.setFont(font);
        computerResponseLabel.setFont(font);
        userInputField.setFont(font);
        computerResponseLabelText.setFont(font);
        button.setFont(font);

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        panel.add(instructionLabel, constraints1);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.HORIZONTAL;
        constraints2.gridx = 0;
        constraints2.gridy = 1;
        constraints2.gridheight = 1;
        constraints2.gridwidth = 1;
        panel.add(userInputField, constraints2);

        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.fill = GridBagConstraints.HORIZONTAL;
        constraints3.gridx = 0;
        constraints3.gridy = 2;
        constraints3.gridheight = 1;
        constraints3.gridwidth = 1;
        panel.add(button, constraints3);

        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.fill = GridBagConstraints.HORIZONTAL;
        constraints4.gridx = 0;
        constraints4.gridy = 3;
        constraints4.gridheight = 1;
        constraints4.gridwidth = 1;
        panel.add(computerResponseLabelText, constraints4);

        GridBagConstraints constraints5 = new GridBagConstraints();
        constraints5.fill = GridBagConstraints.HORIZONTAL;
        constraints5.gridx = 0;
        constraints5.gridy = 4;
        constraints5.gridheight = 1;
        constraints5.gridwidth = 1;
        panel.add(computerResponseLabel, constraints5);

        frameGame.add(panel);
        frameGame.setLocation(x, y);
        frameGame.setVisible(true);
    }

    public String getUserInput() {
        String userInputText = "";
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInputText = userInputField.getText();
            }
        });
        return userInputText;
    }

    public void closeWindow() {
        frameGame.dispose();
    }
}
