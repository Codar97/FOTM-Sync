import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JLabel title;
    private JTextField leaguePath;
    private JButton browseButton;
    public JPanel panelMain;
    private JButton downloadButton;
    public JProgressBar progressBar;
    private static String path = "C:/Riot Games/League of Legends";

    public UI() {
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fc.showOpenDialog(browseButton);
                path = fc.getSelectedFile().toString();
                leaguePath.setText(fc.getSelectedFile().toString());
            }
        });
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Download dl = new Download(UI.this);
            }
        });
    }

    public static String getPath() {
        return path;
    }

}
