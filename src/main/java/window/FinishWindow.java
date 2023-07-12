package window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FinishWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 17);

    public FinishWindow(int computerScore, int playerScore, String playerName) {
        setTitle("Кінець гри");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setVisible(true);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel congratulationsLabel = new JLabel("Вітаємо із завершенням гри!");
        congratulationsLabel.setFont(LABEL_FONT);
        congratulationsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resultLabel = new JLabel();
        resultLabel.setFont(LABEL_FONT);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if (playerScore % 2 == 1) {
            playerScore = playerScore / 2 + 1;
        } else {
            playerScore = playerScore / 2;
        }
        computerScore = computerScore / 2;

        if (computerScore==0){
            resultLabel.setText("Не здавайся так одразу!");
        } else if (computerScore >= playerScore) {
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

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        panel.add(congratulationsLabel, constraints);
        constraints.gridy++;
        panel.add(resultLabel, constraints);
        constraints.gridy++;
        panel.add(computerScoreLabel, constraints);
        constraints.gridy++;
        panel.add(playerScoreLabel, constraints);
        constraints.gridy++;
        constraints.insets = new Insets(50, 5, 5, 5);
        panel.add(newGameButton, constraints);

        setLookAndFeel();
        add(panel);
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
