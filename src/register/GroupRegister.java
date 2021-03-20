package register;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.Declaration;
import registerEvent.GroupRegisterEvent;

import java.io.IOException;

public class GroupRegister {
    Declaration declaration = new Declaration();

    public Label lblGroupName = declaration.getLabel();
    public Label lblGroupID = declaration.getLabel();
    public Label lblStudentID = declaration.getLabel();

    public TextField tfGroupName = declaration.getTextField();
    public TextField tfGroupID = declaration.getTextField();
    public TextField tfStudentId1 = declaration.getTextField();
    public TextField tfStudentId2 = declaration.getTextField();
    public TextField tfStudentId3 = declaration.getTextField();


    public Button btnSave = declaration.getButton();

    public Stage stage = declaration.getStage();

    public void groupRegister() {

        GroupRegisterEvent groupRegisterEvent = new GroupRegisterEvent();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setHgap(15);
        gridPane.setVgap(15);

        lblGroupName.setText("Group Name");
        lblGroupID.setText("Group ID");
        lblStudentID.setText("Student IDs");

        btnSave.setText("Save");
        GridPane.setHalignment(btnSave, HPos.RIGHT);

        gridPane.addColumn(0, lblGroupName, lblGroupID, lblStudentID);
        gridPane.addColumn(1, tfGroupName, tfGroupID, tfStudentId1, tfStudentId2, tfStudentId3, btnSave);
        btnSave.setOnAction(value -> {
            try {
                groupRegisterEvent.groupRegister(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        stage.setScene(new Scene(gridPane));
        stage.setTitle("Group Register");
        stage.setResizable(false);
        stage.show();

    }
}
