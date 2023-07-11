package window;

import javax.swing.*;
import java.awt.*;

public class ComponentsGameWindow {
    private static final String NAME_FONT = "Arial";
    private static final int SIZE_FONT = 17;
    private static final int HEIGHT_FRAME = 500;
    private static final int WIDTH_FRAME = 400;

    private static JFrame frameGame;
    private static JPanel panel;
    private static JButton button;
    private static JLabel instructionLabel;
    private static JTextField userInputField;
    private static JLabel computerResponseLabelText;
    private static JLabel computerResponseLabel;
    private static JLabel explanationForGameOver;
    private static JLabel explanationForGameOver1;

    public static void createFrame() {
        frameGame = new JFrame("Міста");
        panel = new JPanel();
        button = new JButton("Зробити хід");
        instructionLabel = new JLabel("Введіть назву міста:");
        userInputField = new JTextField(15);
        computerResponseLabelText = new JLabel("Відповідь комп'ютера:");
        computerResponseLabel = new JLabel(" ");
        explanationForGameOver = new JLabel("(Якщо у Вас закінчились варіанти назв міст,");
        explanationForGameOver1 = new JLabel("введіть в текстове поле слово \"здаюсь\")");

        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setSize(WIDTH_FRAME, HEIGHT_FRAME);
        frameGame.setResizable(true);
        frameGame.setLocationRelativeTo(null);

        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        instructionLabel.setFont(new Font(NAME_FONT, Font.BOLD, SIZE_FONT));
        explanationForGameOver.setFont(new Font(NAME_FONT, Font.ITALIC, 10));
        explanationForGameOver1.setFont(new Font(NAME_FONT, Font.ITALIC, 10));
        button.setFont(new Font(NAME_FONT, Font.BOLD, SIZE_FONT));
        userInputField.setFont(new Font(NAME_FONT, Font.BOLD, SIZE_FONT));
        computerResponseLabelText.setFont(new Font(NAME_FONT, Font.BOLD, SIZE_FONT));
        computerResponseLabel.setFont(new Font(NAME_FONT, Font.BOLD, SIZE_FONT));

        panel.add(instructionLabel, constraints);
        constraints.gridy++;
        panel.add(explanationForGameOver, constraints);
        constraints.gridy++;
        panel.add(explanationForGameOver1, constraints);
        constraints.gridy++;
        panel.add(userInputField, constraints);
        constraints.gridy++;
        panel.add(button, constraints);
        constraints.gridy++;
        panel.add(computerResponseLabelText, constraints);
        constraints.gridy++;
        panel.add(computerResponseLabel, constraints);

        frameGame.add(panel, BorderLayout.CENTER);
        frameGame.setVisible(true);
    }

    public static void showGameOverDialog() {
        JOptionPane.showMessageDialog(frameGame, "Гра закінчена. Ви програли.", "Кінець гри", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showMessage(String message,String title) {
        JOptionPane.showMessageDialog(frameGame, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static JButton getButton() {
        return button;
    }

    public static String getUserInput() {
        return userInputField.getText();
    }

    public static void setComputerResponse(String response) {
        computerResponseLabel.setText(response);
    }
}