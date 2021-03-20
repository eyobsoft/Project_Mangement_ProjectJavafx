package editEvent;

import edit.ProjectEdit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProjectEditEvent {

    public void projectEdit(ProjectEdit projectEdit, String text) throws FileNotFoundException {

        File file = new File("projectRegister.txt");
        Scanner scanner = new Scanner(file);
        File file1 = new File("temp3.txt");
        PrintWriter printWriter = new PrintWriter(file1);

        String[] txt = new String[8];
        String sc;
        txt[0] = projectEdit.tfTitle.getText();
        txt[1] = projectEdit.tfDescription.getText();
        txt[2] = projectEdit.tfFieldOfStudy.getText();
        txt[3] = projectEdit.tfAdvisorName.getText();
        txt[4] = projectEdit.tfAdvisorID.getText();
        txt[5] = (String) projectEdit.cbQualification.getValue();
        txt[6] = projectEdit.tfSpecialization.getText();
        txt[7] = projectEdit.tfGroupID.getText();

        String temp = String.join(",", txt);

        while (scanner.hasNext()) {
            sc = scanner.nextLine();
            String[] scSplit = sc.split(",");
            if (scSplit[0].equalsIgnoreCase(text)) {
                printWriter.println(temp);
            } else {
                printWriter.println(sc);
            }
        }

        scanner.close();
        printWriter.close();

        Scanner scanner1 = new Scanner(new File("temp3.txt"));
        PrintWriter printWriter1 = new PrintWriter("projectRegister.txt");

        while(scanner1.hasNext()){
            printWriter1.println(scanner1.nextLine());
        }
        scanner1.close();
        printWriter1.close();

        projectEdit.stage1.close();
    }
}
