import javax.swing.*;

public class Main {
    public static void main(String[] args) {
            createUI();
//          Download d = new Download(null);
    }
    private static void createUI(){
        JFrame frame = new JFrame("FOTM Downloader");
        frame.setContentPane(new UI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
