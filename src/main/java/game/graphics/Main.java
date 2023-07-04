package game.graphics;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GAME");
        JButton button = new JButton("Click");
        JPanel panel = new JPanel();


        panel.add(button);
        frame.add(panel);

        button.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Hello Logos It Academy");
            }
        });


        frame.setVisible(true);
        frame.setSize(300,300);
    }

}

