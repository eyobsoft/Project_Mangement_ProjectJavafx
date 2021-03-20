package registerEvent;

import register.GroupRegister;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class GroupRegisterEvent {
    public void groupRegister(GroupRegister groupRegister) throws IOException {
        OutputStream fileOutputStream = new FileOutputStream("GroupRegister.txt", true);
        if (!groupRegister.tfGroupName.getText().equals("") &&
                !groupRegister.tfGroupID.getText().equals("") &&
                (!(groupRegister.tfStudentId1.getText().equals("") ||
                        !(groupRegister.tfStudentId1.getText().equals("") ||
                                !(groupRegister.tfStudentId1.getText().equals(""))
                        )))) {
            fileOutputStream.write((groupRegister.tfGroupID.getText() + ",").getBytes());
            fileOutputStream.write((groupRegister.tfGroupName.getText() + ",").getBytes());
            if (!(groupRegister.tfStudentId1.getText().equals(""))) {
                fileOutputStream.write((groupRegister.tfStudentId1.getText() + ",").getBytes());
            }
            if (!(groupRegister.tfStudentId2.getText().equals(""))) {
                fileOutputStream.write((groupRegister.tfStudentId2.getText() + ",").getBytes());
            } else {
                fileOutputStream.write((null + ",").getBytes());
            }
            if (!(groupRegister.tfStudentId3.getText().equals(""))) {
                fileOutputStream.write((groupRegister.tfStudentId3.getText()).getBytes());
            } else {
                fileOutputStream.write((null + "").getBytes());
            }
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.close();
            groupRegister.stage.close();
        } else {

        }

    }

    public void groupRegisterEvent() {
        GroupRegister groupRegister = new GroupRegister();
        groupRegister.groupRegister();
    }
}
