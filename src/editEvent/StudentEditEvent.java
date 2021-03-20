package editEvent;

import edit.StudentEdit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class StudentEditEvent {

    public void studentEdit(StudentEdit studentEdit, String text) throws FileNotFoundException {

        File file = new File("StudentRegister.txt");
        Scanner scanner = new Scanner(file);
        File file1 = new File("temp1.txt");
        PrintWriter printWriter = new PrintWriter(file1);

        String[] txt = new String[6];
        String sc;
        txt[0] = studentEdit.tfStudentID.getText();
        txt[1] = studentEdit.tfStudentName.getText();
        if (studentEdit.rbMale.isSelected()) {
            txt[2] = studentEdit.rbMale.getText();
        } else {
            txt[2] = studentEdit.rbFemale.getText();
        }
        txt[3] = studentEdit.tfDepartment.getText();
        txt[4] = studentEdit.tfYear.getText();
        txt[5] = studentEdit.tfCGPA.getText();

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

        Scanner scanner1 = new Scanner(new File("temp1.txt"));
        PrintWriter printWriter1 = new PrintWriter(new File("StudentRegister.txt"));

        while(scanner1.hasNext()){
            printWriter1.println(scanner1.nextLine());
        }
        scanner1.close();
        printWriter1.close();

        studentEdit.stage1.close();

    }
}
