package deleteEvent;

import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class DeleteEvent {

    public void delete(String s, String txt, Stage stage, String pathName) throws IOException {

        if (s.equalsIgnoreCase("Found")) {
            String newFileString = "temp.txt";
            String currentLine;
            String[] data;

            File oldFile = new File(pathName);
            File newFile = new File(newFileString);

            FileWriter fileWriter = new FileWriter(newFileString);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            FileReader fileReader = new FileReader(pathName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(",");
                if (!(data[0].equalsIgnoreCase(txt))) {
                    printWriter.println(currentLine);
                }
            }

            printWriter.flush();
            printWriter.close();
            fileReader.close();
            bufferedReader.close();
            bufferedWriter.close();
            fileWriter.close();

            Scanner scanner1 = new Scanner(new File("temp.txt"));
            PrintWriter printWriter1 = new PrintWriter(pathName);
            while (scanner1.hasNext()) {
                printWriter1.println(scanner1.nextLine());
            }
            scanner1.close();
            printWriter1.close();

            PrintWriter printWriter2 = new PrintWriter("temp.txt");
            printWriter2.print("");
            printWriter2.close();
            stage.close();
        }
    }
}
