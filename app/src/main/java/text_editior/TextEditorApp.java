package text_editior;

import javax.swing.*;
import java.awt.*;

public class TextEditorApp extends JFrame {
    private JTextArea textArea;
    private JButton openButton, saveButton;

    public TextEditorApp() {
        setTitle("텍스트 편집기");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        openButton = new JButton("불러오기");
        saveButton = new JButton("저장하기");
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        FileManager fileManager = new FileManager();
        openButton.addActionListener(e -> fileManager.openFile(textArea));
        saveButton.addActionListener(e -> fileManager.saveFile(textArea));

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 10, 50, 10));
        buttonPanel.add(openButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(saveButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.EAST);
    }
}
