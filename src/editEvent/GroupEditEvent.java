package editEvent;

import edit.GroupEdit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GroupEditEvent {
    public void groupEdit(GroupEdit groupEdit, String text) throws FileNotFoundException {
        File file = new File("GroupRegister.txt");
        Scanner scanner = new Scanner(file);
        File file1 = new File("temp2.txt");
        PrintWriter printWriter = new PrintWriter(file1);

        String[] txt = new String[6];
        String sc;
        txt[0] = groupEdit.tfGroupID.getText();
        txt[1] = groupEdit.tfGroupName.getText();
        txt[2] = groupEdit.tfStudentId1.getText();
        groupEdit.tfStudentId2.getText();
        txt[3] = groupEdit.tfStudentId2.getText();
        groupEdit.tfStudentId3.getText();
        txt[4] = groupEdit.tfStudentId3.getText();
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

        Scanner scanner1 = new Scanner(new File("temp2.txt"));
        PrintWriter printWriter1 = new PrintWriter(new File("GroupRegister.txt"));

        while (scanner1.hasNext()) {
            printWriter1.println(scanner1.nextLine());
        }
        scanner1.close();
        printWriter1.close();

        groupEdit.stage1.close();
    }
}
