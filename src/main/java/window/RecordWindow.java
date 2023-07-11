package window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RecordWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 500;
    private static final Font LABEL_FONT = new Font("Arial", Font.BOLD, 17);

    private DefaultTableModel tableModel;
    private JTable recordTable;

    public RecordWindow() {
        setTitle("Список рекордів");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new String[]{"Дата", "Ім'я", "Рахунок"}, 0);
        recordTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(recordTable);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < recordTable.getColumnCount(); i++) {
            recordTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        JButton newGameButton = new JButton("Нова гра");
        newGameButton.setPreferredSize(new Dimension(150, newGameButton.getPreferredSize().height));
        newGameButton.setMaximumSize(new Dimension(150, newGameButton.getPreferredSize().height));
        newGameButton.addActionListener(e -> startNewGame());

        JLabel congratulationsLabel = new JLabel("Вітаємо із завершенням гри!");
        congratulationsLabel.setFont(LABEL_FONT);
        congratulationsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(congratulationsLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(newGameButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

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
        });
    }

    public void addRecord(String name, int score) {
        tableModel.addRow(new Object[]{getCurrentDate(), name, score});
    }

    private String getCurrentDate() {
        java.util.Date date = new java.util.Date();
        return new java.sql.Date(date.getTime()).toString();
    }

//    private void showRecordWindow() {
//        RecordWindow recordWindow = new RecordWindow();
//        // Get player score data and add the record to the record window
//        //int playerScore = game.getPlayerScore();
//       // String playerName = game.getPlayer().getPlayerName();
//       // recordWindow.addRecord(playerName, playerScore);
//        recordWindow.setVisible(true);
//
//        // Close the current welcome window
//        //welcomeWindow.dispose();
//    }
}