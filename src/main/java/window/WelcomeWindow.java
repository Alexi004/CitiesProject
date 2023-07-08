package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomeWindow extends JFrame {
    private static final String FONT_NAME = "Arial";
    private static final int FONT_SIZE = 17;

    public WelcomeWindow() {
        setTitle("Вітаю");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel greetingLabel = new JLabel("Вітаємо вас у грі дитинства і всіх розумників!");
        greetingLabel.setFont(new Font(FONT_NAME, Font.BOLD, FONT_SIZE));

        JLabel nameLabel = new JLabel("Введіть ім'я:");
        nameLabel.setFont(new Font(FONT_NAME, Font.ITALIC, 10));

        JTextField nameTextField = new JTextField(15);

        JButton okButton = new JButton("OK");

        panel.add(greetingLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));
        panel.add(nameLabel, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));
        panel.add(nameTextField, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 10, 10, 10), 0, 0));
        panel.add(okButton, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 170, 10, 170), 0, 0));


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Закриття вікна привітання
                SwingUtilities.invokeLater(() -> {
                    GameWindow gameWindow = new GameWindow();
                    gameWindow.createGameWindow();
                });
            }
        });
        add(panel);
        setVisible(true);
    }

    public void openGameWindow() {
        GameWindow gameWindow = new GameWindow();
        gameWindow.closeWindow();
        dispose();
    }
}
