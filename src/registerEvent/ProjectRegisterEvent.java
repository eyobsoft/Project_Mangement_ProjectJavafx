package registerEvent;

import register.ProjectRegister;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProjectRegisterEvent {

    public void projectRegisterSave(ProjectRegister projectRegister) throws IOException {

        File file = new File("projectRegister.txt");
        OutputStream outputStream = new FileOutputStream(file, true);

        if (!projectRegister.tfTitle.getText().isEmpty() && !projectRegister.tfDescription.getText().isEmpty() &&
                !projectRegister.tfFieldOfStudy.getText().isEmpty() && !projectRegister.tfAdvisorName.getText().isEmpty() &&
                !projectRegister.tfAdvisorID.getText().isEmpty() && !projectRegister.tfSpecialization.getText().isEmpty() &&
                !projectRegister.tfGroupID.getText().isEmpty()) {
            outputStream.write((projectRegister.tfTitle.getText() + ",").getBytes());
            outputStream.write((projectRegister.tfDescription.getText() + ",").getBytes());
            outputStream.write((projectRegister.tfFieldOfStudy.getText() + ",").getBytes());
            outputStream.write((projectRegister.tfAdvisorName.getText() + ",").getBytes());
            outputStream.write((projectRegister.tfAdvisorID.getText() + ",").getBytes());
            outputStream.write((projectRegister.cbQualification.getValue() + ",").getBytes());
            outputStream.write((projectRegister.tfSpecialization.getText() + ",").getBytes());
            outputStream.write((projectRegister.tfGroupID.getText() + "\n").getBytes());
            projectRegister.stage.close();
            outputStream.close();
        }
    }


    public void projectRegisterEvent() {
        ProjectRegister projectRegister = new ProjectRegister();
        projectRegister.projectRegister();
    }

}
