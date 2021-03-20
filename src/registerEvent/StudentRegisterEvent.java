package registerEvent;

import register.StudentRegister;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class StudentRegisterEvent {

    public void studentRegisterSaveEvent(StudentRegister studentRegister) throws IOException {

        OutputStream fileOutputStream = new FileOutputStream("StudentRegister.txt", true);
        if (!studentRegister.tfStudentName.getText().equals("") && !studentRegister.tfStudentID.getText().equals("")
                && !studentRegister.tfDepartment.getText().equals("") && !studentRegister.tfYear.getText().equals("") &&
                !studentRegister.tfCGPA.getText().equals("")) {
                    fileOutputStream.write((studentRegister.tfStudentID.getText() + ",").getBytes());
                    fileOutputStream.write((studentRegister.tfStudentName.getText() + ",").getBytes());
                    if (studentRegister.rbMale.isSelected()) {
                        fileOutputStream.write((studentRegister.rbMale.getText() + ",").getBytes());
                    } else {
                        fileOutputStream.write((studentRegister.rbFemale.getText() + ",").getBytes());
                    }
                    fileOutputStream.write((studentRegister.tfDepartment.getText() + ",").getBytes());
                    fileOutputStream.write((studentRegister.tfYear.getText() + ",").getBytes());
                    fileOutputStream.write((studentRegister.tfCGPA.getText() + "").getBytes());
                    fileOutputStream.write("\n".getBytes());
                    fileOutputStream.close();
                    studentRegister.stage.close();

                }
    }

    public void studentRegisterEvent() {
        StudentRegister studentRegister = new StudentRegister();
        studentRegister.studentRegister();
    }
}
