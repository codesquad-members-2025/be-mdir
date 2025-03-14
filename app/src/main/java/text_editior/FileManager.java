package text_editior;

import javax.swing.*;
import java.io.*;

public class FileManager {
    private File currentFile;

    public void openFile(JTextArea textArea){
        JFileChooser fileChooser = new JFileChooser();
        int userSelect = fileChooser.showOpenDialog(null);

        if (userSelect == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "파일을 읽을 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void saveFile(JTextArea textArea){
        if (currentFile == null) {
            JFileChooser fileChooser = new JFileChooser();
            int userSelect = fileChooser.showSaveDialog(null);

            if (userSelect == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
            } else {
                return;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
            bw.write(textArea.getText());
            JOptionPane.showMessageDialog(null, "파일이 성공적으로 저장되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
            textArea.setText("");
            currentFile = null;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "파일 저장에 실패했습니다.", "오류", JOptionPane.ERROR_MESSAGE);
        }
    }
}
