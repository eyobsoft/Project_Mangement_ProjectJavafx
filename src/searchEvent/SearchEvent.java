package searchEvent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchEvent {

    public String search(String text, String pathName) throws IOException {

        String line = "";
        String[] txt = new String[7];
        File file = new File(pathName);
        FileReader file1 = new FileReader(file);
        BufferedReader scanner = new BufferedReader(file1);
        while ((line = scanner.readLine()) != null) {
            txt = line.split(",");
            if (txt[0].trim().equalsIgnoreCase(text)) {
                return "Found";
            }
        }

        return "Not Found";
    }

}
