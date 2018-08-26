import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

public class Download {
public static int progress = 0;
public static UI ui;
    public Download(UI ui) {

        this.ui = ui;
        ui.progressBar.setMaximum(Champions.champions.length-1);
        for (int i = 0; i < Champions.champions.length; i++) {
            new Task(Champions.champions[i]).start();
            ui.progressBar.setStringPainted(true);
        }
    }

}

class Task extends Thread {
    private String champ;

    public Task(String champ) {
        this.champ = champ;
    }

    @Override
    public void run() {
        for (String role : Champions.roles) {
            getFile(role);
        }
        Download.progress++;
        Download.ui.progressBar.setValue(Download.progress);
    }

    public void getFile(String role) {
        try {
            URL url = new URL("http://lolflavor.com/champions/" + champ + "/Recommended/" + champ + "_" + role + "_scrape.json");
            File file = new File(UI.getPath() + "/Config/Champions/" + champ + "/Recommended/" + champ + "_" + role + "_scrape.json");
            FileUtils.copyURLToFile(url, file);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
