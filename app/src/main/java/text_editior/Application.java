package text_editior;
import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextEditorApp app = new TextEditorApp();
            app.setVisible(true);
        });
    }
}
