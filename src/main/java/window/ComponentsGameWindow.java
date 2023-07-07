package window;

import javax.swing.*;
import java.awt.*;

public class ComponentsGameWindow {
    static JFrame frameGame = new JFrame("Міста");
    static JPanel panel = new JPanel();
    static JButton button = new JButton("Зробити хід");
    static JLabel instructionLabel = new JLabel("Введіть назву міста:");
    static JTextField userInputField = new JTextField(15);
    static JLabel computerResponseLabelText = new JLabel("Відповідь комп'ютера:");
    static JLabel computerResponseLabel = new JLabel("ххххххххххххх");
    static JLabel explanationForGameOver = new JLabel("(Якщо у Вас закінчились варіанти назв міст,");
    static JLabel explanationForGameOver1 = new JLabel("введіть в текстове поле слово \"здаюсь\")");
    private static final String NAME_FONT = "Arial";
    private static final int SIZE_FONT = 17;
    private static final int HEIGHT_FRAME = 500;
    private static final int WIDTH_FRAME = 400;

    public static void createFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setSize(WIDTH_FRAME, HEIGHT_FRAME);

        int x = (screenSize.width - WIDTH_FRAME) / 2;
        int y = (screenSize.height - HEIGHT_FRAME) / 2;
        frameGame.setLocation(x, y);

        frameGame.add(panel);
        frameGame.setVisible(true);
    }

    public static void createButton() {
        button.setPreferredSize(new Dimension(210, 30));
        panel.add(button, new GridBagConstraints(0, 4, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
    }

    public static void createLabel() {
        instructionLabel.setPreferredSize(new Dimension(300, 40));
        computerResponseLabelText.setPreferredSize(new Dimension(300, 40));
        computerResponseLabel.setPreferredSize(new Dimension(300, 20));
        explanationForGameOver.setPreferredSize(new Dimension(300, 20));

        panel.add(instructionLabel, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        panel.add(explanationForGameOver, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        panel.add(explanationForGameOver1, new GridBagConstraints(0, 2, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 10, 0), 0, 0));
        panel.add(computerResponseLabelText, new GridBagConstraints(0, 5, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        panel.add(computerResponseLabel, new GridBagConstraints(0, 6, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
    }

    public static void createTextField() {
        userInputField.setPreferredSize(new Dimension(150, 30));
        panel.add(userInputField, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 10, 0), 0, 0));
    }

    public static void usingFonts() {
        Font font = new Font(NAME_FONT, Font.BOLD, SIZE_FONT);
        button.setFont(font);
        instructionLabel.setFont(font);
        userInputField.setFont(font);
        computerResponseLabelText.setFont(font);
        computerResponseLabel.setFont(font);

        Font font1 = new Font(NAME_FONT, Font.ITALIC, 10);
        explanationForGameOver.setFont(font1);
        explanationForGameOver1.setFont(font1);
    }
}
