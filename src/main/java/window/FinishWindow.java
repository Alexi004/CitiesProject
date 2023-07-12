package window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FinishWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 500;
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 17);

    public FinishWindow(int computerScore, int playerScore, String playerName) {
        setTitle("Кінець гри");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        JLabel congratulationsLabel = new JLabel("Вітаємо із завершенням гри!");
        congratulationsLabel.setFont(LABEL_FONT);
        congratulationsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resultLabel = new JLabel();
        resultLabel.setFont(LABEL_FONT);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (computerScore > playerScore) {
            resultLabel.setText("Виграв комп'ютер!");
        } else {
            resultLabel.setText("Виграв гравець " + playerName + "!");
        }

        JLabel computerScoreLabel = new JLabel("Комп'ютер: " + computerScore);
        computerScoreLabel.setFont(LABEL_FONT);
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel playerScoreLabel = new JLabel(playerName + ": " + playerScore);
        playerScoreLabel.setFont(LABEL_FONT);
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton newGameButton = new JButton("Нова гра");
        newGameButton.setPreferredSize(new Dimension(150, newGameButton.getPreferredSize().height));
        newGameButton.setMaximumSize(new Dimension(150, newGameButton.getPreferredSize().height));
        newGameButton.addActionListener(e -> startNewGame());

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.setLayout(new BorderLayout());
        panel.add(congratulationsLabel, BorderLayout.NORTH);
        panel.add(resultLabel, BorderLayout.CENTER);
        panel.add(computerScoreLabel, BorderLayout.CENTER);
        panel.add(playerScoreLabel, BorderLayout.CENTER);
        panel.add(newGameButton, BorderLayout.SOUTH);

        setLookAndFeel();
        add(panel);
        setVisible(true);
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startNewGame() {
        dispose();
        SwingUtilities.invokeLater(() -> {
            WelcomeWindow welcomeWindow = new WelcomeWindow();
            welcomeWindow.setVisible(true);
        });
    }
}
